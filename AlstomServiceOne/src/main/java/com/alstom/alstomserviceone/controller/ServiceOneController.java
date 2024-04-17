package com.alstom.alstomserviceone.controller;

import com.alstom.alstomserviceone.client.SecondServiceClient;
import com.alstom.alstomserviceone.dto.ApiResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/service1")
@RequiredArgsConstructor
@Slf4j
public class ServiceOneController {

    private final SecondServiceClient secondServiceClient;

    @PostMapping("/use-service1")
    @CircuitBreaker(name = "service1CircuitBreaker", fallbackMethod = "fallbackForProcessNumbers")
    public ResponseEntity<ApiResponse> useServiceOne(@RequestBody List<Integer> input) {
        System.out.println("123");
        ResponseEntity<ApiResponse> result = secondServiceClient.processNumbers(input);
        return ResponseEntity.ok(new ApiResponse(200, "Success", result.getBody()));
    }


    public ResponseEntity<ApiResponse> fallbackForProcessNumbers(List<Integer> input, Throwable t) {
        System.out.println("Fallback triggered: " + t.getMessage());
        return ResponseEntity.ok(new ApiResponse(503, "Service Temporarily Unavailable due to " + t.getMessage(), null));
    }

}

