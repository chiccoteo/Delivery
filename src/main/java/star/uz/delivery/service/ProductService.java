package star.uz.delivery.service;

import star.uz.delivery.payload.ApiResponse;
import star.uz.delivery.payload.ProductDto;

import java.util.UUID;

public interface ProductService {


    ApiResponse<?> creatProduct(ProductDto productDto);

    ApiResponse<?> update(UUID id, ProductDto dto);

    ApiResponse<?> getAll();

    ApiResponse<?> getById(UUID id);

    ApiResponse<?> delete(UUID id);
}
