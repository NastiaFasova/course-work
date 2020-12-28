package ipk.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import ipk.model.Day;
import ipk.model.Group;
import ipk.model.Lesson;
import ipk.model.Listener;
import ipk.model.Speciality;
import ipk.model.Subject;
import ipk.model.Teacher;
import ipk.service.DayService;
import ipk.service.GroupService;
import ipk.service.LessonService;
import ipk.service.ListenerService;
import ipk.service.SpecialityService;
import ipk.service.SubjectService;
import ipk.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GroupController {
    private final GroupService groupService;
    private final SpecialityService specialityService;
    private final ListenerService listenerService;
    private final LessonService lessonService;
    private final TeacherService teacherService;
    private final SubjectService subjectService;
    private final DayService dayService;

    public GroupController(GroupService groupService, SpecialityService specialityService,
                           ListenerService listenerService, LessonService lessonService,
                           TeacherService teacherService, SubjectService subjectService,
                           DayService dayService) {
        this.groupService = groupService;
        this.specialityService = specialityService;
        this.listenerService = listenerService;
        this.lessonService = lessonService;
        this.teacherService = teacherService;
        this.subjectService = subjectService;
        this.dayService = dayService;
    }

    @GetMapping("/{id}")
    public String getGroupsById(@PathVariable (value = "id") Long id, Model model) {
        List<Group> groups = specialityService.findGroupsBySpecialityId(id);
        Speciality speciality = specialityService.getById(id);
        model.addAttribute("groups", groups);
        model.addAttribute("speciality", speciality);
        return "model/groups";
    }

    @GetMapping("/{id}/create-group")
    public String createGroup(@PathVariable (value = "id") Long id, Model model) {
        Speciality speciality = specialityService.getById(id);
        Group group = new Group();
        model.addAttribute("group", group);
        model.addAttribute("speciality", speciality);
        model.addAttribute("startOfStudying", LocalDate.now());
        return "create/group";
    }

    @PostMapping("/{id}/save-group")
    public String saveGroup(@PathVariable (value = "id") Long id,
                               @ModelAttribute("listener")
                                       Group group) {
        Speciality speciality = specialityService.getById(id);
        group.setId(null);
        specialityService.addGroupToSpeciality(group, speciality);
        return ( "redirect:/{id}");
    }

    @GetMapping("/update/{group-id}")
    public String showFormForUpdateGroup(
                                    @PathVariable ( value = "group-id") long groupId, Model model) {
        Group group = groupService.findById(groupId);
        model.addAttribute("group", group);
        return "update/group";
    }

    @PostMapping("/update/{id}")
    public String updateGroup(@ModelAttribute("group") Group group,
                              @PathVariable ( value = "id") long groupId) {
        groupService.save(group);
        return ( "redirect:/{id}");
    }

    @GetMapping("/{id}/listeners")
    public String getListenersGyGroupId(@PathVariable (value = "id") Long id,
                                        Model model, String keyword) {
        if (keyword != null) {
            List<Listener> listeners
                    = groupService.getListenersByGroupIdAndKeyword(id, keyword);
            model.addAttribute("listeners", listeners);
        } else {
            List<Listener> listeners = groupService.getListenersByGroupId(id);
            model.addAttribute("listeners", listeners);
        }
        Group group = groupService.findById(id);
        model.addAttribute("group", group);
        return "model/listeners";
    }


    @GetMapping("/{id}/create-listener")
    public String showNewListenerForm(@PathVariable (value = "id") Long id,
                                      Model model) {
        Listener listener = new Listener();
        Group group = groupService.findById(id);
        model.addAttribute("group", group);
        model.addAttribute("listener", listener);
        return "create/listener";
    }

    @PostMapping("/{id}/save-listener")
    public String saveListener(@PathVariable (value = "id") Long id,
                               @ModelAttribute("listener")
                                       Listener listener) {
        Group group = groupService.findById(id);
        listener.setId(null);
        groupService.addListenerToGroup(listener, group);
        return ( "redirect:/{id}/listeners");
    }

    @PostMapping("/{id}/update-listener")
    public String updateListener(@PathVariable (value = "id") Long id,
                               @ModelAttribute("listener")
                                       Listener listener) {
        Group group = groupService.findById(id);
        groupService.updateListener(listener, group);
        return ( "redirect:/{id}/listeners");
    }

    @GetMapping("/{id}/update-listener/{listener-id}")
    public String showFormForListenerUpdate(@PathVariable ( value = "id") long id,
                                    @PathVariable ( value = "listener-id") long listenerId,
                                            Model model) {
        Listener listener = listenerService.findById(listenerId);
        Group group = groupService.findById(id);
        model.addAttribute("listener", listener);
        model.addAttribute("group", group);
        return "update/listener";
    }

    @GetMapping("/{id}/delete/{group-id}")
    public String deleteGroup(@PathVariable (value = "id") long id,
                              @PathVariable (value = "group-id") long groupId) {
        groupService.deleteGroupByIdFromSpeciality(id, groupId);
        return "redirect:/{id}";
    }

    @GetMapping("/{id}/delete-listener/{listener-id}")
    public String deleteListener(@PathVariable (value = "id") long id,
                                 @PathVariable ( value = "listener-id") long listenerId) {
        Listener listener = listenerService.findById(listenerId);
        groupService.deleteListenerFromGroup(listener, id);
        return "redirect:/{id}/listeners";
    }

    @GetMapping("/{id}/timetable")
    public String getTimetable(@PathVariable (value = "id") long id, Model model) {
        List<Lesson> lessons = groupService.getAllLessonsByGroupId(id);
        model.addAttribute("lessons", lessons);
        List<Day> days = dayService.getAll();
        Group group = groupService.findById(id);
        model.addAttribute("group", group);
        model.addAttribute("days", days);
        return "model/timetable";
    }


    @GetMapping("{id}/delete-lesson/{lesson-id}")
    public String removeLesson(@PathVariable (value = "id") long id,
                               @PathVariable ( value = "lesson-id") long lessonId) {
        Lesson lesson = lessonService.getById(lessonId);
        groupService.deleteLessonFromGroupById(lesson, id);
        return "redirect:/{id}/timetable";
    }

    @GetMapping("{id}/create-lesson")
    public String addLesson(@PathVariable (value = "id") Long id, Model model) {
        Lesson lesson = new Lesson();
        List<Teacher> teachers = teacherService.getAll();
        List<Subject> subjects = subjectService.getAll();
        List<Day> days = dayService.getAll();
        Group group = groupService.findById(id);
        model.addAttribute("group", group);
        model.addAttribute("lesson", lesson);
        model.addAttribute("teachers", teachers);
        model.addAttribute("subjects", subjects);
        model.addAttribute("days", days);
        model.addAttribute("time", LocalTime.now());
        return "create/lesson";
    }

    @PostMapping("{id}/update-lesson")
    public String updateLesson(@PathVariable (value = "id") Long id,
                               @ModelAttribute("lesson")
                                       Lesson lesson) {
        Group group = groupService.findById(id);
        groupService.updateLessonInGroup(lesson, group);
        return "redirect:/{id}/timetable";
    }


    @PostMapping("/{id}/save-lesson")
    public String saveLesson(@PathVariable (value = "id") Long id,
                               @ModelAttribute("lesson")
                                       Lesson lesson) {
        Group group = groupService.findById(id);
        lesson.setId(null);
        groupService.addLessonToGroup(lesson, group);
        return ( "redirect:/{id}/timetable");
    }

    @GetMapping("/{id}/update-lesson/{lesson-id}")
    public String showFormForUpdateLesson(@PathVariable ( value = "id") long id,
                                    @PathVariable ( value = "lesson-id") long lessonId,
                                          Model model) {
        Lesson lesson = lessonService.getById(lessonId);
        Group group = groupService.findById(id);
        List<Teacher> teachers = teacherService.getAll();
        List<Subject> subjects = subjectService.getAll();
        List<Day> days = dayService.getAll();
        model.addAttribute("group", group);
        model.addAttribute("lesson", lesson);
        model.addAttribute("teachers", teachers);
        model.addAttribute("subjects", subjects);
        model.addAttribute("days", days);
        model.addAttribute("lesson", lesson);
        model.addAttribute("group", group);
        return "update/lesson";
    }
}
