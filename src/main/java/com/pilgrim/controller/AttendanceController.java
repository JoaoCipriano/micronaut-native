package com.pilgrim.controller;

import com.pilgrim.controller.model.AttendanceRequest;
import com.pilgrim.controller.model.AttendanceResponse;
import com.pilgrim.infrastructure.dynamodb.DynamoRepository;
import com.pilgrim.repository.AttendanceEntity;
import com.pilgrim.repository.AttendanceRepository;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.ObjectNotFoundException;

import java.time.LocalDateTime;

@Slf4j
@Controller("/attendances")
@RequiredArgsConstructor
public class AttendanceController {

    private final AttendanceRepository attendanceRepository;
    private final DynamoRepository dynamoRepository;

    @Post
    public AttendanceResponse save(@Body AttendanceRequest request) {
        var entity = new AttendanceEntity();
        entity.setName(request.name());
        entity.setCreatedAt(LocalDateTime.now());
        entity = attendanceRepository.save(entity);
        return new AttendanceResponse(entity.getId(), entity.getName(), entity.getCreatedAt());
    }

    @Get("/{id}")
    public AttendanceResponse get(@PathVariable String id) {
        var membership = dynamoRepository.getItem("PREMIUM", 0);
        log.info("MEMBERSHIP: {}", membership);
        var entity = attendanceRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, AttendanceEntity.class));
        return new AttendanceResponse(entity.getId(), entity.getName(), entity.getCreatedAt());
    }
}
