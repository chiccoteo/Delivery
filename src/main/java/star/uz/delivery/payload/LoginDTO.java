package star.uz.delivery.payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;
@Getter
@Setter
public class LoginDTO {
    private String fio;

    @Size(min = 4,max = 8, message = "Password qonun-qoidalarga to'g'ri kelmadi")
    private String password;



}
