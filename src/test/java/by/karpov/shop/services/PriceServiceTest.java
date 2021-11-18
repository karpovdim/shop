package by.karpov.shop.services;

import by.karpov.shop.exeptions.NotFoundEntityException;
import by.karpov.shop.repositories.PriceRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PriceServiceTest {

    private final PriceRepository priceRepository = mock(PriceRepository.class);
    private final PriceService testObject = new PriceService(priceRepository);

    @Test
    void findById_throw() {
        when(priceRepository.findById(anyLong())).thenReturn(Optional.empty());
        assertThrows(NotFoundEntityException.class, () -> testObject.findById(1L));
    }
}