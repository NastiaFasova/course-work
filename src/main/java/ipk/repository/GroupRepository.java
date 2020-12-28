package ipk.repository;

import java.util.List;
import ipk.model.Group;
import ipk.model.Lesson;
import ipk.model.Listener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    @Query("SELECT l FROM Group g INNER JOIN g.listeners l where" +
            " g.id = :id order by l.surname")
    List<Listener> getListenersByGroupId(Long id);

    @Query("SELECT g FROM Group g LEFT JOIN FETCH g.listeners Listener where g.id = :id")
    Group getById(Long id);

    @Query("SELECT l FROM Group g INNER JOIN g.lessons l INNER JOIN l.days d where g.id = :id " +
            "order by d.id, l.time")
    List<Lesson> getAllLessonsByGroupId(long id);

    @Query("SELECT l FROM Group g INNER JOIN g.listeners l where l.surname like %:keyword% or l.name like %:keyword%" +
            " or l.email like %:keyword% and g.id = :id")
    List<Listener> getListenersByGroupIdAndKeyword(Long id, String keyword);
}
