package star.uz.delivery.controller;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import star.uz.delivery.payload.ProductDto;

@RequestMapping("/product")
public interface ProductController {

    @PostMapping
    HttpEntity<?> creat (@RequestBody ProductDto productDto);


}
