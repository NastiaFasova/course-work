package ipk.repository;

import java.util.List;
import ipk.model.Group;
import ipk.model.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality, Long> {

    @Query("select s.groups from Speciality s where s.id = :id")
    List<Group> findGroupsBySpecialityId(Long id);
}
