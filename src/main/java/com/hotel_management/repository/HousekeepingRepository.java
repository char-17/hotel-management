package com.hotel_management.repository;

import com.hotel_management.model.Housekeeping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HousekeepingRepository extends JpaRepository<Housekeeping, Long> {
}
