package star.uz.delivery.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import star.uz.delivery.entity.Restaurant;
import star.uz.delivery.payload.ApiResponse;
import star.uz.delivery.payload.RestaurantDto;
import star.uz.delivery.repository.RestaurantRepo;
import star.uz.delivery.service.RestaurantService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepo restaurantRepo;

    @Override
    public ApiResponse<?> creat(RestaurantDto dto) {

        if (restaurantRepo.existsByRestaurantNameAndPhoneNumber(dto.getRestaurantName(), dto.getPhoneNumber())) {
            return ApiResponse.errorResponse("Restaurant already exists");
        }
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantName(dto.getRestaurantName());
        restaurant.setAddress(dto.getAddress());
        restaurant.setPhoneNumber(dto.getPhoneNumber());
        restaurant.setOpenTime(dto.getOpenTime());
        restaurant.setCloseTime(dto.getCloseTime());
        restaurantRepo.save(restaurant);
        return ApiResponse.successResponse("Restaurant added");
    }

    @Override
    public ApiResponse<?> update(UUID id, RestaurantDto dto) {
        Optional<Restaurant> repoById = restaurantRepo.findById(id);
        if (repoById.isEmpty()) {
            return ApiResponse.errorResponse("Restaurant not found");
        }
        Restaurant restaurant = repoById.get();
        restaurant.setRestaurantName(dto.getRestaurantName());
        restaurant.setAddress(dto.getAddress());
        restaurant.setPhoneNumber(dto.getPhoneNumber());
        restaurant.setOpenTime(dto.getOpenTime());
        restaurant.setCloseTime(dto.getCloseTime());
        restaurantRepo.save(restaurant);
        return ApiResponse.successResponse("Restaurant update");
    }

    @Override
    public ApiResponse<?> getById(UUID id) {
        Optional<Restaurant> repoById = restaurantRepo.findById(id);
        if (repoById.isEmpty()) {
            return ApiResponse.errorResponse("Restaurant not found");
        }
        return ApiResponse.successResponse(repoById.get());
    }

    @Override
    public ApiResponse<?> getAllRestaurant() {
        List<RestaurantDto> all =
                restaurantRepo
                        .findAll()
                        .stream()
                        .map(this::generated)
                        .collect(Collectors.toList());
        return ApiResponse.successResponse(all);
    }

    @Override
    public ApiResponse<?> delete(UUID id) {
        try {
            restaurantRepo.deleteById(id);
        } catch (Exception e) {
            return ApiResponse.errorResponse("Restaurant not found");
        }
        return ApiResponse.successResponse("Deleted");
    }

    public RestaurantDto generated(Restaurant restaurant) {
        return RestaurantDto.builder()
                .id(restaurant.getId())
                .restaurantName(restaurant.getRestaurantName())
                .address(restaurant.getAddress())
                .phoneNumber(restaurant.getPhoneNumber())
                .openTime(restaurant.getOpenTime())
                .closeTime(restaurant.getCloseTime())
                .build();
    }
}
