package by.karpov.shop.dto;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class CreateProductRequest {
    String productName;
    List<PriceDto> prices;
    List<Long> categories;
}
