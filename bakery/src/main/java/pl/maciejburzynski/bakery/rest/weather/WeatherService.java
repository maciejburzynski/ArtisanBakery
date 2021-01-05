package pl.maciejburzynski.bakery.rest.weather;

import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import pl.maciejburzynski.bakery.BakeryConfig;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final BakeryConfig bakeryConfig;

    public String getWeather() throws IOException, InterruptedException {
        return getGeneralWeatherJsonObjectFromArray("weather")
                .getString("main");
    }

    public String getPressure() throws IOException, InterruptedException {
        return getGeneralWeatherJsonObjectFromMap("main")
                .get("pressure").toString();
    }

    public String getTemp() throws IOException, InterruptedException {
        return getGeneralWeatherJsonObjectFromMap("main")
                .get("temp").toString();
    }

    private BigDecimal convertKelvinsToCelsius(Double valueInKelvin) {
        return BigDecimal.valueOf(valueInKelvin - 270);

    }

    private JSONObject getGeneralWeatherJsonObjectFromArray(String JSONKeyOfArray) throws IOException, InterruptedException {

        final String KEY = bakeryConfig.getWeatherKey();
        final String CITY = "lodz"; // TODO - to get the city from user registration form

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://api.openweathermap.org/data/2.5/weather?q=" + CITY + "&appid=" + KEY))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONArray jsonArray = new JSONObject(response.body()).getJSONArray(JSONKeyOfArray);
        return jsonArray.getJSONObject(0);
    }

    private JSONObject getGeneralWeatherJsonObjectFromMap(String JSONKeyOfArray) throws IOException, InterruptedException {

        final String KEY = bakeryConfig.getWeatherKey();
        final String CITY = "lodz"; // TODO - to get the city from user registration form

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://api.openweathermap.org/data/2.5/weather?q=" + CITY + "&appid=" + KEY))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return new JSONObject(response.body()).getJSONObject("main");

    }
}
