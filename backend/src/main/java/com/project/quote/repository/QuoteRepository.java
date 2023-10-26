package com.project.quote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.quote.entity.Quote;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
}