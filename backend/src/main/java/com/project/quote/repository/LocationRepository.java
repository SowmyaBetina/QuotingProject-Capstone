package com.project.quote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.quote.entity.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
}

