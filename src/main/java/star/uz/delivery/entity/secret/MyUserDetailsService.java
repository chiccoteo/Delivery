package star.uz.delivery.entity.secret;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import star.uz.delivery.entity.Users;
import star.uz.delivery.entity.repository.UserRepo;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private final UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> optionalUsers = userRepo.findByFio(username);
        if (optionalUsers.isPresent())
            return optionalUsers.get();
        throw new UsernameNotFoundException(username+"Not found!");
    }
}
