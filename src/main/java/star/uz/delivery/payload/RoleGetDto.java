package star.uz.delivery.payload;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleGetDto {
    private Long roleId;
    private String name;

}
