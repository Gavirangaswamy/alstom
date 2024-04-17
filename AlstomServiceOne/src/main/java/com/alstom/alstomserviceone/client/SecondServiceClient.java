package com.alstom.alstomserviceone.client;

import com.alstom.alstomserviceone.dto.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "service2")
public interface SecondServiceClient {

    @PostMapping("/service2/process")
    ResponseEntity<ApiResponse> processNumbers(List<Integer> input);
}

