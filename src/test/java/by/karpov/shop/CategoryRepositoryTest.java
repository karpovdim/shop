package by.karpov.shop;

import by.karpov.shop.models.Category;
import by.karpov.shop.repositories.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
@ActiveProfiles("test")
@DataJpaTest
public class CategoryRepositoryTest {
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void testRepoCategory(){
        List<Category> result = categoryRepository.findAll();
        assertEquals(7,result.size());
    }

}
