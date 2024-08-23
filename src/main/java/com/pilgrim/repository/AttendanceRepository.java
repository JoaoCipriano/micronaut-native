package com.pilgrim.repository;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface AttendanceRepository extends JpaRepository<AttendanceEntity, String> {
}
