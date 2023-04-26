package ru.alekseyivanov;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.alekseyivanov.model.Weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class Main {
    private static final String apiKey = "e87205cf0e2383e6ce646bcdb1db0902";

    public static void main(String[] args) throws IOException, InterruptedException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Введите название города: ");
            String city;
            while (!(city = bufferedReader.readLine()).isEmpty()) {
                HttpClient client = HttpClient.newHttpClient();

                HttpRequest request = HttpRequest.newBuilder(URI.create(
                            String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric&lang=ru",
                                    city, apiKey)))
                        .header("accept", "application/json")
                        .timeout(Duration.of(5, ChronoUnit.SECONDS))
                        .GET()
                        .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                ObjectMapper objectMapper = new ObjectMapper();
                Weather weather = objectMapper.readValue(response.body(), Weather.class);

                System.out.println(weather);
            }
        }
    }
}