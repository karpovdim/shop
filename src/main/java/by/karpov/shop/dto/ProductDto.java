package by.karpov.shop.dto;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder
@Value
public class ProductDto {
    Long id;
    String productName;
    List<Long> prices;
    List<Long> categories;
}
