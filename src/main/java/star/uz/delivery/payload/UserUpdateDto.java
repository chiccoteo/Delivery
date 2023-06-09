package star.uz.delivery.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserUpdateDto {
    private String fio;
    private String phoneNumber;
    private String address;
    private String password;
    private long roleId;

}
