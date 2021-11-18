package by.karpov.shop.services;

import by.karpov.shop.exeptions.NotFoundEntityException;
import by.karpov.shop.models.Category;
import by.karpov.shop.models.Product;
import by.karpov.shop.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new NotFoundEntityException(id, Category.class));
    }

    public void deleteById(Long id) {
        categoryRepository.findById(id).orElseThrow(() -> new NotFoundEntityException(id, Category.class));
        categoryRepository.deleteById(id);
    }

    public Category update(Category category) {
        Category categoryByRepository = categoryRepository.findById(category.getId()).orElseThrow();
        if (category.getParent() != null) categoryByRepository.setParent(category.getParent());
        if (category.getCategoryName() != null) categoryByRepository.setCategoryName(category.getCategoryName());
        if (category.getProducts() != null) categoryByRepository.setProducts(category.getProducts());


        return categoryRepository.save(categoryByRepository);
    }

    public Category save(Category category) {
        if (category.getParent() != null) {
            category.getParent().getSub().add(category);
        }
        return categoryRepository.save(category);
    }

    public Category findByName(String name) {
        return categoryRepository.findByCategoryName(name);
    }

}


