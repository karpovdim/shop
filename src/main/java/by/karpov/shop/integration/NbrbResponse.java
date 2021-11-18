package by.karpov.shop.integration;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.math.BigDecimal;

@Value
class NbrbResponse {
    @JsonProperty("Cur_Name")
    String curName;
    @JsonProperty("Cur_OfficialRate")
    BigDecimal curOfficialRate;
    @JsonProperty("Cur_Abbreviation")
    String curNameEng;
}
