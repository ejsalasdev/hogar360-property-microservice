package com.powerup.propertymicroservice.application.dto.response;

import java.time.LocalDateTime;

public record DeleteCategoryResponse(
        String message,
        LocalDateTime timeStamp
) {
}
