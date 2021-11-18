package by.karpov.shop.integration;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class NbrbController {
    private final NbrbService nbrbRate;
    @GetMapping("/rate/{id}")
    public ResponseEntity<NbrbRate> getRate(@PathVariable Long id) {
        return ResponseEntity.ok(nbrbRate.getRate(id));
    }
}
