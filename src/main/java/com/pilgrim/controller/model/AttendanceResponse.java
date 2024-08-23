package com.pilgrim.controller.model;

import io.micronaut.serde.annotation.Serdeable;

import java.time.LocalDateTime;

@Serdeable
public record AttendanceResponse(String id,
                                 String name,
                                 LocalDateTime createdAt) {
}
