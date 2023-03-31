package star.uz.delivery.service;

import star.uz.delivery.payload.ApiResponse;

import java.util.UUID;

public interface AddressService {
    ApiResponse<?> getAllAddress();

    ApiResponse<?> getById(UUID id);
}
