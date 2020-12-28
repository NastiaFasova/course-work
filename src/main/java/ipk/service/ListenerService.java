package ipk.service;

import ipk.model.Listener;

public interface ListenerService {

    Listener save(Listener listener);

    Listener getByEmail(String email);

    Listener findById(long id);

    void deleteById(Long id);

}

