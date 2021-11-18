package by.karpov.shop.services;

import by.karpov.shop.exeptions.NotFoundEntityException;
import by.karpov.shop.models.Product;
import by.karpov.shop.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll( pageable);
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new NotFoundEntityException(id, Product.class));
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public Product update(Product product) {
        Product productById = productRepository.findById(product.getId()).orElseThrow(() -> new NotFoundEntityException(product.getId(), Product.class));
        if (product.getProductName() != null) productById.setProductName(product.getProductName());
        if (product.getCategories() != null) productById.setCategories(product.getCategories());
        // if (product.getPrices() != null) productById.setPrices(product.getPrices());
        return productRepository.save(product);
    }

    public Product save(Product product) {
        product.getCategories().forEach(cat -> cat.getProducts().add(product));
        return productRepository.save(product);
    }

    public Product findByName(String name) {
        return productRepository.findByProductName(name);
    }

    public List<Product> findByPrice(BigDecimal price) {
        return productRepository.findAllByPrices_AmountEquals(price);
    }

    public List<Product> findByCategoryId(Long id) {
        return productRepository.findByCategories_Id(id);
    }

    public List<Product> findByCurrency(Currency currency) {
        return productRepository.findAllByPrices_Currency(currency);
    }

    public List<Product> findBetween(BigDecimal priceStart, BigDecimal priceEnd) {
        return productRepository.findProductBetween(priceStart, priceEnd);
    }
}
