package by.karpov.shop.Dto;

import lombok.Value;

import java.util.List;

@Value
public class CreateProductRequest {
    String productName;
    List<PriceDto> prices;
    List<Long> categories;
}
