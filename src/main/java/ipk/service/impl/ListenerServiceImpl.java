package ipk.service.impl;

import ipk.model.Listener;
import ipk.repository.ListenerRepository;
import ipk.service.ListenerService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class ListenerServiceImpl implements ListenerService {
    private static final Logger LOGGER = Logger.getLogger(ListenerServiceImpl.class);
    private final ListenerRepository listenerRepository;

    public ListenerServiceImpl(ListenerRepository listenerRepository) {
        this.listenerRepository = listenerRepository;
    }

    @Override
    public Listener save(Listener listener) {
        LOGGER.info("The listener was saved");
        return listenerRepository.save(listener);
    }

    @Override
    public Listener getByEmail(String email) {
        LOGGER.info("The listener was retrieved by email");
        return listenerRepository.findByEmail(email);
    }

    @Override
    public Listener findById(long id) {
        LOGGER.info("The listener was retrieved by id");
        return listenerRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public void deleteById(Long id) {
        LOGGER.info("The listener was removed");
        listenerRepository.deleteById(id);
    }
}
