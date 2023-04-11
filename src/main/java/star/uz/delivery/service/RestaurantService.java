package star.uz.delivery.service;

import star.uz.delivery.payload.ApiResponse;
import star.uz.delivery.payload.RestaurantDto;

import java.util.UUID;

public interface RestaurantService {
    ApiResponse<?> creat(RestaurantDto dto);

    ApiResponse<?> update(UUID id, RestaurantDto dto);

    ApiResponse<?> getById(UUID id);

    ApiResponse<?> getAllRestaurant();

    ApiResponse<?> delete(UUID id);
}
