package by.karpov.shop.facade;

import by.karpov.shop.dto.CategoryDto;
import by.karpov.shop.mapper.CategoryMapper;
import by.karpov.shop.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryFacade {
    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    public CategoryDto create(CategoryDto categoryDto) {
        return categoryMapper.map(categoryService.save(categoryMapper.map(categoryDto)));
    }

    public List<CategoryDto> findAll() {
        return categoryService.findAll().stream()
                .map(categoryMapper::map)
                .collect(Collectors.toList());
    }

    public CategoryDto findById(Long id) {
        return categoryMapper.map(categoryService.findById(id));
    }

    public void deleteById(Long id) {
        categoryService.deleteById(id);
    }

    public CategoryDto update(CategoryDto categoryDto) {
        return categoryMapper.map(categoryService.update(categoryMapper.map(categoryDto)));
    }
    public CategoryDto findByName(String name){
        return categoryMapper.map(categoryService.findByName(name));
    }

}
