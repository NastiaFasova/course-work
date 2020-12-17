package ipk.service;

import ipk.model.Listener;
import ipk.model.Speciality;
import org.springframework.data.domain.Page;

public interface ListenerService {

    Listener save(Listener listener);

    Listener getByEmail(String email);

    Listener findById(long id);

    void deleteById(Long id);

}

