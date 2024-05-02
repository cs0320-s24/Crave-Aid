package edu.brown.cs.student.main.server.parseFilterHelpers;

import edu.brown.cs.student.main.server.ingredientHandlers.Utils;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;

public class Caller {

  // Takes in a json containing multiple items fitting multi ingredient choice
  /**
   * shape: { "meals": [ { "strMeal": "Chicken Fajita Mac and Cheese", "strMealThumb":
   * "https://www.themealdb.com/images/media/meals/qrqywr1503066605.jpg", "idMeal": "52818" }, {
   * "strMeal": "Chicken Ham and Leek Pie", "strMealThumb":
   * "https://www.themealdb.com/images/media/meals/xrrtss1511555269.jpg", "idMeal": "52875" } ] }
   */
  public static String[] parseMealIDFromMulti(String json) {
    // Convert JSON string to JSON Object
    JSONObject obj = new JSONObject(json);
    JSONArray meals = obj.getJSONArray("meals");

    // get idMeal from each recipe
    String[] idMeals = new String[meals.length()];

    for (int i = 0; i < meals.length(); i++) {
      JSONObject meal = meals.getJSONObject(i);
      idMeals[i] = meal.getString("idMeal");
    }

    return idMeals;
  }

  public static String[][] parse(String[] idArr, String[] ingredients) throws IOException {

    // get idMeal from each recipe
    String[][] mealInfo = new String[idArr.length][29];
    for (int i = 0; i < idArr.length; i++) {
      // get the json from the query to pertaining mealId

      // TODO check validity and try catch IOException
      String url = "https://www.themealdb.com/api/json/v1/1/lookup.php?i=" + idArr[i];
      String json = Utils.fullApiResponseString(url);

      // turn Json into object
      JSONObject obj = new JSONObject(json);
      // follow previous shape to enter singular object with all info, may be redundant for
      // functions sake
      JSONArray meals = obj.getJSONArray("meals");
      JSONObject meal = meals.getJSONObject(0);

      // loops over each ingredient field and adds it to corresponding array space
      int emptyCount = 0;
      int sharedCount = 0;

      for (int j = 0; j < 20; j++) {
        String ing = meal.getString("strIngredient" + j);
        mealInfo[i][j] = ing;

        // get total ingredient count
        if (ing.isEmpty()) {
          emptyCount++;
        }

        for (String x : ingredients) {
          if (x.equals(ing)) {
            sharedCount++;
          }
        }
      }
      // pass individual recipe info to 2d array in respective row
      mealInfo[i][20] = meal.getString("idMeal"); // id
      mealInfo[i][21] = meal.getString("strMeal"); // name
      mealInfo[i][22] = meal.getString("strCategory"); // category
      mealInfo[i][23] = meal.getString("strSource"); // website link
      mealInfo[i][24] = meal.getString("strYoutube"); // youtube
      mealInfo[i][25] = meal.getString("strMealThumb"); // thumbnail
      mealInfo[i][26] = meal.getString("strInstructions"); // instructions
      mealInfo[i][27] = Integer.toString(emptyCount); // number of total ingredients in recipe;
      mealInfo[i][28] =
          Integer.toString(sharedCount); // number of ingredients in recipe and search;
    }
    return mealInfo;
  }

}
