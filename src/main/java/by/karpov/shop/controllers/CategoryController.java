package by.karpov.shop.controllers;

import by.karpov.shop.Dto.CategoryDto;
import by.karpov.shop.Facade.CategoryFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private final CategoryFacade categoryFacade;

    @PostMapping
    public ResponseEntity<CategoryDto> create(@RequestBody CategoryDto categoryDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryFacade.create(categoryDto));
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> findAll() {
        return ResponseEntity.ok(categoryFacade.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryFacade.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        categoryFacade.deleteById(id);
        return ResponseEntity.accepted().build();
    }

    @PutMapping
    public ResponseEntity<CategoryDto> update(@RequestBody CategoryDto categoryDto) {
        return ResponseEntity.accepted().body(categoryFacade.update(categoryDto));
    }
}
