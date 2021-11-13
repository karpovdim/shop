package by.karpov.shop.Facade;

import by.karpov.shop.Dto.PriceDto;
import by.karpov.shop.mapper.PriceMapper;
import by.karpov.shop.models.Price;
import by.karpov.shop.services.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Currency;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PriceFacade {
    private final PriceService priceService;
    private final PriceMapper priceMapper;

    public PriceDto create(PriceDto priceDto) {
        return priceMapper.map(priceService.save(priceMapper.map(priceDto)));
    }

    public List<PriceDto> findAll() {
        return priceService.findAll().stream()
                .map(priceMapper::map)
                .collect(Collectors.toList());
    }

    public PriceDto findById(Long id) {
        return priceMapper.map(priceService.findById(id));
    }

    public void deleteById(Long id) {
        priceService.deleteById(id);
    }

    public PriceDto update(PriceDto priceDto) {
        return priceMapper.map(priceService.save(priceMapper.map(priceDto)));
    }
}
