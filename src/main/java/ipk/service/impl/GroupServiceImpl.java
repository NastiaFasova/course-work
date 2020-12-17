package ipk.service.impl;

import ipk.model.*;
import ipk.repository.GroupRepository;
import ipk.service.GroupService;
import ipk.service.LessonService;
import ipk.service.ListenerService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;
    private final ListenerService listenerService;
    private final LessonService lessonService;

    public GroupServiceImpl(GroupRepository groupRepository,
                            ListenerService listenerService, LessonService lessonService) {
        this.groupRepository = groupRepository;
        this.listenerService = listenerService;
        this.lessonService = lessonService;
    }

    @Override
    public Group save(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public List<Listener> getListenersByGroupId(Long id) {
        return groupRepository.getListenersByGroupId(id);
    }



    @Override
    public Group addListenerToGroup(Listener listener, Group group) {
        listenerService.save(listener);
        List<Listener> listeners = group.getListeners();
        listeners.add(listener);
        groupRepository.save(group);
        return group;
    }

    @Override
    public Group updateListener(Listener listener, Group group) {
        Listener listenerById = listenerService.findById(listener.getId());
        group.getListeners().remove(listenerById);
        groupRepository.save(group);
        listenerById.setName(listener.getName());
        listenerById.setSurname(listener.getSurname());
        listenerById.setEmail(listener.getEmail());
        listenerService.save(listenerById);
        List<Listener> listeners = group.getListeners();
        listeners.add(listenerById);
        groupRepository.save(group);
        return null;
    }

    @Override
    public Group deleteListenerFromGroup(Listener listener, Long id) {
        Group group = groupRepository.findById(id).orElseThrow(RuntimeException::new);
        group.getListeners().remove(listener);
        groupRepository.save(group);
        return group;
    }

    @Override
    public Group deleteLessonFromGroupById(Lesson lesson, Long id) {
        Group group = groupRepository.findById(id).orElseThrow(RuntimeException::new);
        group.getLessons().remove(lesson);
        groupRepository.save(group);
        return group;
    }

    @Override
    public Group findById(Long id) {
        return groupRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Lesson> getAllLessonsByGroupId(long id) {
        return groupRepository.getAllLessonsByGroupId(id);
    }

    @Override
    public Group addLessonToGroup(Lesson lesson, Group group) {
        lessonService.save(lesson);
        List<Lesson> lessons = group.getLessons();
        lessons.add(lesson);
        groupRepository.save(group);
        return group;
    }

    @Override
    public List<Listener> getListenersByGroupIdAndKeyword(Long id, String keyword) {
        return groupRepository.getListenersByGroupIdAndKeyword(id, keyword);
    }
}
