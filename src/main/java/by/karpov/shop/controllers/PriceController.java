package by.karpov.shop.controllers;

import by.karpov.shop.dto.PriceDto;
import by.karpov.shop.facade.PriceFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/prices")
public class PriceController {
private final PriceFacade priceFacade;
    @PostMapping
    public ResponseEntity<PriceDto> create( @Valid @RequestBody PriceDto priceDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(priceFacade.create(priceDto));
    }

    @GetMapping
    public ResponseEntity<List<PriceDto>> findAll() {
        return ResponseEntity.ok(priceFacade.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PriceDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(priceFacade.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        priceFacade.deleteById(id);
        return ResponseEntity.accepted().build();
    }

    @PutMapping
    public ResponseEntity<PriceDto> update( @RequestBody PriceDto priceDto) {
        return ResponseEntity.accepted().body(priceFacade.update(priceDto));
    }
}
