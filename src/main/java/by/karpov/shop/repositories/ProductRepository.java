package by.karpov.shop.repositories;

import by.karpov.shop.models.Product;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByProductName(String name);

    List<Product> findByCategories_Id(Long id);

   List<Product> findAllByPrices_AmountEquals(BigDecimal amount);
}