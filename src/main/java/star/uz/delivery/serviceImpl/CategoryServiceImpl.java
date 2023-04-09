package star.uz.delivery.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import star.uz.delivery.entity.Category;
import star.uz.delivery.payload.ApiResponse;
import star.uz.delivery.payload.CategoryDto;
import star.uz.delivery.repository.CategoryRepo;
import star.uz.delivery.service.CategoryService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepo;

    @Override
    public ApiResponse<?> creat(CategoryDto categoryDto) {
        if (categoryRepo.existsByName(categoryDto.getName())) {
            return ApiResponse.errorResponse("Category already exists");
        }
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setParentCategoryId(categoryDto.getParentCategoryId());
        categoryRepo.save(category);
        return ApiResponse.successResponse("Category added");
    }

    @Override
    public ApiResponse<?> update(Long id, CategoryDto categoryDto) {
        Optional<Category> optionalCategory = categoryRepo.findById(id);
        if (optionalCategory.isEmpty()) {
            return ApiResponse.errorResponse("Category not found");
        }
        Category category = optionalCategory.get();
        category.setName(category.getName());
        category.setParentCategoryId(categoryDto.getParentCategoryId());
        categoryRepo.save(category);
        return ApiResponse.successResponse("Category added");
    }

    @Override
    public ApiResponse<?> getAll() {
        List<CategoryDto> dtoList = categoryRepo.findAll().stream().map(this::generated).collect(Collectors.toList());
        return ApiResponse.successResponse(dtoList);
    }

    @Override
    public ApiResponse<?> delete(Long id) {
        Optional<Category> optionalCategory = categoryRepo.findById(id);
        if (optionalCategory.isEmpty()) {
            return ApiResponse.errorResponse("Category not found");
        }
        categoryRepo.deleteById(id);
        return ApiResponse.successResponse("Category deleted");
    }

    public CategoryDto generated(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .parentCategoryId(category.getParentCategoryId())
                .build();
    }
}