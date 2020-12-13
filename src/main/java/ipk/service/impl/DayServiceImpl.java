package ipk.service.impl;

import ipk.model.Day;
import ipk.repository.DayRepository;
import ipk.service.DayService;
import org.springframework.stereotype.Service;

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
}