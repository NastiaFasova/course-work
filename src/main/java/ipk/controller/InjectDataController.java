package ipk.controller;

import ipk.model.*;
import ipk.service.*;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Controller
public class InjectDataController {
    private final ListenerService listenerService;
    private final RoleService roleService;
    private final SpecialityService specialityService;
    private final TeacherService teacherService;
    private final SubjectService subjectService;
    private final DayService dayService;
    private final GroupService groupService;
    private final LessonService lessonService;

    public InjectDataController(ListenerService listenerService, RoleService
            roleService, SpecialityService specialityService,
                                TeacherService teacherService,
                                SubjectService subjectService,
                                DayService dayService, GroupService groupService,
                                LessonService lessonService) {
        this.listenerService = listenerService;
        this.roleService = roleService;
        this.specialityService = specialityService;
        this.teacherService = teacherService;
        this.subjectService = subjectService;
        this.dayService = dayService;
        this.groupService = groupService;
        this.lessonService = lessonService;
    }

    @PostConstruct
    public void injectData() {
        Role role = new Role();
        role.setRoleName(Role.RoleName.ADMIN);
        roleService.save(role);
        System.out.println("Role was saved");
        Listener admin = new Listener();
        admin.setName("Dan");
        admin.setEmail("prylipk099@Gmail.com");
        admin.setSurname("Prylipko");
        admin.setPassword("1111");
        admin.setRoles(Set.of(role));

        listenerService.save(admin);
        Role listener = new Role();
        listener.setRoleName(Role.RoleName.LISTENER);
        roleService.save(listener);
        Listener listener1 = new Listener();
        listener1.setName("Olha");
        listener1.setSurname("Kyrychuk");
        listener1.setEmail("kyrychuk@Gmail.com");
        listener1.setPassword("9999");
        listener1.setRoles(Set.of(listener));
        listenerService.save(listener1);

        Subject subject1 = new Subject("Math");
        Subject subject2 = new Subject("Ecology");
        Subject subject3 = new Subject("OOP");
        Subject subject4 = new Subject("Computer sciences");
        Subject subject5 = new Subject("Databases");

        subjectService.save(subject1);
        subjectService.save(subject2);
        subjectService.save(subject3);
        subjectService.save(subject4);
        subjectService.save(subject5);

        Teacher teacher1 = new Teacher("Havryliuk","Natalia Anatiliivna");
        Teacher teacher2 = new Teacher("Vladimirov", "Volodymyr Mykolayovych");
        Teacher teacher3 = new Teacher("Olih", "Ihor Ivanovuch");
        Teacher teacher4 = new Teacher("Surikova", "Natalia Andriivna");
        Teacher teacher5 = new Teacher("Savliuk", "Olena Anatiliivna");

        teacherService.save(teacher1);
        teacherService.save(teacher2);
        teacherService.save(teacher3);
        teacherService.save(teacher4);
        teacherService.save(teacher5);

        Day monday = new Day(Day.DayOfWeek.MONDAY);
        Day tuesday = new Day(Day.DayOfWeek.TUESDAY);
        Day wednesday = new Day(Day.DayOfWeek.WEDNESDAY);
        Day thursday = new Day(Day.DayOfWeek.THURSDAY);
        Day friday = new Day(Day.DayOfWeek.FRIDAY);
        dayService.save(monday);
        dayService.save(tuesday);
        dayService.save(wednesday);
        dayService.save(thursday);
        dayService.save(friday);

        Lesson lesson1 = new Lesson(teacher1, subject1,
                Set.of(monday), LocalTime.of(8, 30));
        Lesson lesson2 = new Lesson(teacher2, subject2,
                Set.of(tuesday), LocalTime.of(10, 30));
        Lesson lesson3 = new Lesson(teacher3, subject3,
                Set.of(wednesday), LocalTime.of(8, 30));
        Lesson lesson4 = new Lesson(teacher4, subject4,
                Set.of(thursday), LocalTime.of(8, 30));
        Lesson lesson5 = new Lesson(teacher5, subject5,
                Set.of(friday), LocalTime.of(8, 30));
        lessonService.save(lesson1);
        lessonService.save(lesson2);
        lessonService.save(lesson3);
        lessonService.save(lesson4);
        lessonService.save(lesson5);

        Group group1 = new Group();
        group1.setStartOfStudying(LocalDate.of(2020, 9, 1));
        group1.setListeners(List.of(listener1));
        group1.setLessons(List.of(lesson1, lesson2));
        Group group2 = new Group();
        group2.setStartOfStudying(LocalDate.of(2020, 9, 1));
        group2.setListeners(List.of(listener1));
        group2.setLessons(List.of(lesson3));
        Group group3 = new Group();
        group3.setStartOfStudying(LocalDate.of(2020, 9, 1));
        group3.setListeners(List.of(listener1));
        group3.setLessons(List.of(lesson1, lesson2));
        Group group4 = new Group();
        group4.setStartOfStudying(LocalDate.of(2020, 9, 1));
        group4.setListeners(List.of(listener1));
        group4.setLessons(List.of(lesson1, lesson4));
        groupService.save(group1);
        groupService.save(group2);
        groupService.save(group3);
        groupService.save(group4);

        Speciality speciality1 = new Speciality("IT",
                4, 2, true);
        speciality1.setGroups(List.of(group1));
        Speciality speciality2 = new Speciality("САПР",
                2, 2, true);
        speciality2.setGroups(List.of(group2));
        Speciality speciality3 = new Speciality("СКБД",
                2, 1, false);
        speciality3.setGroups(List.of(group3));
        Speciality speciality4 = new Speciality("ОС",
                4, 1, false);
        speciality4.setGroups(List.of(group4));
        specialityService.save(speciality1);
        specialityService.save(speciality2);
        specialityService.save(speciality3);
        specialityService.save(speciality4);

    }
}
