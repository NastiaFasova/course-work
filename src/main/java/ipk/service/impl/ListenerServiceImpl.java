package ipk.service.impl;

import ipk.model.Listener;
import ipk.repository.ListenerRepository;
import ipk.service.ListenerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ListenerServiceImpl implements ListenerService {
    private final ListenerRepository listenerRepository;

    public ListenerServiceImpl(ListenerRepository listenerRepository) {
        this.listenerRepository = listenerRepository;
    }

    @Override
    public Listener save(Listener listener) {
        return listenerRepository.save(listener);
    }

    @Override
    public Listener getByEmail(String email) {
        return listenerRepository.findByEmail(email);
    }

    @Override
    public Page<Listener> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return listenerRepository.findAll(pageable);
    }

    @Override
    public Listener findById(long id) {
        return listenerRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public void deleteById(Long id) {
        listenerRepository.deleteById(id);
    }
}
