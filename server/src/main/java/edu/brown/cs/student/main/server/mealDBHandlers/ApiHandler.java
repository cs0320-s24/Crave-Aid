package edu.brown.cs.student.main.server.mealDBHandlers;

import edu.brown.cs.student.main.server.ResponseHandlers.ResponseHandler;
import java.util.List;
import spark.Request;
import spark.Route;
import spark.Response;

public interface ApiHandler extends Route {
  /**
   * Fetches data from the API based on a constructed URL.
   * @param url The fully constructed URL from which to fetch data.
   * @return The response data as a String.
   */
  String fetchData(String url);

  /**
   * Constructs a URL with specific parameters for the API request.
   * @param type The type of filter or search (e.g., 'category', 'ingredient', 'area').
   * @param parameter The specific parameter for the query (e.g., 'Seafood', 'Chicken', 'Canadian').
   * @return The fully constructed URL as a String.
   */
//  String constructUrl(String type, String parameter);


  Object handle(Request request, Response response) throws Exception;
}
