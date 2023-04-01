package star.uz.delivery.controllerImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import star.uz.delivery.controller.CategoryController;
import star.uz.delivery.payload.ApiResponse;
import star.uz.delivery.payload.CategoryDto;
import star.uz.delivery.service.CategoryService;

@RestController
@RequiredArgsConstructor
public class CategoryControllerImpl implements CategoryController {
    private final CategoryService categoryService;
    @Override
    public HttpEntity<?> creat(CategoryDto categoryDto) {
        ApiResponse<?> response=categoryService.creat(categoryDto);
        return ResponseEntity.status(response.isSuccess()?201:409).body(response);
    }

    @Override
    public HttpEntity<?> update(Long id, CategoryDto categoryDto) {
        ApiResponse<?> response=categoryService.update(id,categoryDto);
        return ResponseEntity.status(response.isSuccess()?201:409).body(response);
    }

    @Override
    public HttpEntity<?> getAll() {
        ApiResponse<?> response =categoryService.getAll();
        return ResponseEntity.status(response.isSuccess()?201:409).body(response);
    }

    @Override
    public HttpEntity<?> deleteCategory(Long id) {
        ApiResponse<?> apiResponse=categoryService.delete(id);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }
}
