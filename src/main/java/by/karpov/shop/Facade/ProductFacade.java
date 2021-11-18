package by.karpov.shop.Facade;

import by.karpov.shop.Dto.CreateProductRequest;
import by.karpov.shop.Dto.ProductDto;
import by.karpov.shop.mapper.ProductMapper;
import by.karpov.shop.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductFacade {
    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductDto create(CreateProductRequest productDto) {

        return productMapper.map(productService.save(productMapper.map(productDto)));
    }

    public Page<ProductDto> findAll(Pageable pageable) {
        List<ProductDto> list = productService.findAll(pageable).getContent().stream()
                .map(productMapper::map)
                .collect(Collectors.toList());
        return new PageImpl<>(list,pageable, list.size());
    }

    public ProductDto findById(Long id) {
        return productMapper.map(productService.findById(id));
    }

    public void deleteById(Long id) {
        productService.deleteById(id);
    }

    public ProductDto update(ProductDto productDto) {
        return productMapper.map(productService.update(productMapper.map(productDto)));
    }

    public ProductDto findByName(ProductDto productDto) {
        return productMapper.map(productService.findByName(productDto.getProductName()));
    }

    public List<ProductDto> findByPrice(BigDecimal price) {
        return productService.findByPrice(price).stream()
                .map(productMapper::map)
                .collect(Collectors.toList());
    }

    public List<ProductDto> findByCategoryId(Long id) {
        return productService.findByCategoryId(id).stream()
                .map(productMapper::map)
                .collect(Collectors.toList());
    }

    public List<ProductDto> findByCurrency(Currency currency) {
        return productService.findByCurrency(currency).stream()
                .map(productMapper::map)
                .collect(Collectors.toList());
    }

    public List<ProductDto> findBetween(BigDecimal priceStart, BigDecimal priceEnd) {
        return productService.findBetween(priceStart, priceEnd).stream()
                .map(productMapper::map)
                .collect(Collectors.toList());
    }
}
