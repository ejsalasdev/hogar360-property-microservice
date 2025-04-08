package com.powerup.propertymicroservice.application.dto.response;

import java.time.LocalDateTime;

public record SaveHouseResponse(String message, LocalDateTime timeStamp) {
}
