package ipk.service.impl;

import ipk.model.Teacher;
import ipk.repository.TeacherRepository;
import ipk.service.TeacherService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> getAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher getById(long id) {
        return teacherRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public void deleteTeacherById(long id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public Teacher getBySurname(String surname) {
        return teacherRepository.findBySurname(surname);
    }

    @Override
    public List<Teacher> getAllByKeyword(String keyword) {
        return teacherRepository.getAllByKeyword(keyword);
    }
}
