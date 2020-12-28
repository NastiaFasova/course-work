package ipk.controller;

import java.util.List;
import ipk.model.Teacher;
import ipk.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers")
    public String viewTeacherPage(Model model, String keyword) {
        if(keyword != null) {
            model.addAttribute("teachers", teacherService.getAllByKeyword(keyword));
        } else {
            List<Teacher> teachers = teacherService.getAll();
            model.addAttribute("teachers", teachers);
        }
        return "model/teachers";
    }

    @GetMapping("/create-teacher")
    public String showNewTeacherForm( Model model) {
        Teacher teacher = new Teacher();
        model.addAttribute("teacher", teacher);
        return "create/teacher";
    }

    @PostMapping("/save-teacher")
    public String saveTeacher(@ModelAttribute("teacher") Teacher teacher) {
        teacherService.save(teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/update-teacher/{id}")
    public String showFormForTeacherUpdate(@PathVariable ( value = "id") long id, Model model) {
        Teacher teacher = teacherService.getById(id);
        model.addAttribute("teacher", teacher);
        return "update/teacher";
    }
}
