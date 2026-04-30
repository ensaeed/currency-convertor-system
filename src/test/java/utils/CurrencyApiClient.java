package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
//Converts  URL string into a valid URI object
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyApiClient {

    public static double getConvertedAmount(String fromCurrency, String toCurrency, double amount) throws Exception {

        // Build API URL
        String url = "https://api.frankfurter.dev/v2/rates?base="
                + fromCurrency
                + "&quotes="
                + toCurrency;

        // Create HTTP client
        HttpClient client = HttpClient.newHttpClient();

        // Create request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        // Send request
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        // Log response
        System.out.println("Status code: " + response.statusCode());
        System.out.println("API Response: " + response.body());

        // Parse JSON response
        // It takes strings and convert it to Json object
        ObjectMapper mapper = new ObjectMapper();
        JsonNode json = mapper.readTree(response.body());

        // Validate response structure
        if (!json.isArray() || json.isEmpty()) {
            throw new RuntimeException("Unexpected API response: " + response.body());
        }

        // Extract first object from array
        JsonNode firstRate = json.get(0);

        // Extract rate
        if (firstRate.get("rate") == null) {
            throw new RuntimeException("Rate not found in API response: " + response.body());
        }

        double rate = firstRate.get("rate").asDouble();

        // Return converted amount
        return amount * rate;
    }
}