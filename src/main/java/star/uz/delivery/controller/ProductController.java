package star.uz.delivery.controller;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import star.uz.delivery.payload.ProductDto;

import java.util.UUID;

@RequestMapping("/product")
public interface ProductController {

    @PostMapping
    HttpEntity<?> creat (@RequestBody ProductDto productDto);

    @PutMapping("/{id}")
    HttpEntity<?> update(@PathVariable UUID id,@RequestBody ProductDto dto);

    @GetMapping("/getAll")
    HttpEntity<?> getAllProduct();

    @GetMapping("/detProductById/{id}")
    HttpEntity<?> getById(@PathVariable UUID id);

    @DeleteMapping("/{id}")
    HttpEntity<?> delete( @PathVariable UUID id);

}
