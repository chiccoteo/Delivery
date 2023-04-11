package star.uz.delivery.controllerImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import star.uz.delivery.controller.RestaurantController;
import star.uz.delivery.payload.ApiResponse;
import star.uz.delivery.payload.RestaurantDto;
import star.uz.delivery.service.RestaurantService;

import java.util.UUID;
@RestController
@RequiredArgsConstructor
public class RestaurantControllerImpl implements RestaurantController {
    private final RestaurantService service;
    @Override
    public HttpEntity<?> creat(RestaurantDto dto) {
        ApiResponse<?> response=service.creat(dto);
        return ResponseEntity.status(response.isSuccess()?201:409).body(response);
    }

    @Override
    public HttpEntity<?> update(UUID id, RestaurantDto dto) {
        ApiResponse<?> response=service.update(id,dto);
        return ResponseEntity.status(response.isSuccess()?201:409).body(response);
    }

    @Override
    public HttpEntity<?> getById(UUID id) {
        ApiResponse<?> response=service.getById(id);
        return ResponseEntity.status(response.isSuccess()?201:409).body(response);
    }

    @Override
    public HttpEntity<?> getAllRestaurant() {
        ApiResponse<?>response =service.getAllRestaurant();
        return ResponseEntity.status(response.isSuccess()?201:409).body(response);
    }

    @Override
    public HttpEntity<?> delete(UUID id) {
        ApiResponse<?>response =service.delete(id);
        return ResponseEntity.status(response.isSuccess()?201:409).body(response);
    }
}
