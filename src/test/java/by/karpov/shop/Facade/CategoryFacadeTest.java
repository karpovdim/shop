package by.karpov.shop.Facade;

import by.karpov.shop.AbstractIT;
import by.karpov.shop.Dto.CategoryDto;
import by.karpov.shop.repositories.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class CategoryFacadeTest extends AbstractIT {

    @Autowired
    private CategoryFacade testObject;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void create() {
        final var result = testObject.create(CategoryDto.builder().categoryName("cat1").build());
        assertEquals("cat1", result.getCategoryName());
        assertNotNull(result.getId());

        assertDoesNotThrow(() -> categoryRepository.findById(result.getId()).get());
        assertTrue(categoryRepository.findById(result.getId()).isPresent());
    }
}