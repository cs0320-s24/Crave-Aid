package edu.brown.cs.student.main.server;

import static spark.Spark.after;

import edu.brown.cs.student.main.server.externalHandlers.RecipeCallHandler;
import edu.brown.cs.student.main.server.handlers.ClearUserHandler;
import edu.brown.cs.student.main.server.ingredientHandlers.AddIngredientHandler;
import edu.brown.cs.student.main.server.ingredientHandlers.ClearIngredientsHandler;
import edu.brown.cs.student.main.server.ingredientHandlers.GetAllIngredientsHandler;
import edu.brown.cs.student.main.server.ingredientHandlers.RemoveIngredientHandler;
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

    // PINS
    FirebaseUtilities firebase_utility = null;
    try {
      firebase_utility = new FirebaseUtilities();
    } catch (IOException e) {
      e.printStackTrace();
      return;
    }

    Spark.get("/add-ingredient", new AddIngredientHandler(firebase_utility));
    Spark.get("/remove-ingredient", new RemoveIngredientHandler(firebase_utility));
    Spark.get("/get-ingredients", new GetAllIngredientsHandler(firebase_utility));
    Spark.get("/clear-ingredients", new ClearIngredientsHandler(firebase_utility));
    Spark.get("/get-recipes", new RecipeCallHandler());

    // CLEARING USER (for e2e testing)
    Spark.get("/clear-user", new ClearUserHandler(firebase_utility));

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
