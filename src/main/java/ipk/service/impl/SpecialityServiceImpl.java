package ipk.service.impl;

import ipk.model.Group;
import ipk.model.Speciality;
import ipk.repository.SpecialityRepository;
import ipk.service.SpecialityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialityServiceImpl implements SpecialityService {
    private final SpecialityRepository specialityRepository;

    public SpecialityServiceImpl(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Speciality save(Speciality speciality) {
        return specialityRepository.save(speciality);
    }

    @Override
    public Speciality getById(Long id) {
        return specialityRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Speciality> getAll() {
        return specialityRepository.findAll();
    }

    @Override
    public Page<Speciality> findPaginated(int pageNo, int pageSize,
                                          String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return specialityRepository.findAll(pageable);
    }

    @Override
    public List<Group> findGroupsBySpecialityId(Long id) {
        return specialityRepository.findGroupsBySpecialityId(id);
    }
}
