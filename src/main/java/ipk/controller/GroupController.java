package ipk.controller;

import ipk.model.*;
import ipk.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

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
                           TeacherService teacherService, SubjectService subjectService, DayService dayService) {
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
        model.addAttribute("groups", groups);
        return "groups";
    }

    @GetMapping("/{id}/listeners")
    public String getListenersGyGroupId(@PathVariable (value = "id") Long id, Model model) {
        List<Listener> listeners = groupService.getListenersByGroupId(id);
        Group group = groupService.findById(id);
        model.addAttribute("listeners", listeners);
        model.addAttribute("group", group);
        return "listeners";
    }

    @GetMapping("/{id}/create-listener")
    public String showNewEmployeeForm(@PathVariable (value = "id") Long id, Model model) {
        Listener listener = new Listener();
        Group group = groupService.findById(id);
        model.addAttribute("group", group);
        model.addAttribute("listener", listener);
        return "create-listener";
    }

    @PostMapping("/{id}/save-listener")
    public String saveEmployee(@PathVariable (value = "id") Long id,
                               @ModelAttribute("listener")
                                       Listener listener) {
        Group group = groupService.findById(id);
        listener.setId(null);
        groupService.addListenerToGroup(listener, group);
        return ( "redirect:/{id}/listeners");
    }

    @PostMapping("/{id}/update-listener")
    public String updateEmployee(@PathVariable (value = "id") Long id,
                               @ModelAttribute("listener")
                                       Listener listener) {
        Group group = groupService.findById(id);
        groupService.updateListener(listener, group);
        return ( "redirect:/{id}/listeners");
    }

    @GetMapping("/{id}/update-listener/{listener-id}")
    public String showFormForUpdate(@PathVariable ( value = "id") long id,
                                    @PathVariable ( value = "listener-id") long listenerId, Model model) {
        Listener listener = listenerService.findById(listenerId);
        Group group = groupService.findById(id);
        model.addAttribute("listener", listener);
        model.addAttribute("group", group);
        return "update-listener";
    }

    @GetMapping("/{id}/delete-listener/{listener-id}")
    public String deleteEmployee(@PathVariable (value = "id") long id,
                                 @PathVariable ( value = "listener-id") long listenerId) {
        Listener listener = listenerService.findById(listenerId);
        groupService.deleteListenerFromGroup(listener, id);
        return "redirect:/{id}/listeners";
    }

    @GetMapping("{id}/timetable")
    public String getTimetable(@PathVariable (value = "id") long id, Model model) {
        List<Lesson> lessons = groupService.getAllLessonsByGroupId(id);
        model.addAttribute("lessons", lessons);
        Group group = groupService.findById(id);
        model.addAttribute("group", group);
        return "timetable";
    }

    @GetMapping("{id}/delete-lesson/{lesson-id}")
    public String removeLesson(@PathVariable (value = "id") long id,
                               @PathVariable ( value = "lesson-id") long lessonId) {
        Lesson lesson = lessonService.getById(lessonId);
        groupService.deleteLessonFromGroupById(lesson, id);
        return "redirect:/{id}/timetable";
    }

    @GetMapping("{id}/timetable/create-lesson")
    public String addLesson(@PathVariable (value = "id") Long id, Model model) {
        Lesson lesson = new Lesson();
        Teacher teacher = new Teacher();
        Subject subject = new Subject();
        List<Teacher> teachers = teacherService.getAll();
        List<Subject> subjects = subjectService.getAll();
        List<Day> days = dayService.getAll();
        Group group = groupService.findById(id);
        model.addAttribute("group", group);
        model.addAttribute("lesson", lesson);
        model.addAttribute("teachers", teachers);
        model.addAttribute("subjects", subjects);
        model.addAttribute("days", days);
        model.addAttribute("time", LocalTime.of(0, 0));
        model.addAttribute("teacher", teacher);
        model.addAttribute("subject", subject);
        return "createLesson";
    }

    @PostMapping("/{id}/timetable/save-lesson")
    public String saveLesson(@PathVariable (value = "id") Long id,
                               @ModelAttribute("lesson")
                                       Lesson lesson,
                             @RequestParam("teacher") Teacher teacher,
                             @RequestParam("subject") Subject subject) {
        Group group = groupService.findById(id);
        lesson.setId(null);
        groupService.addLessonToGroup(lesson, group);
        return ( "redirect:/{id}/listeners");
    }
}
