package star.uz.delivery.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {

    private UUID id;
    private String name;
    private double price;
    private UUID photo_id;
    private String description;
    private Long categoryId;

}
