package ipk.repository;

import ipk.model.Group;
import ipk.model.Lesson;
import ipk.model.Listener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    @Query("SELECT g.listeners FROM Group g where g.id = :id")
    List<Listener> getListenersByGroupId(Long id);

    @Query("SELECT g FROM Group g LEFT JOIN FETCH g.listeners Listener where g.id = :id")
    Group getById(Long id);

    @Query("SELECT g.lessons FROM Group g where g.id = :id")
    List<Lesson> getAllLessonsByGroupId(long id);
}
