package ipk.controller;

import java.util.List;
import ipk.model.Speciality;
import ipk.service.SpecialityService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SpecialityController {
    private final SpecialityService specialityService;

    public SpecialityController(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        return findPaginated(1, "name", "asc", model);
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;
        Page<Speciality> page
                = specialityService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Speciality> specialities = page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("specialities", specialities);
        return "model/speciality";
    }

    @GetMapping("/create-speciality")
    public String showNewEmployeeForm( Model model) {
        Speciality speciality = new Speciality();
        model.addAttribute("speciality", speciality);
        return "create/speciality";
    }

    @PostMapping("/save-speciality")
    public String saveEmployee(@ModelAttribute("speciality") Speciality speciality) {
        specialityService.save(speciality);
        return "redirect:/";
    }

    @GetMapping("/{id}/update-speciality")
    public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
        Speciality speciality = specialityService.getById(id);
        model.addAttribute("speciality", speciality);
        return "update/speciality";
    }

    @GetMapping("{id}/delete-speciality")
    public String removeLesson(@PathVariable (value = "id") long id) {
        specialityService.deleteById(id);
        return "redirect:/";
    }
}
