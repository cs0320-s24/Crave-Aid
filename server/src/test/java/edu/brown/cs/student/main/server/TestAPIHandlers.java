package edu.brown.cs.student.main.server;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static spark.Spark.after;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import edu.brown.cs.student.main.server.ResponseHandlers.ResponseHandler;
import edu.brown.cs.student.main.server.mealDBHandlers.CategoryHandler;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import okio.Buffer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spark.Spark;
import spark.utils.IOUtils;

public class TestAPIHandlers {
  private Moshi moshi = new Moshi.Builder().build();
  private JsonAdapter<Map<String, Object>> jsonAdapter;

  @BeforeEach
  public void Server() {
    int port = 4567;
    Spark.port(port);
    after(
        (request, response) -> {
          response.header("Access-Control-Allow-Origin", "*");
          response.header("Access-Control-Allow-Methods", "*");
        });

    ResponseHandler responseHandler = new ResponseHandler();

    //Category handler
    Spark.get("/categorySearch", new CategoryHandler(responseHandler));

    Spark.notFound(
        (request, response) -> {
          response.status(404); // Not Found
          System.out.println("ERROR");
          return "404 Not Found - The requested endpoint does not exist.";
        });
    Spark.init();
    Spark.awaitInitialization();
  }

  @Test
  public void testCategoryEndpointSuccess() throws IOException {
    URL url = new URL("http://localhost:4567/testCategory");
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");
    connection.connect();
    int statusCode = connection.getResponseCode();
    String response = IOUtils.toString(connection.getInputStream());

    assertEquals(200, statusCode, "Expected HTTP status 200");
    assertEquals("Sample Category Response", response, "Unexpected response content");

    connection.disconnect();
  }

  @Test
  public void testCategoryEndpointFailure() throws IOException {
    URL url = new URL("http://localhost:4567/testCategory?invalidParam");
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");
    connection.connect();
    int statusCode = connection.getResponseCode();
    String response = IOUtils.toString(connection.getErrorStream());

    assertEquals(404, statusCode, "Expected HTTP status 404");
    connection.disconnect();
  }

  // Additional tests can be written here to check different scenarios and data formats
}
