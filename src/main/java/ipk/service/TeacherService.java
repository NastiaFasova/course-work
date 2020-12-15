package ipk.service;


import ipk.model.Subject;
import ipk.model.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher save(Teacher role);

    List<Teacher> getAll();

    Teacher getById(long id);

    void deleteTeacherById(long id);
}

