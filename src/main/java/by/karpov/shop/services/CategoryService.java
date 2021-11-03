package by.karpov.shop.services;

import by.karpov.shop.exeptions.NotFoundEntityException;
import by.karpov.shop.models.Category;
import by.karpov.shop.models.Price;
import by.karpov.shop.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
        categoryRepository.deleteById(id);
    }

    public Category update(Category category) {
        return categoryRepository.save(category);
    }

    public Category save(Category category) {
      return   categoryRepository.save(category);
    }
}

