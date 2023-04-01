package star.uz.delivery.service;

import star.uz.delivery.payload.ApiResponse;
import star.uz.delivery.payload.CategoryDto;

public interface CategoryService {
    ApiResponse<?> creat(CategoryDto categoryDto);

    ApiResponse<?> update(Long id, CategoryDto categoryDto);

    ApiResponse<?> getAll();

    ApiResponse<?> delete(Long id);
}
