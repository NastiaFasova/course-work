package ipk.service.impl;

import java.util.List;
import ipk.model.Group;
import ipk.model.Speciality;
import ipk.repository.GroupRepository;
import ipk.repository.SpecialityRepository;
import ipk.service.SpecialityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class SpecialityServiceImpl implements SpecialityService {
    private final SpecialityRepository specialityRepository;
    private final GroupRepository groupRepository;

    public SpecialityServiceImpl(SpecialityRepository specialityRepository,
                                 GroupRepository groupRepository) {
        this.specialityRepository = specialityRepository;
        this.groupRepository = groupRepository;
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

    @Override
    public void deleteById(long id) {
        specialityRepository.deleteById(id);
    }

    @Override
    public Speciality addGroupToSpeciality(Group group, Speciality speciality) {
        speciality.getGroups().add(group);
        groupRepository.save(group);
        specialityRepository.save(speciality);
        return speciality;
    }
}
