package star.uz.delivery.payload;

import lombok.*;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserCreatDto {
    @Column(nullable = false)
    private String fio;
    @Column(nullable = false)
    private String phoneNumber;
    private String address;
    @Column(nullable = false)
    private String password;
    private long roleId;


}
