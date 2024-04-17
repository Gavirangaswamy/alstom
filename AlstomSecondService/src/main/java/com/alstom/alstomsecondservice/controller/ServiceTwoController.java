package com.alstom.alstomsecondservice.controller;

import com.alstom.alstomsecondservice.dto.ApiResponse;
import com.alstom.alstomsecondservice.service.AlstomSecondService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/service2")
@RequiredArgsConstructor
@Slf4j
public class ServiceTwoController {


    private final AlstomSecondService service;
    @PostMapping("/process")
    public ResponseEntity<ApiResponse> processNumbers(@RequestBody List<Integer> input) {
        try {
            log.info("Received request to process numbers: {}", input);
            List<Integer> transformedList = service.listTransformation(input);
            ApiResponse response = new ApiResponse(200, "Success", transformedList);
            log.info("Processed numbers successfully: {}", transformedList);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Error processing numbers: ", e);
            return ResponseEntity.internalServerError()
                    .body(new ApiResponse(500, "Internal Server Error", null));
        }
    }
}
