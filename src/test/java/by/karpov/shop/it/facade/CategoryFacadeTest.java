package by.karpov.shop.it.facade;

import by.karpov.shop.it.AbstractIT;
import by.karpov.shop.dto.CategoryDto;
import by.karpov.shop.facade.CategoryFacade;
import by.karpov.shop.repositories.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class CategoryFacadeTest extends AbstractIT {

    @Autowired
    private CategoryFacade categoryFacade;
    @Autowired
    private CategoryRepository categoryRepository;
    CategoryDto categoryDto;
    CategoryDto categoryDtoResult;

    @BeforeEach
void setup(){
          categoryDto = CategoryDto.builder().categoryName("categoryDto").build();
         categoryDtoResult = categoryFacade.create(categoryDto);
    }

    @Test
    void create() {
        assertEquals(categoryDto.getCategoryName(),categoryDtoResult.getCategoryName());
        assertNotNull(categoryDtoResult.getId());
        assertDoesNotThrow(()-> categoryFacade.findById(categoryDtoResult.getId()));
        assertTrue(categoryRepository.findById(categoryDtoResult.getId()).isPresent());
    }
    @Test
    void delete(){
        categoryFacade.deleteById(categoryDtoResult.getId());
        assertFalse(categoryRepository.findById(categoryDtoResult.getId()).isPresent());

    }
}