package com.alstom.alstomserviceone.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    private Long timestamp;
    private HttpStatus status;
    private String message;
    private String errorDetail;
    private String path;
}
