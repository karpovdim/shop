package by.karpov.shop.repositories;

import by.karpov.shop.models.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Long> {
}