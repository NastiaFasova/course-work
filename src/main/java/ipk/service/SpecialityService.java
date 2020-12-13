package ipk.service;

import ipk.model.Group;
import ipk.model.Speciality;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SpecialityService {
    Speciality save(Speciality speciality);

    Speciality getById(Long id);

    List<Speciality> getAll();

    public Page<Speciality> findPaginated(int pageNo,
                                          int pageSize, String sortField,
                                          String sortDirection);

    List<Group> findGroupsBySpecialityId(Long id);
}
