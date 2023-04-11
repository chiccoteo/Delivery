package star.uz.delivery.controller;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import star.uz.delivery.payload.RestaurantDto;

import java.util.UUID;

@RequestMapping("/restaurant")
public interface RestaurantController {

    @PostMapping
    HttpEntity<?> creat(@RequestBody RestaurantDto dto);

    @PutMapping("/{id}")
    HttpEntity<?> update(@PathVariable UUID id,@RequestBody RestaurantDto dto);

    @GetMapping("byId/{id}")
    HttpEntity<?> getById(@PathVariable UUID id);

    @GetMapping("/all")
    HttpEntity<?> getAllRestaurant();

    @DeleteMapping("/{id}")
    HttpEntity<?> delete(@PathVariable UUID id);



}
