package com.pilgrim.controller.model;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.annotation.Nonnull;

@Serdeable
public record AttendanceRequest(@Nonnull String name) {
}
