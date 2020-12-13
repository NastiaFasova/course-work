package ipk.controller;

import ipk.model.Group;
import ipk.model.Lesson;
import ipk.model.Listener;
import ipk.service.GroupService;
import ipk.service.LessonService;
import ipk.service.ListenerService;
import ipk.service.SpecialityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class GroupController {
    private final GroupService groupService;
    private final SpecialityService specialityService;
    private final ListenerService listenerService;
    private final LessonService lessonService;

    public GroupController(GroupService groupService, SpecialityService specialityService,
                           ListenerService listenerService, LessonService lessonService) {
        this.groupService = groupService;
        this.specialityService = specialityService;
        this.listenerService = listenerService;
        this.lessonService = lessonService;
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
        listener.setId(null);
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
}
