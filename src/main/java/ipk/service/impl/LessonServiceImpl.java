package ipk.service.impl;

import ipk.model.Lesson;
import ipk.repository.LessonRepository;
import ipk.service.LessonService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class LessonServiceImpl implements LessonService {
    private static final Logger LOGGER = Logger.getLogger(LessonServiceImpl.class);
    private final LessonRepository lessonRepository;

    public LessonServiceImpl(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }


    @Override
    public Lesson save(Lesson lesson) {
        LOGGER.info("The lesson was saved");
        return lessonRepository.save(lesson);
    }

    @Override
    public Lesson getById(Long id) {
        LOGGER.info("The lesson was retrieved by id");
        return lessonRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
