package ipk.service.impl;

import ipk.model.Day;
import ipk.repository.DayRepository;
import ipk.service.DayService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DayServiceImpl implements DayService {
    private final DayRepository dayRepository;

    public DayServiceImpl(DayRepository dayRepository) {
        this.dayRepository = dayRepository;
    }

    @Override
    public Day save(Day day) {
        return dayRepository.save(day);
    }

    @Override
    public List<Day> getAll() {
        return dayRepository.findAll();
    }
}
