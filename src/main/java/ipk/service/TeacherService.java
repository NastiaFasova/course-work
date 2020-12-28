package ipk.service;

import java.util.List;
import ipk.model.Teacher;

public interface TeacherService {
    Teacher save(Teacher role);

    List<Teacher> getAll();

    Teacher getById(long id);

    void deleteTeacherById(long id);

    Teacher getBySurname(String surname);

    List<Teacher> getAllByKeyword(String keyword);
}

