package ru.alekseyivanov;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.alekseyivanov.model.Weather;

import java.io.*;
import java.net.URI;
import java.net.http.*;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Properties;

public class Main {
    private static String apiKey;

    static {
        try (InputStream inputStream = new FileInputStream("src/main/resources/application.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);
            apiKey = properties.getProperty("apiKey");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Введите название города: ");
            String city;
            while (!(city = bufferedReader.readLine()).isBlank()) {
                HttpClient client = HttpClient.newHttpClient();

                // Подготавливаем запрос для отправки на сервер
                HttpRequest request = HttpRequest.newBuilder(URI.create(
                            String.format("https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric&lang=ru",
                                    city, apiKey)))
                        .header("accept", "application/json")
                        .timeout(Duration.of(5, ChronoUnit.SECONDS))
                        .GET()
                        .build();

                // Отправляем запрос и получаем ответ от сервера в виде строки содержащей json
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                // При неправильном вводе названия города запрос возвращает код 404 с сообщением "city not found"
                if (response.statusCode() == 404 && response.body().contains("city not found")) {
                    System.out.printf("Город %s не найден%n", city);
                    System.out.print("Введите название города: ");
                    continue;
                } else if (response.statusCode() == 401 && response.body().contains("Invalid API key")) {
                    System.out.println("Неверный API-ключ.");
                    break;
                } else if (response.statusCode() == 429 && response.body().contains("")) {

                }

                // Преобразовываем из строки содержащей json в объект класса Weather
                ObjectMapper objectMapper = new ObjectMapper();
                Weather weather = objectMapper.readValue(response.body(), Weather.class);

                // Теперь мы можем использовать наши данные, например, из объекта weather можем получить
                // температуру, давление или любые другие десериализованные данные данные
                System.out.println(weather);
                System.out.println();

                // Или можем так
                System.out.println("Температура в г. " + weather.getName() + ": " + weather.getMain().getTemp() + "\u00B0C");
                System.out.println();

                System.out.print("Введите название города: ");
            }
        }
    }
}
