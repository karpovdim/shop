package by.karpov.shop.repositories;

import by.karpov.shop.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}