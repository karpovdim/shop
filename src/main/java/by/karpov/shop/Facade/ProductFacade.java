package by.karpov.shop.Facade;

import by.karpov.shop.Dto.ProductDto;
import by.karpov.shop.mapper.ProductMapper;
import by.karpov.shop.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductFacade {
    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductDto create(ProductDto productDto) {
        return productMapper.map(productService.save(productMapper.map(productDto)));
    }

    public List<ProductDto> findAll() {
        return productService.findAll().stream()
                .map(productMapper::map)
                .collect(Collectors.toList());
    }

    public ProductDto findById(Long id) {
        return productMapper.map(productService.findById(id));
    }

    public void deleteById(Long id) {
        productService.deleteById(id);
    }

    public ProductDto update(ProductDto productDto) {
        return productMapper.map(productService.save(productMapper.map(productDto)));
    }

}
