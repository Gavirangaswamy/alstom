package com.alstom.alstomsecondservice.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResponseStatusEnum {

    SUCCESS(1, "Operation completed successfully"),
    ERROR(0, "Operation failed due to an error");

    private final int statusCode;

    private final String statusMessage;
}
