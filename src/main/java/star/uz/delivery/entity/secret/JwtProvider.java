package star.uz.delivery.entity.secret;

import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import star.uz.delivery.entity.Users;
import star.uz.delivery.entity.repository.UserRepo;

import java.util.Date;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class JwtProvider {

    @Value(value = "${jwt.secretKey}")
    private String secretKey;

    @Value(value = "${jwt.expriDateInMilliSecond}")
    private long expirationDate;

    private final UserRepo userRepo;

    public String generateToken(Users user) {
        Date newDate = new Date();
        Date expireDate = new Date(newDate.getTime() + expirationDate);
        return Jwts
                .builder()
                .setSubject(String.valueOf(user.getId()))
                .setIssuedAt(newDate)
                .claim("role", user.getRole().getRoleName().name())
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts
                    .parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException e) {
            System.out.println("Expired token");
        } catch (MalformedJwtException malformedJwtException) {
            System.err.println("Broken token");
        } catch (SignatureException s) {
            System.out.println("The key word is error");
        } catch (UnsupportedJwtException unsupportedJwtException) {
            System.out.println("Unused token");
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println("An empty token");
        }
    return  false;
    }
    public Users getUserFromToken(String  token){
        String  userId =Jwts
                .parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        return  userRepo.findById(UUID.fromString(userId)).orElse(null);
    }


}
