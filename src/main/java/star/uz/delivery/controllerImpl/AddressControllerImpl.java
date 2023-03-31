package star.uz.delivery.controllerImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import star.uz.delivery.controller.AddressController;
import star.uz.delivery.payload.ApiResponse;
import star.uz.delivery.service.AddressService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AddressControllerImpl implements AddressController {
    private final AddressService addressService;


    @Override
    public HttpEntity<?> getAll() {
        ApiResponse<?> response = addressService.getAllAddress();
        return ResponseEntity.status(response.isSuccess()?201:409).body(response);
    }

    @Override
    public HttpEntity<?> getById(UUID id) {
        ApiResponse<?> response= addressService.getById(id);
        return ResponseEntity.status(response.isSuccess()?201:409).body(response);
    }
}
