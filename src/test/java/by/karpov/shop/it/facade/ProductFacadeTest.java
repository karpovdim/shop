package by.karpov.shop.it.facade;

import by.karpov.shop.it.AbstractIT;
import by.karpov.shop.dto.CreateProductRequest;
import by.karpov.shop.dto.PriceDto;
import by.karpov.shop.dto.ProductDto;
import by.karpov.shop.facade.ProductFacade;
import by.karpov.shop.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Currency;

import static org.junit.jupiter.api.Assertions.*;

public class ProductFacadeTest extends AbstractIT {
    @Autowired
    ProductFacade productFacade;
    @Autowired
    ProductRepository productRepository;
    CreateProductRequest createProductRequest;
    ProductDto productDtoResult;

    @BeforeEach
    void setup() {
        PriceDto priceDto = PriceDto.builder()
                .amount(BigDecimal.valueOf(15))
                .currency(Currency.getInstance("EUR"))
                .description("test description")
                .build();

        createProductRequest = CreateProductRequest.builder()
                .productName("testProductName")
                .categories(Arrays.asList(1L, 2L))
                .prices(Arrays.asList(priceDto))
                .build();
        productDtoResult = productFacade.create(createProductRequest);
    }

    @Test
    void create() {
        assertEquals(createProductRequest.getProductName(), productDtoResult.getProductName());
        assertEquals(createProductRequest.getCategories(), productDtoResult.getCategories());
        assertEquals(createProductRequest.getPrices().size(), productDtoResult.getPrices().size());
        assertEquals(createProductRequest.getCategories().size(), productDtoResult.getCategories().size());
        assertDoesNotThrow(()-> productFacade.findById(productDtoResult.getId()));
        assertTrue(productRepository.findById(productDtoResult.getId()).isPresent());
    }

    @Test
    void delete(){
        productRepository.deleteById(productDtoResult.getId());
        assertFalse(productRepository.findById(productDtoResult.getId()).isPresent());
    }
}
