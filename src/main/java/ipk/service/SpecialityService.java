package ipk.service;

import java.util.List;
import ipk.model.Group;
import ipk.model.Speciality;
import org.springframework.data.domain.Page;

public interface SpecialityService {
    Speciality save(Speciality speciality);

    Speciality getById(Long id);

    List<Speciality> getAll();

    public Page<Speciality> findPaginated(int pageNo,
                                          int pageSize, String sortField,
                                          String sortDirection);

    List<Group> findGroupsBySpecialityId(Long id);

    void deleteById(long id);

    Speciality addGroupToSpeciality(Group group, Speciality speciality);
}
