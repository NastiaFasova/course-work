package ipk.controller;

import ipk.model.Group;
import ipk.model.Listener;
import ipk.model.Subject;
import ipk.model.Teacher;
import ipk.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers")
    public String viewHomePage(Model model) {
        List<Teacher> teachers = teacherService.getAll();
        model.addAttribute("teachers", teachers);
        return "teachers";
    }

    @GetMapping("/create-teacher")
    public String showNewEmployeeForm( Model model) {
        Teacher teacher = new Teacher();
        model.addAttribute("teacher", teacher);
        return "create-teacher";
    }

    @PostMapping("/save-teacher")
    public String saveEmployee(@ModelAttribute("teacher") Teacher teacher) {
        teacherService.save(teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/update-teacher/{id}")
    public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
        Teacher teacher = teacherService.getById(id);
        model.addAttribute("teacher", teacher);
        return "update-teacher";
    }


}
