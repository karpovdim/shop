package by.karpov.shop.mapper;

import by.karpov.shop.Dto.CategoryDto;
import by.karpov.shop.models.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(componentModel = "spring",
        uses = {CategoriesMapper.class, ProductsMapper.class},
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface CategoryMapper {
    @Mapping(source = "parent.id", target = "parentId")
    CategoryDto map(Category entity);

    @Mapping(source = "parentId", target = "parent.id")
    Category map(CategoryDto dto);

}
