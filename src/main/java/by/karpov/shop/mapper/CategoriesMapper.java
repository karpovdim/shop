package by.karpov.shop.mapper;

import by.karpov.shop.models.Category;
import by.karpov.shop.services.CategoryService;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

@Mapper(componentModel = "spring")
public abstract class CategoriesMapper {
    @Autowired
    private CategoryService categoryService;

    public Long map(Category entity) {
        return entity.getId();
    }

    public Category map(Long id) {
        if (Objects.isNull(id)) return null;
        return categoryService.findById(id);
    }
}
