package by.karpov.shop.mapper;

import by.karpov.shop.Dto.CreateProductRequest;
import by.karpov.shop.Dto.ProductDto;
import by.karpov.shop.models.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(componentModel = "spring",
        uses = {CategoriesMapper.class, PricesMapper.class},
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT
)
public interface ProductMapper {
    ProductDto map(Product entity);

    Product map(ProductDto dto);

    @Mapping(target = "id", ignore = true)
    Product map(CreateProductRequest dto);
}
