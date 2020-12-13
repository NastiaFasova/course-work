package ipk.service.impl;

import ipk.model.Lesson;
import ipk.repository.LessonRepository;
import ipk.service.LessonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;

    public LessonServiceImpl(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }


    @Override
    public Lesson save(Lesson lesson) {
        return lessonRepository.save(lesson);
    }
}
