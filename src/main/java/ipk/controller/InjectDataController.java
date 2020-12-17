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
    private final SpecialityService specialityService;
    private final TeacherService teacherService;
    private final SubjectService subjectService;
    private final DayService dayService;
    private final GroupService groupService;
    private final LessonService lessonService;

    public InjectDataController(ListenerService listenerService, SpecialityService specialityService,
                                TeacherService teacherService,
                                SubjectService subjectService,
                                DayService dayService, GroupService groupService,
                                LessonService lessonService) {
        this.listenerService = listenerService;
        this.specialityService = specialityService;
        this.teacherService = teacherService;
        this.subjectService = subjectService;
        this.dayService = dayService;
        this.groupService = groupService;
        this.lessonService = lessonService;
    }

    @PostConstruct
    public void injectData() {
        Listener admin = new Listener();
        admin.setName("Dan");
        admin.setEmail("prylipk099@Gmail.com");
        admin.setSurname("Prylipko");

        listenerService.save(admin);
        Listener listener1 = new Listener();
        listener1.setName("Olha");
        listener1.setSurname("Kyrychuk");
        listener1.setEmail("kyrychuk@Gmail.com");
        listenerService.save(listener1);
        Listener listener2 = new Listener();
        listener2.setName("Ivan");
        listener2.setSurname("Pivnyk");
        listener2.setEmail("pivan636@gmail.com");
        listenerService.save(listener2);
        Listener listener3 = new Listener();
        listener3.setName("Oleg");
        listener3.setSurname("Grishko");
        listener3.setEmail("megaman228@Gmail.com");
        listenerService.save(listener3);
        Listener listener4 = new Listener();
        listener4.setName("Ira");
        listener4.setSurname("Revko");
        listener4.setEmail("IraRevko24@Gmail.com");
        listenerService.save(listener4);
        Listener listener5 = new Listener();
        listener5.setName("Kolya");
        listener5.setSurname("Krabov");
        listener5.setEmail("krabovychkolyan@Gmail.com");
        listenerService.save(listener5);
        Listener listener6 = new Listener();
        listener6.setName("Olha");
        listener6.setSurname("Kyrychuk");
        listener6.setEmail("kyrychuk@gmail.com");
        listenerService.save(listener6);
        Listener listener7 = new Listener();
        listener7.setName("Oleh");
        listener7.setSurname("Pivanchenko");
        listener7.setEmail("ohpiv@gmail.com");
        listenerService.save(listener7);
        Listener listener8 = new Listener();
        listener8.setName("Taras");
        listener8.setSurname("Gonchar");
        listener8.setEmail("targonnn@Gmail.com");
        listenerService.save(listener8);
        Listener listener9 = new Listener();
        listener9.setName("Ryslan");
        listener9.setSurname("Pysanka");
        listener9.setEmail("ilovepizza3434@Gmail.com");
        listenerService.save(listener9);
        Listener listener10 = new Listener();
        listener10.setName("Nastya");
        listener10.setSurname("Fasova");
        listener10.setEmail("thebestproggramer@Gmail.com");
        listenerService.save(listener10);
        Listener listener11 = new Listener();
        listener11.setName("Andriy");
        listener11.setSurname("Lomachenko");
        listener11.setEmail("lomach333@gmail.com");
        listenerService.save(listener11);
        Listener listener12 = new Listener();
        listener12.setName("Ronald");
        listener12.setSurname("Priest");
        listener12.setEmail("rontheKing@gmail.com");
        listenerService.save(listener12);
        Listener listener13 = new Listener();
        listener13.setName("Lola");
        listener13.setSurname("Bystrytska");
        listener13.setEmail("lolathelove@Gmail.com");
        listenerService.save(listener13);
        Listener listener14 = new Listener();
        listener14.setName("Kira");
        listener14.setSurname("Maistrenko");
        listener14.setEmail("clashofclansKira@Gmail.com");
        listenerService.save(listener14);
        Listener listener15 = new Listener();
        listener15.setName("Rick");
        listener15.setSurname("Kobzov");
        listener15.setEmail("rickandmorti4523@Gmail.com");
        listenerService.save(listener15);
        Listener listener16 = new Listener();
        listener16.setName("Mariya");
        listener16.setSurname("Dermanskaya");
        listener16.setEmail("mashadermasha@gmail.com");
        listenerService.save(listener16);
        Listener listener17 = new Listener();
        listener17.setName("Igor");
        listener17.setSurname("Kobzov");
        listener17.setEmail("Ipaspspa34@gmail.com");
        listenerService.save(listener17);
        Listener listener18 = new Listener();
        listener18.setName("Tanya");
        listener18.setSurname("Nalyvaiko");
        listener18.setEmail("nalyvayNePytai@Gmail.com");
        listenerService.save(listener18);
        Listener listener19 = new Listener();
        listener19.setName("Katya");
        listener19.setSurname("Garmash");
        listener19.setEmail("katyhagramash2345@Gmail.com");
        listenerService.save(listener19);
        Listener listener20 = new Listener();
        listener20.setName("Lisa");
        listener20.setSurname("Kostryk");
        listener20.setEmail("koster89129@Gmail.com");
        listenerService.save(listener20);
        Listener listener21 = new Listener();
        listener21.setName("Katya");
        listener21.setSurname("Pyshkevych");
        listener21.setEmail("pyshka228@gmail.com");
        listenerService.save(listener21);
        Listener listener22 = new Listener();
        listener22.setName("Bogdan");
        listener22.setSurname("Afanasenko");
        listener22.setEmail("bodyaSkeyter@gmail.com");
        listenerService.save(listener22);
        Listener listener23 = new Listener();
        listener23.setName("Ivan");
        listener23.setSurname("Morgenshtern");
        listener23.setEmail("kogdaYaPomenayFamiliy@Gmail.com");
        listenerService.save(listener23);
        Listener listener24 = new Listener();
        listener24.setName("Artyr");
        listener24.setSurname("Vlasovskiy");
        listener24.setEmail("lordOfRings299@Gmail.com");
        listenerService.save(listener24);
        Listener listener25 = new Listener();
        listener25.setName("Rystam");
        listener25.setSurname("Kozakevych");
        listener25.setEmail("kozak228@Gmail.com");
        listenerService.save(listener25);
        Listener listener26 = new Listener();
        listener26.setName("Anatoliy");
        listener26.setSurname("Chaika");
        listener26.setEmail("iLoveTrains256@gmail.com");
        listenerService.save(listener26);
        Listener listener27 = new Listener();
        listener27.setName("Olya");
        listener27.setSurname("Kornilovych");
        listener27.setEmail("korni9021@gmail.com");
        listenerService.save(listener27);
        Listener listener28 = new Listener();
        listener28.setName("Maksym");
        listener28.setSurname("Bylava");
        listener28.setEmail("iLoveLearning@Gmail.com");
        listenerService.save(listener28);
        Listener listener29 = new Listener();
        listener29.setName("Anastasia");
        listener29.setSurname("Kyzuk");
        listener29.setEmail("iAmTheStarosta25@Gmail.com");
        listenerService.save(listener29);
        Listener listener30 = new Listener();
        listener30.setName("Igor");
        listener30.setSurname("Ryskiy");
        listener30.setEmail("igorokKogotok234@Gmail.com");
        listenerService.save(listener30);

        Subject subject1 = new Subject("Math");
        Subject subject2 = new Subject("Ecology");
        Subject subject3 = new Subject("OOP");
        Subject subject4 = new Subject("Computer sciences");
        Subject subject5 = new Subject("Databases");
        Subject subject6 = new Subject("Software engineering components");
        Subject subject7 = new Subject("Programming technologies");
        Subject subject8 = new Subject("Technical English");
        Subject subject9 = new Subject("Algorithms");
        Subject subject10 = new Subject("Data structure");
        Subject subject11 = new Subject("French");
        Subject subject12 = new Subject("Probability theory");
        Subject subject13 = new Subject("German");
        Subject subject14= new Subject("Philosophy");
        Subject subject15 = new Subject("History");

        subjectService.save(subject1);
        subjectService.save(subject2);
        subjectService.save(subject3);
        subjectService.save(subject4);
        subjectService.save(subject5);
        subjectService.save(subject6);
        subjectService.save(subject7);
        subjectService.save(subject8);
        subjectService.save(subject9);
        subjectService.save(subject10);
        subjectService.save(subject11);
        subjectService.save(subject12);
        subjectService.save(subject13);
        subjectService.save(subject14);
        subjectService.save(subject15);

        Teacher teacher1 = new Teacher("Havryliuk","Natalia Anatiliivna");
        Teacher teacher2 = new Teacher("Vladimirov", "Volodymyr Mykolayovych");
        Teacher teacher3 = new Teacher("Olih", "Ihor Ivanovuch");
        Teacher teacher4 = new Teacher("Surikova", "Natalia Andriivna");
        Teacher teacher5 = new Teacher("Savliuk", "Olena Anatiliivna");
        Teacher teacher6 = new Teacher("Haustov", "Andriy Borysovych");
        Teacher teacher7 = new Teacher("Larpiuk", "Serhiy Mytrophanovych");
        Teacher teacher8 = new Teacher("Kuzmenko", "Oleh Ihorovych");
        Teacher teacher9 = new Teacher("Karpenko", "Mykolay Volodymyrovych");
        Teacher teacher10 = new Teacher("Shtyfurak", "Anatoliy Volodymyrovych");
        Teacher teacher11 = new Teacher("Merenger","Petro Petrovych");
        Teacher teacher12 = new Teacher("Tarnavskiy", "Yriy Adamovych");
        Teacher teacher13 = new Teacher("Shvaiko", "Valeriy Grygorovych");
        Teacher teacher14 = new Teacher("Smakovskiy", "Denys Sergiyovych");
        Teacher teacher15 = new Teacher("Shkapatiyk", "Angela Anatoliivna");
        Teacher teacher16 = new Teacher("Abdulin", "Myhailo Zagretdinovych");
        Teacher teacher17 = new Teacher("Panasovska", "Olena Feodosiivna");


        teacherService.save(teacher1);
        teacherService.save(teacher2);
        teacherService.save(teacher3);
        teacherService.save(teacher4);
        teacherService.save(teacher5);
        teacherService.save(teacher6);
        teacherService.save(teacher7);
        teacherService.save(teacher8);
        teacherService.save(teacher9);
        teacherService.save(teacher10);
        teacherService.save(teacher11);
        teacherService.save(teacher12);
        teacherService.save(teacher13);
        teacherService.save(teacher14);
        teacherService.save(teacher15);
        teacherService.save(teacher16);
        teacherService.save(teacher17);


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

        Lesson lesson1 = new Lesson(teacher1, subject1,Set.of(monday),
                LocalTime.of(8, 30));
        Lesson lesson2 = new Lesson(teacher2, subject2,
                Set.of(monday), LocalTime.of(10, 30));
        Lesson lesson3 = new Lesson(teacher3, subject3,
                Set.of(monday), LocalTime.of(14, 10));
        Lesson lesson4 = new Lesson(teacher4, subject4,
                Set.of(monday), LocalTime.of(16, 00));
        Lesson lesson5 = new Lesson(teacher5, subject5,
                Set.of(tuesday), LocalTime.of(8, 30));
        Lesson lesson6 = new Lesson(teacher6, subject6,
                Set.of(tuesday), LocalTime.of(10, 30));
        Lesson lesson7 = new Lesson(teacher7, subject7,
                Set.of(tuesday), LocalTime.of(12, 30));
        Lesson lesson8 = new Lesson(teacher8, subject8,
                Set.of(wednesday), LocalTime.of(8, 30));
        Lesson lesson9 = new Lesson(teacher9, subject9,
                Set.of(wednesday), LocalTime.of(10, 30));
        Lesson lesson10 = new Lesson(teacher10, subject10,
                Set.of(wednesday), LocalTime.of(13, 30));
        Lesson lesson11 = new Lesson(teacher1, subject10,
                Set.of(wednesday), LocalTime.of(15, 30));
        Lesson lesson12 = new Lesson(teacher10, subject7,
                Set.of(thursday), LocalTime.of(9, 30));
        Lesson lesson13 = new Lesson(teacher6, subject3,
                Set.of(thursday), LocalTime.of(13, 30));
        Lesson lesson14 = new Lesson(teacher5, subject2,
                Set.of(thursday), LocalTime.of(16, 00));
        Lesson lesson15 = new Lesson(teacher3, subject1,
                Set.of(friday), LocalTime.of(8, 30));
        Lesson lesson16 = new Lesson(teacher15, subject14,
                Set.of(friday), LocalTime.of(11, 30));
        Lesson lesson17 = new Lesson(teacher12, subject12,
                Set.of(friday), LocalTime.of(13, 30));
        Lesson lesson18 = new Lesson(teacher13, subject8,
                Set.of(friday), LocalTime.of(15, 30));
        Lesson lesson19 = new Lesson(teacher17, subject15,
                Set.of(friday), LocalTime.of(17, 30));
        Lesson lesson20 = new Lesson(teacher16, subject14,
                Set.of(wednesday), LocalTime.of(17, 30));
        lessonService.save(lesson1);
        lessonService.save(lesson2);
        lessonService.save(lesson3);
        lessonService.save(lesson4);
        lessonService.save(lesson5);
        lessonService.save(lesson6);
        lessonService.save(lesson7);
        lessonService.save(lesson8);
        lessonService.save(lesson9);
        lessonService.save(lesson10);
        lessonService.save(lesson11);
        lessonService.save(lesson12);
        lessonService.save(lesson13);
        lessonService.save(lesson14);
        lessonService.save(lesson15);
        lessonService.save(lesson16);
        lessonService.save(lesson17);
        lessonService.save(lesson18);
        lessonService.save(lesson19);
        lessonService.save(lesson20);

        Group group1 = new Group();
        group1.setStartOfStudying(LocalDate.of(2020, 9, 1));
        group1.setListeners(List.of(listener1, listener2, listener3,  listener7, listener20, listener21,
                listener12, listener15, listener4));
        group1.setLessons(List.of(lesson1, lesson2, lesson3, lesson10, lesson9, lesson11, lesson20, lesson15));
        Group group2 = new Group();
        group2.setStartOfStudying(LocalDate.of(2020, 9, 1));
        group2.setListeners(List.of(listener1, listener5, listener15, listener11,
                listener19, listener25, listener29, listener17));
        group2.setLessons(List.of(lesson3, lesson7,  lesson6, lesson12,  lesson15, lesson1, lesson10, lesson11));
        Group group3 = new Group();
        group3.setStartOfStudying(LocalDate.of(2020, 9, 1));
        group3.setListeners(List.of(listener1, listener15, listener13, listener10, listener11, listener19, listener8,
                listener6, listener7));
        group3.setLessons(List.of(lesson1, lesson2, lesson9, lesson14, lesson8, lesson16, lesson3, lesson20));
        Group group4 = new Group();
        group4.setStartOfStudying(LocalDate.of(2020, 9, 1));
        group4.setListeners(List.of(listener1, listener11, listener15, listener16,  listener21, listener22, listener23,
                listener28, listener4, listener14));
        group4.setLessons(List.of(lesson1, lesson4,  lesson11, lesson3, lesson9, lesson12, lesson18, lesson20));
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
