package org.example;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class Consumer {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        //GET
        String url = "https://reqres.in/api/users/2";
        String response = restTemplate.getForObject(url, String.class);
        System.out.println(response);
        System.out.println("======================");

        //POST
        Map<String, String> jsonToSend = new HashMap<>();
        jsonToSend.put("name", "Test name");
        jsonToSend.put("job", "Test jop");

        //Нужно упаковать для запроса, мапа преобразуется в JSON
        HttpEntity<Map<String, String>> request = new HttpEntity<>(jsonToSend);
        String urlRequest = "https://reqres.in/api/users";

        String response2 = restTemplate.postForObject(urlRequest, request, String.class);
        System.out.println(response2);
    }
}
