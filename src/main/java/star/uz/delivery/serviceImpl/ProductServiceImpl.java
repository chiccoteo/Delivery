package star.uz.delivery.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import star.uz.delivery.entity.Product;
import star.uz.delivery.payload.ApiResponse;
import star.uz.delivery.payload.ProductDto;
import star.uz.delivery.repository.ProductRepo;
import star.uz.delivery.repository.RoleRepo;
import star.uz.delivery.service.ProductService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    private final RoleRepo roleRepo;

    @Override
    public ApiResponse<?> creatProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setDescription(product.getDescription());
        product.setCategoryId(productDto.getCategoryId());
        product.setPhoto_id(productDto.getPhoto_id());
        productRepo.save(product);

        return ApiResponse.successResponse("Product added", product);
    }

    @Override
    public ApiResponse<?> update(UUID id, ProductDto dto) {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if (optionalProduct.isEmpty()) {
            return ApiResponse.errorResponse("Product not found");
        }
        Product product = optionalProduct.get();
        product.setCategoryId(dto.getCategoryId());
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setCategoryId(dto.getCategoryId());
        product.setPhoto_id(dto.getPhoto_id());
        productRepo.save(product);
        return ApiResponse.successResponse("Product update");
    }

    @Override
    public ApiResponse<?> getAll() {
        List<ProductDto> all = productRepo.findAll().stream()
                .map(this::generated).collect(Collectors.toList());
        return ApiResponse.successResponse(all);
    }

    @Override
    public ApiResponse<?> getById(UUID id) {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if (optionalProduct.isEmpty()) {
            return ApiResponse.errorResponse("Product not found");
        }
        return ApiResponse.successResponse("Success", optionalProduct.get());
    }

    @Override
    public ApiResponse<?> delete(UUID id) {
        try {
            productRepo.deleteById(id);
        } catch (Exception e) {
            return ApiResponse.errorResponse("Product not found");
        }

        return ApiResponse.successResponse("Product deleted");
    }

    public ProductDto generated(Product product) {
        return ProductDto.builder()
                .name(product.getName())
                .photo_id(product.getPhoto_id())
                .categoryId(product.getCategoryId())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();

    }
}
