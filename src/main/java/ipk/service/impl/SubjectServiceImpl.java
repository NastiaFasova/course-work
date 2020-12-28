package ipk.service.impl;

import java.util.List;
import ipk.model.Subject;
import ipk.repository.SubjectRepository;
import ipk.service.SubjectService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {
    private static final Logger LOGGER = Logger.getLogger(SubjectServiceImpl.class);
    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Subject save(Subject subject) {
        LOGGER.info("The subject was saved");
        return subjectRepository.save(subject);
    }

    @Override
    public List<Subject> getAll() {
        LOGGER.info("The subjects were retrieved");
        return subjectRepository.findAll();
    }

    @Override
    public Subject getById(long id) {
        LOGGER.info("The subject was retrieved by id");
        return subjectRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Subject getByTitle(String subject) {
        LOGGER.info("The subject was retrieved by title");
        return subjectRepository.findByTitle(subject);
    }

    @Override
    public Object getAllByKeyword(String keyword) {
        LOGGER.info("The subject was retrieved by keyword");
        return subjectRepository.getAllByKeyword(keyword);
    }
}
