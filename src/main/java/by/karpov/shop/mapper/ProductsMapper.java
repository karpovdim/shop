package by.karpov.shop.mapper;

import by.karpov.shop.models.Product;
import by.karpov.shop.services.ProductService;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class ProductsMapper {
    @Autowired
    private ProductService productService;

    public Long map(Product entity) {
        return entity.getId();
    }

    public Product map(Long id) {
        return productService.findById(id);
    }
}
