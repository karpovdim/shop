package by.karpov.shop.services;

import by.karpov.shop.exeptions.NotFoundEntityException;
import by.karpov.shop.models.Product;
import by.karpov.shop.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new NotFoundEntityException(id, Product.class));
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public Product update(Product product) {
        return productRepository.save(product);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }
}