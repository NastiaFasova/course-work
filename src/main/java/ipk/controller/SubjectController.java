package ipk.controller;

import ipk.model.*;
import ipk.service.SubjectService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SubjectController {
    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/subjects")
    public String viewSubjects(Model model, String keyword) {
        if(keyword != null) {
            model.addAttribute("subjects", subjectService.getAllByKeyword(keyword));
        } else {
            List<Subject> subjects = subjectService.getAll();
            model.addAttribute("subjects", subjects);
        }
        return "subjects";
    }

    @GetMapping("/create-subject")
    public String showNewEmployeeForm( Model model) {
        Subject subject = new Subject();
        model.addAttribute("subject", subject);
        return "create-subject";
    }

    @PostMapping("/save-subject")
    public String saveEmployee(@ModelAttribute("subject") Subject subject) {
        subjectService.save(subject);
        return "redirect:/subjects";
    }

    @GetMapping("/update-subject/{id}")
    public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
        Subject subject = subjectService.getById(id);
        model.addAttribute("subject", subject);
        return "update-subject";
    }
}
