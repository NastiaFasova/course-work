package ipk.service.impl;

import ipk.model.Teacher;
import ipk.repository.TeacherRepository;
import ipk.service.TeacherService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    private static final Logger LOGGER = Logger.getLogger(TeacherServiceImpl.class);
    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teacher save(Teacher teacher) {
        LOGGER.info("The teacher was saved");
        return teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> getAll() {
        LOGGER.info("The teachers were retrieved");
        return teacherRepository.findAll();
    }

    @Override
    public Teacher getById(long id) {
        LOGGER.info("The teacher was retrieved by id");
        return teacherRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public void deleteTeacherById(long id) {
        LOGGER.info("The teacher was removed");
        teacherRepository.deleteById(id);
    }

    @Override
    public Teacher getBySurname(String surname) {
        LOGGER.info("The teacher was retrieved by surname");
        return teacherRepository.findBySurname(surname);
    }

    @Override
    public List<Teacher> getAllByKeyword(String keyword) {
        LOGGER.info("The teachers were retrieved by keyword");
        return teacherRepository.getAllByKeyword(keyword);
    }
}
