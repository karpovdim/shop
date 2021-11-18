package by.karpov.shop.controllers;

import by.karpov.shop.integration.AbstractControllerTest;
import by.karpov.shop.models.Price;
import by.karpov.shop.repositories.PriceRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Currency;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class PriceControllerTest extends AbstractControllerTest {
    @MockBean
    private PriceRepository priceRepository;
    private static Price price;

    @BeforeAll
    static void init() {
        price = Price.builder()
                .id(1L)
                .amount(BigDecimal.valueOf(15))
                .currency(Currency.getInstance("USD"))
                .description("test")
                .build();
    }

    @Test
    void create() throws Exception {

        when(priceRepository.save(any(Price.class))).thenReturn(price);

        //when(priceRepository.save(eq(Price.builder().id(7L).build()))).thenReturn(price);

        String json = "{" +
                "\"id\": 1," +
                "\"amount\": 15," +
                "\"description\": \"test\"," +
                "\"currency\": \"USD\"" +
                "}";
        mockMvc
                .perform(post("/prices")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.amount").value(15))
                .andExpect(jsonPath("$.description").value("test"))
                .andExpect(jsonPath("$.currency").value("USD"));
    }

    @Test
    void create_throw() throws Exception {
        String json = "{" +
                "\"id\": 1," +
                "\"amount\": -15," +
                "\"description\": \"test\"," +
                "}";
        mockMvc
                .perform(post("/prices")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void findAll() throws Exception {
        when(priceRepository.findAll()).thenReturn(Collections.singletonList(price));
        mockMvc
                .perform(get("/prices"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].id").value(1));
    }

    @Test
    void findById() throws Exception {

        when(priceRepository.findById(eq(1L))).thenReturn(Optional.of(price));
        mockMvc
                .perform(get("/prices/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1));
    }
  @Test
    void findById_throw() throws Exception {

        when(priceRepository.findById(eq(1L))).thenReturn(Optional.empty());
        mockMvc
                .perform(get("/prices/1"))
                .andExpect(status().isNotFound());


    }
//
//    @Test
//    void deleteById() {
//        when(priceRepository.deleteById(eq(1L)));
//    }

    @Test
    void update() {
    }
}