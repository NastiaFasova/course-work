package ipk.repository;

import ipk.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

    @Query("SELECT s FROM Subject s where s.title = :subject")
    Subject findByTitle(String subject);

    @Query("select s From Subject s order by s.title")
    List<Subject> findAll();

    @Query("SELECT s FROM Subject s where s.title like %:keyword%")
    List<Subject> getAllByKeyword(String keyword);
}
