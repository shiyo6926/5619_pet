package com.example.petback.controller;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import com.example.petback.entity.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import java.io.IOException;
import org.json.JSONArray;

@RestController
public class WeatherController {
    private final WebClient webClient;
    private final Logger logger = LoggerFactory.getLogger(WeatherController.class);

    @Value("${openweather.apiKey}")
    private String apiKey;

    @Autowired
    public WeatherController(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.openweathermap.org/data/2.5").build();
    }

    @GetMapping("/weather")
    public Mono<WeatherResponse> getWeather() {
        String city = "Sydney"; // 设置 city 为 "Sydney"
        String apiUrl = "/weather?q=" + city + "&appid=" + apiKey;
        Mono<String> apiResponse = webClient.get()
                .uri(apiUrl)
                .retrieve()
                .bodyToMono(String.class); // 接收响应内容为字符串
        // 记录 API 响应的原始内容
        apiResponse.subscribe(response -> logger.info("Received API response: {}", response));

        Mono<WeatherResponse> weatherResponse = apiResponse.map(response -> parseWeatherResponse(response));

        return weatherResponse;
    }


    private WeatherResponse parseWeatherResponse(String response) {
        WeatherResponse weatherResponse = new WeatherResponse();

        try {
            JSONObject json = new JSONObject(response);

            // 从 JSONObject 中获取 main 对象
            JSONObject main = json.getJSONObject("main");

            // 从 main 对象中获取温度（以开尔文为单位）
            double kelvinTemperature = main.getDouble("temp");

            // 将温度从开尔文转换为摄氏度
            double celsiusTemperature = kelvinTemperature - 273.15;


            // 设置 WeatherResponse 对象的温度属性，保留一位小数
            weatherResponse.setTemperature(Math.round(celsiusTemperature * 10.0) / 10.0);


            // 获取风速数据
            JSONObject wind = json.getJSONObject("wind");
            double windSpeed = wind.getDouble("speed");
            weatherResponse.setWindSpeed(windSpeed);

            // 获取天气描述数据
            JSONArray weatherArray = json.getJSONArray("weather");
            JSONObject weather = weatherArray.getJSONObject(0);
            String weatherClear = weather.getString("main"); // You can choose the appropriate field
            weatherResponse.setWeatherClear(weatherClear);

            System.out.println("Temperature in Celsius: " + celsiusTemperature);
            System.out.println("Wind Speed: " + windSpeed);
            System.out.println("Weather Clear: " + weatherClear);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        return weatherResponse;
    }
}

/*package com.example.petback.controller;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import com.example.petback.entity.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import java.io.IOException;

@RestController
public class WeatherController {
    private final WebClient webClient;
    private final Logger logger = LoggerFactory.getLogger(WeatherController.class);


    @Value("${openweather.apiKey}")
    private String apiKey;

    @Autowired
    public WeatherController(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.openweathermap.org/data/2.5").build();
    }

    @GetMapping("/weather")
    public Mono getWeather(@RequestParam String city) {

        String apiUrl = "/weather?q=" + city + "&appid=" + apiKey;
        Mono<String> apiResponse = webClient.get()
                .uri(apiUrl)
                .retrieve()
                .bodyToMono(String.class); // 接收响应内容为字符串
        // 记录 API 响应的原始内容
        apiResponse.subscribe(response -> logger.info("Received API response: {}", response));

        Mono<WeatherResponse> weatherResponse = apiResponse.map(response -> parseWeatherResponse(response));

        return weatherResponse;

    }
    private WeatherResponse parseWeatherResponse(String response) {
    WeatherResponse weatherResponse =new WeatherResponse();

        JSONObject json = null;
        try {
            json = new JSONObject(response);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

// 从 JSONObject 中获取 main 对象
        JSONObject main = null;
        try {
            main = json.getJSONObject("main");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

// 从 main 对象中获取 temp 属性的值
        double temp = 0;
        try {
            temp = main.getDouble("temp");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        weatherResponse.setTemperature(temp);

    System.out.println("Temperature: " + temp);
    return  weatherResponse;
    }
}
*/