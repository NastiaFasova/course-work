package ipk.security;

import ipk.model.Listener;
import ipk.service.ListenerService;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Primary
public class CustomUserDetailsService implements UserDetailsService {
    private final ListenerService listenerService;

    public CustomUserDetailsService(ListenerService listenerService) {
        this.listenerService = listenerService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Listener listener = listenerService.getByEmail(email);
        User.UserBuilder userBuilder;
        if (listener != null) {
            userBuilder = org.springframework.security.core.userdetails.User.withUsername(email);
            userBuilder.password(listener.getPassword());
            String[] roles = listener.getRoles().stream()
                    .map(role -> role.getRoleName().name())
                    .toArray(String[]::new);
            userBuilder.roles(roles);
        } else {
            throw new UsernameNotFoundException("User not found.");
        }
        return userBuilder.build();
    }
}
