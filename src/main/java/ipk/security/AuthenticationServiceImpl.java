package ipk.security;

import java.util.Set;
import ipk.model.Listener;
import ipk.model.Role;
import ipk.service.ListenerService;
import ipk.service.RoleService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final ListenerService listenerService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationServiceImpl(ListenerService listenerService,
                                     RoleService roleService,
                                     PasswordEncoder passwordEncoder) {
        this.listenerService = listenerService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Listener register(String email, String password) throws RuntimeException {
        Listener listener = new Listener();
        listener.setName(email);
        listener.setSurname(email);
        listener.setEmail(email);
        listener.setPassword(passwordEncoder.encode(password));
        Role role = roleService.getRoleByName("LISTENER");
        listener.setRoles(Set.of(role));
        listenerService.save(listener);
        return listener;
    }
}
