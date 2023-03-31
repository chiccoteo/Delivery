package star.uz.delivery.payload;

import lombok.*;

import javax.persistence.Column;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCreatDto {
    private UUID id;
    @Column(nullable = false)
    private String fio;
    @Column(nullable = false)
    private String phoneNumber;
    private String address;
    @Column(nullable = false)
    private String password;
    private long roleId;


}
