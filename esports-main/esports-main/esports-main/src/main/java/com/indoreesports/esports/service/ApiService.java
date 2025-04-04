package com.indoreesports.esports.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {

    private final RestTemplate restTemplate;

    public ApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void checkRateLimit() {
        String url = "http://localhost:8080/api/tournaments/{id}"; // Replace with your API endpoint

        // Create headers if required
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer YOUR_ACCESS_TOKEN"); // If authentication is needed

        // Create HTTP entity with headers
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Make the API request
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        // Get response headers
        HttpHeaders responseHeaders = response.getHeaders();
        String remainingRequests = responseHeaders.getFirst("X-Rate-Limit-Remaining");

        // Print the remaining requests
        System.out.println("Remaining Requests: " + remainingRequests);
    }
}
