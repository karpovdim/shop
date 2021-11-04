package by.karpov.shop.repositories;

import by.karpov.shop.models.Price;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Currency;
import java.util.List;

public interface PriceRepository extends JpaRepository<Price, Long> {
    List<Price> findAllByCurrency(Currency currency);
}