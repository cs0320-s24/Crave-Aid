package edu.brown.cs.student.main.server;

import static spark.Spark.after;

import edu.brown.cs.student.main.server.ResponseHandlers.ResponseHandler;
import edu.brown.cs.student.main.server.mealDBHandlers.CategoryHandler;
import edu.brown.cs.student.main.server.storage.FirebaseUtilities;
import java.io.IOException;
import spark.Spark;

/**
 * A class for running ACS and redlining APIs. ACS and redlining APIs are cached in this
 * implementation with cached results held for 4 minutes.
 */
public class Server {
  static final int port = 3232;

  /** Constructor for the Server class. */
  public Server() {
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

  /**
   * The main method for running a cached server servicing the broadband, redliningData, and
   * redliningSearch endpoints.
   *
   * @param args unused
   */
  public static void main(String[] args) {
    new Server();
    System.out.println("Server started at http://localhost:" + port);
  }
}
