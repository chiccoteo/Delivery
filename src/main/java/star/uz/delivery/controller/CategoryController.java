package star.uz.delivery.controller;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import star.uz.delivery.payload.CategoryDto;

@RequestMapping("/category")
public interface CategoryController {

    @PostMapping
    HttpEntity<?> creat(@RequestBody CategoryDto categoryDto );

    @PutMapping("/{id}")
    HttpEntity<?>update(@PathVariable Long id,@RequestBody CategoryDto categoryDto);

    @GetMapping("/getAll")
    HttpEntity<?> getAll();

    @DeleteMapping("/{id}")
    HttpEntity<?> deleteCategory(@PathVariable Long id);



}
