package ipk.service.impl;

import ipk.model.Subject;
import ipk.repository.SubjectRepository;
import ipk.service.SubjectService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public List<Subject> getAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject getById(long id) {
        return subjectRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Subject getByTitle(String subject) {
        return subjectRepository.findByTitle(subject);
    }

    @Override
    public Object getAllByKeyword(String keyword) {
        return subjectRepository.getAllByKeyword(keyword);
    }
}
