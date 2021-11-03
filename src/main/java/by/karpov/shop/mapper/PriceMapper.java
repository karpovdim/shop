package by.karpov.shop.mapper;

import by.karpov.shop.Dto.PriceDto;
import by.karpov.shop.models.Price;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceMapper {
    PriceDto map(Price entity);

    Price map(PriceDto dto);


}
