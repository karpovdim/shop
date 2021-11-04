package by.karpov.shop.Dto;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.util.Currency;

@Builder
@Value
public class PriceDto {
    Long id;
    BigDecimal amount;
    String description;
    Currency currency;
    Long productId;
}
