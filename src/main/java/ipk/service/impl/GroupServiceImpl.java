package ipk.service.impl;

import java.util.List;
import ipk.model.*;
import ipk.repository.GroupRepository;
import ipk.service.GroupService;
import ipk.service.LessonService;
import ipk.service.ListenerService;
import ipk.service.SpecialityService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService {
    private static final Logger LOGGER = Logger.getLogger(GroupServiceImpl.class);
    private final GroupRepository groupRepository;
    private final ListenerService listenerService;
    private final LessonService lessonService;
    private final SpecialityService specialityService;

    public GroupServiceImpl(GroupRepository groupRepository,
                            ListenerService listenerService, LessonService lessonService,
                            SpecialityService specialityService) {
        this.groupRepository = groupRepository;
        this.listenerService = listenerService;
        this.lessonService = lessonService;
        this.specialityService = specialityService;
    }

    @Override
    public Group save(Group group) {
        LOGGER.info("The group was saved");
        return groupRepository.save(group);
    }

    @Override
    public List<Listener> getListenersByGroupId(Long id) {
        LOGGER.info("The listeners from group were retrieved");
        return groupRepository.getListenersByGroupId(id);
    }



    @Override
    public Group addListenerToGroup(Listener listener, Group group) {
        listenerService.save(listener);
        List<Listener> listeners = group.getListeners();
        listeners.add(listener);
        groupRepository.save(group);
        LOGGER.info("The listener was added to group");
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
        LOGGER.info("The listener was updated");
        return null;
    }

    @Override
    public Group deleteListenerFromGroup(Listener listener, Long id) {
        Group group = groupRepository.findById(id).orElseThrow(RuntimeException::new);
        group.getListeners().remove(listener);
        groupRepository.save(group);
        LOGGER.info("The listener was removed from group");
        return group;
    }

    @Override
    public Group deleteLessonFromGroupById(Lesson lesson, Long id) {
        Group group = groupRepository.findById(id).orElseThrow(RuntimeException::new);
        group.getLessons().remove(lesson);
        groupRepository.save(group);
        LOGGER.info("The lesson was removed from group");
        return group;
    }

    @Override
    public Group findById(Long id) {
        LOGGER.info("The group was retrieved by id");
        return groupRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Lesson> getAllLessonsByGroupId(long id) {
        LOGGER.info("The lessons of group were retrieved by id");
        return groupRepository.getAllLessonsByGroupId(id);
    }

    @Override
    public Group addLessonToGroup(Lesson lesson, Group group) {
        lessonService.save(lesson);
        List<Lesson> lessons = group.getLessons();
        lessons.add(lesson);
        groupRepository.save(group);
        LOGGER.info("The lesson was added to group timetable");
        return group;
    }

    @Override
    public List<Listener> getListenersByGroupIdAndKeyword(Long id, String keyword) {
        LOGGER.info("The listener was retrieved from group");
        return groupRepository.getListenersByGroupIdAndKeyword(id, keyword);
    }

    @Override
    public Group updateLessonInGroup(Lesson lesson, Group group) {
        Lesson lessonById = lessonService.getById(lesson.getId());
        group.getLessons().remove(lessonById);
        groupRepository.save(group);
        lessonById.setSubject(lesson.getSubject());
        lessonById.setTeacher(lesson.getTeacher());
        lessonById.setDays(lesson.getDays());
        lessonById.setTime(lesson.getTime());
        lessonService.save(lessonById);
        List<Lesson> lessons = group.getLessons();
        lessons.add(lessonById);
        groupRepository.save(group);
        LOGGER.info("The lesson was updated in group timetable");
        return group;
    }

    @Override
    public void deleteGroupByIdFromSpeciality(long id, long groupId) {
        Speciality speciality = specialityService.getById(id);
        Group group = groupRepository.getById(groupId);
        speciality.getGroups().remove(group);
        specialityService.save(speciality);
        groupRepository.deleteById(id);
        LOGGER.info("The group was removed");
    }
}
