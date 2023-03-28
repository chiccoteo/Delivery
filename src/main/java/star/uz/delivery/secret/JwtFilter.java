package star.uz.delivery.secret;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import star.uz.delivery.entity.Users;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    private JwtProvider jwtProvider;
    @Override
    protected void doFilterInternal(
          @NonNull HttpServletRequest request,
          @NonNull  HttpServletResponse response,
          @NonNull  FilterChain filterChain
    ) throws ServletException, IOException {
       final String token = getTokenFromRequest(request);
        if (token != null) {
            Users user = getUser(token);
            if (user != null) {
                if (!user.isAccountNonExpired()) {
                    System.err.println("User Expired");
                } else if (!user.isAccountNonLocked()) {
                    System.out.println("User Locked");
                } else if (!user.isCredentialsNonExpired()) {
                    System.out.println("User Credential expired");
                } else if (!user.isEnabled()) {
                    System.out.println("User Disabled");
                } else {
                    UsernamePasswordAuthenticationToken authenticationToken
                            = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
        }
        filterChain.doFilter(request, response);
    }
    public Users getUser(String token){
        if (jwtProvider.validateToken(token)){
            return jwtProvider.getUserFromToken(token);
        }
        return null;
    }
    public String getTokenFromRequest(HttpServletRequest request) {
        final String token = request.getHeader("Authorization");
        return token != null ? token.substring(7): null;
    }
}
