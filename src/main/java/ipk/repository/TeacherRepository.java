package ipk.repository;

import ipk.model.Subject;
import ipk.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query("SELECT t FROM Teacher t where t.surname = :surname")
    Teacher findBySurname(String surname);

    @Query("select t From Teacher t order by t.name")
    List<Teacher> findAll();

    @Query("SELECT t FROM Teacher t where t.surname like %:keyword% or t.name like %:keyword%")
    List<Teacher> getAllByKeyword(@Param("keyword") String keyword);
}
