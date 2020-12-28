package ipk.security;

import ipk.model.Listener;

public interface AuthenticationService {

    Listener register(String email, String password) throws RuntimeException;
}
