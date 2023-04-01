package star.uz.delivery.controller;


import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@RequestMapping("/address")
public interface AddressController {

    @GetMapping
    HttpEntity<?> getAll();

    @GetMapping("/addressById/{id}")
    HttpEntity<?> getById( @PathVariable UUID id);

}
