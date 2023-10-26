package com.project.quote.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.project.quote.entity.Price;

public interface PriceRepository extends JpaRepository<Price, Integer> {
     Optional<Price> findByProductId(int productId);

}
