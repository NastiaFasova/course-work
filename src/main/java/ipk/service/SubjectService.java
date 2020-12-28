package ipk.service;

import ipk.model.Subject;
import java.util.List;

public interface SubjectService {
    Subject save(Subject subject);

    List<Subject> getAll();

    Subject getById(long id);

    Subject getByTitle(String subject);

    Object getAllByKeyword(String keyword);
}
