package com.powerup.propertymicroservice.application.dto.response;

import java.time.LocalDateTime;

public record SaveDepartmentResponse(String message, LocalDateTime timeStamp) {
}