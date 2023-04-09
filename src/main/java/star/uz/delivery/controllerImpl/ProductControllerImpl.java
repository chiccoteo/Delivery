package star.uz.delivery.controllerImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import star.uz.delivery.controller.ProductController;
import star.uz.delivery.payload.ApiResponse;
import star.uz.delivery.payload.ProductDto;
import star.uz.delivery.service.ProductService;

import java.util.UUID;
@RestController
@RequiredArgsConstructor
public class ProductControllerImpl implements ProductController {
    private final ProductService service;
    @Override
    public HttpEntity<?> creat(ProductDto productDto) {
        ApiResponse<?> response = service.creatProduct(productDto);
        return ResponseEntity.status(response.isSuccess()?201:409).body(response);
    }

    @Override
    public HttpEntity<?> update(UUID id, ProductDto dto) {
        ApiResponse<?> response=service.update(id,dto);
        return ResponseEntity.status(response.isSuccess()?201:409).body(response);
    }

    @Override
    public HttpEntity<?> getAllProduct() {
        ApiResponse<?> response =service.getAll();
        return ResponseEntity.status(response.isSuccess()?201:409).body(response);
    }

    @Override
    public HttpEntity<?> getById(UUID id) {
        ApiResponse<?> response=service.getById(id);
        return ResponseEntity.status(response.isSuccess()?201:409).body(response);
    }

    @Override
    public HttpEntity<?> delete(UUID id) {
        ApiResponse<?> response =service.delete(id);
        return ResponseEntity.status(response.isSuccess()?201:409).body(response);
    }
}
