package by.karpov.shop.facade;

import by.karpov.shop.exeptions.NotFoundEntityException;
import by.karpov.shop.mapper.PriceMapper;
import by.karpov.shop.mapper.PriceMapperImpl;
import by.karpov.shop.services.PriceService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PriceFacadeTest {

    private final PriceService priceService = mock(PriceService.class);
    private final PriceMapper priceMapper = new PriceMapperImpl();
    private final PriceFacade testObject = new PriceFacade(priceService, priceMapper);

    @Test
    void findById() {
        when(priceService.findById(anyLong())).thenThrow(new NotFoundEntityException(1L, Object.class));
        assertThrows(NotFoundEntityException.class, () -> testObject.findById(1L));
    }
}