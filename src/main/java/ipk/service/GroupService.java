package ipk.service;

import ipk.model.Group;
import ipk.model.Lesson;
import ipk.model.Listener;
import ipk.model.Speciality;
import org.springframework.data.domain.Page;

import java.util.List;

public interface GroupService {
    Group save(Group group);

    List<Listener> getListenersByGroupId(Long id);

    Group addListenerToGroup(Listener listener, Group group);

    Group updateListener(Listener listener, Group group);

    Group deleteListenerFromGroup(Listener listener, Long id);

    Group deleteLessonFromGroupById(Lesson lesson, Long id);

    Group findById(Long id);

    List<Lesson> getAllLessonsByGroupId(long id);

    Group addLessonToGroup(Lesson lesson, Group group);
}


