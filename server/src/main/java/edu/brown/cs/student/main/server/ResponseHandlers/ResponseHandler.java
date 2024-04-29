package edu.brown.cs.student.main.server.ResponseHandlers;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import edu.brown.cs.student.main.server.handlers.Utils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

  /**
   * Creates a standardized response map from API data.
   * @param status The status of the operation ('success' or 'error').
   * @param message Descriptive message about the response.
   * @param data The actual data received from the API or any relevant data to include.
   * @return A map representing the structured response.
   */
  public Map<String, Object> createResponse(String status, String message, Object data) {
    Map<String, Object> responseMap = new HashMap<>();
    responseMap.put("status", status);
    responseMap.put("message", message);
    responseMap.put("data", data);
    return responseMap;
  }

  public Map<String, Object> createErrorResponse(Exception e) {
    return createResponse("error", e.getMessage(), null);
  }

  /**
   * Serializes a response map to a JSON string using GSON.
   * @param responseMap The map to serialize.
   * @return A JSON string representation of the map.
   */
  public String toJson(Map<String, Object> responseMap) {
    return Utils.toMoshiJson(responseMap);
  }
}
