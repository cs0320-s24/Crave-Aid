package edu.brown.cs.student.main.server.mealDBHandlers;

import edu.brown.cs.student.main.server.ResponseHandlers.ResponseHandler;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import spark.Request;
import spark.Response;

public class CategoryHandler implements ApiHandler {
  private final HttpClient httpClient;

  private final ResponseHandler responseHandler;

  public CategoryHandler(ResponseHandler responseHandler) {
    this.httpClient = HttpClient.newHttpClient();
    this.responseHandler = responseHandler;
  }

  @Override
  public Object handle(Request request, Response response) throws Exception {
    String url = constructUrl(request.queryParams("type"), request.queryParams("parameter"));
    return fetchData(url);
  }

  @Override
  public String fetchData(String url) {
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(url))
        .GET()
        .build();
    try {
      HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
      if (response.statusCode() == 200) {
        return responseHandler.toJson(responseHandler.createResponse("success", "Data fetched successfully", response.body()));
      } else {
        return responseHandler.toJson(responseHandler.createResponse("error", "Failed to fetch data", null));
      }
    } catch (IOException | InterruptedException e) {
      Thread.currentThread().interrupt(); // Properly handle InterruptedException
      return responseHandler.toJson(responseHandler.createErrorResponse(e)); // Use the response handler for error handling
    }
  }

  public String constructUrl(String type, String parameter) {
    return String.format("https://www.themealdb.com/api/json/v1/1/filter.php?%s=%s", type, parameter);
  }
}
