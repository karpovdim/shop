package by.karpov.shop.it;

import by.karpov.shop.it.AbstractIT;
import by.karpov.shop.models.Category;
import by.karpov.shop.repositories.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CategoryRepositoryTest extends AbstractIT {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void testRepoCategory() {
        List<Category> result = categoryRepository.findAll();
        assertEquals(7, result.size());
    }

}
