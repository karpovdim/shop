package by.karpov.shop.controllers;

import by.karpov.shop.dto.CreateProductRequest;
import by.karpov.shop.dto.ProductDto;
import by.karpov.shop.facade.ProductFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductFacade productFacade;

    @PostMapping
    public ResponseEntity<ProductDto> create(@RequestBody CreateProductRequest productDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productFacade.create(productDto));
    }

    @Operation(summary = "Get a book by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the book",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductDto.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Book not found",
                    content = @Content)})

    @GetMapping()
    public ResponseEntity<Page<ProductDto>> findAll(Pageable pageable) {
        return ResponseEntity.ok(productFacade.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(productFacade.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        productFacade.deleteById(id);
        return ResponseEntity.accepted().build();
    }

    @PutMapping
    public ResponseEntity<ProductDto> update(@RequestBody ProductDto productDto) {
        return ResponseEntity.accepted().body(productFacade.update(productDto));
    }

    @GetMapping("/productName")
    public ResponseEntity<ProductDto> findByName(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productFacade.findByName(productDto));
    }

    @GetMapping("/productPrice/{price}")
    public ResponseEntity<List<ProductDto>> findByPrice(@PathVariable BigDecimal price) {
        return ResponseEntity.ok(productFacade.findByPrice(price));
    }

    @GetMapping("/productCategory/{id}")
    public ResponseEntity<List<ProductDto>> findByCategory(@PathVariable Long id) {
        return ResponseEntity.ok(productFacade.findByCategoryId(id));
    }

    @GetMapping("/currency/{currency}")
    public ResponseEntity<List<ProductDto>> findByCurrency(@PathVariable Currency currency) {
        return ResponseEntity.ok(productFacade.findByCurrency(currency));
    }

    @GetMapping("productBetween/{priceStart}/{priceEnd}")
    public ResponseEntity<List<ProductDto>> findBetween(@PathVariable(name = "priceStart") BigDecimal priceStart, @PathVariable(name = "priceEnd") BigDecimal priceEnd) {
        return ResponseEntity.ok(productFacade.findBetween(priceStart, priceEnd));
    }
}
