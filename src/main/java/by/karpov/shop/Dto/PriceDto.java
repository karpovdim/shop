package by.karpov.shop.Dto;

import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.Currency;

@Builder
@Value
public class PriceDto {
    Long id;
    @Positive
    BigDecimal amount;
    @NotBlank
    String description;
    @NotNull
    Currency currency;
}
