package ipk.service;

import ipk.model.Lesson;

public interface LessonService {

    Lesson save(Lesson lesson);

    Lesson getById(Long id);
}
