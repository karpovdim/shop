package by.karpov.shop.mapper;

import by.karpov.shop.models.Price;
import by.karpov.shop.services.PriceService;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class PricesMapper {
    @Autowired
    private PriceService priceService;

    public Long map(Price entity) {
        return entity.getId();
    }

    public Price map(Long id) {
        return priceService.findById(id);
    }
}
