package com.powerup.propertymicroservice.application.dto.response;

import java.time.LocalDateTime;

public record SaveCategoryResponse(String message, LocalDateTime timeStamp) {
}
