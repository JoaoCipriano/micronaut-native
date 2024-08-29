package com.pilgrim.config;

import io.micronaut.core.annotation.ReflectionConfig;
import org.hibernate.generator.internal.CurrentTimestampGeneration;

@ReflectionConfig(
        type = CurrentTimestampGeneration.class
)
public class GraalConfig {
}
