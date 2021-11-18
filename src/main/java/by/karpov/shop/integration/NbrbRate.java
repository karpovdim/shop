package by.karpov.shop.integration;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
public class NbrbRate {
    String curName;
    String curNameEng;
    BigDecimal curOfficialRate;

}
