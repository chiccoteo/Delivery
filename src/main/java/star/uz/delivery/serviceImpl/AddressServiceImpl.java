package star.uz.delivery.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import star.uz.delivery.entity.Address;
import star.uz.delivery.payload.AddressGetDto;
import star.uz.delivery.payload.ApiResponse;
import star.uz.delivery.repository.AddressRepo;
import star.uz.delivery.service.AddressService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepo addressRepo;

    @Override
    public ApiResponse<?> getAllAddress() {
        List<Object> collect = addressRepo.findAll().stream().map(this::generatedDto).collect(Collectors.toList());
        return ApiResponse.successResponse(collect);
    }

    @Override
    public ApiResponse<?> getById(UUID id) {
        Optional<Address> address = addressRepo.findById(id);
        if (address.isEmpty()){
            return ApiResponse.errorResponse("Address not found");
        }
        return ApiResponse.successResponse(address.get());
    }
    public AddressGetDto generatedDto(Address address){
        return AddressGetDto.builder()
                .id(address.getId())
                .address(address.getAddressName())
                .build();
    }
}
