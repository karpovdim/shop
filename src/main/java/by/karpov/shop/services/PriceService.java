package by.karpov.shop.services;

import by.karpov.shop.exeptions.NotFoundEntityException;
import by.karpov.shop.models.Price;
import by.karpov.shop.repositories.PriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PriceService {
    private final PriceRepository priceRepository;


    public Price findById(Long id) {
        return priceRepository.findById(id).orElseThrow(() -> new NotFoundEntityException(id, Price.class));
    }

    public List<Price> findAll() {
        return priceRepository.findAll();
    }


    public void deleteById(Long id) {
        priceRepository.deleteById(id);
    }

    public Price update(Price price) {
        return priceRepository.save(price);
    }

    public Price save(Price price) {
        return priceRepository.save(price);
    }
}
