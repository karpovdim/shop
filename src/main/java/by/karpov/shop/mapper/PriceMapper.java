package by.karpov.shop.mapper;

import by.karpov.shop.Dto.PriceDto;
import by.karpov.shop.models.Price;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = ProductsMapper.class)
public interface PriceMapper {
    PriceDto map(Price entity);

    @Mapping(source = "productId", target = "product")
    Price map(PriceDto dto);
}
