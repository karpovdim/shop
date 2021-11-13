package by.karpov.shop.Facade;

import by.karpov.shop.AbstractIT;
import by.karpov.shop.Dto.PriceDto;
import by.karpov.shop.repositories.PriceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Currency;

import static org.junit.jupiter.api.Assertions.*;

public class PriceFacadeTest extends AbstractIT {
    @Autowired
    private PriceFacade priceFacade;
    @Autowired
    private PriceRepository priceRepository;
    PriceDto priceDto;
    PriceDto priceDtoResult;

    @BeforeEach
    void setup(){
        priceDto = PriceDto.builder()
                .amount(BigDecimal.valueOf(15))
                .currency( Currency.getInstance("EUR"))
                .description("test description")
                .build();
        priceDtoResult = priceFacade.create(priceDto);
    }

    @Test
    void create(){
        assertEquals(priceDto.getAmount(),priceDtoResult.getAmount());
        assertEquals(priceDto.getCurrency(),priceDtoResult.getCurrency());
        assertEquals(priceDto.getDescription(),priceDtoResult.getDescription());
        assertNotNull(priceDtoResult.getId());
        assertDoesNotThrow(()-> priceFacade.findById(priceDtoResult.getId()));
        assertTrue(priceRepository.findById(priceDtoResult.getId()).isPresent());

    }

    @Test
    void delete(){
        priceFacade.deleteById(priceDtoResult.getId());
        assertFalse(priceRepository.findById(priceDtoResult.getId()).isPresent());
    }

}