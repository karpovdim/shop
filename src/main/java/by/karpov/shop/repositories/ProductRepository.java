package by.karpov.shop.repositories;

import by.karpov.shop.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByProductName(String name);

    List<Product> findByCategories_Id(Long id);

   List<Product> findAllByPrices_AmountEquals(BigDecimal amount);

    List<Product> findAllByPrices_Currency(Currency currency);

    @Query("select p from Product p left join p.prices prices where prices.amount >= ?1 and prices.amount <= ?2")
    List<Product> findProductBetween(BigDecimal amountStart, BigDecimal amountEnd);
    Page<Product> findAll(Pageable pageable);
}