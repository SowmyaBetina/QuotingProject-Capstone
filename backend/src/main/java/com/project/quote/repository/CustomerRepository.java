package com.project.quote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.quote.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
