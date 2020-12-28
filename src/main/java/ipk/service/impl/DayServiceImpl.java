package ipk.service.impl;

import java.util.List;
import ipk.model.Day;
import ipk.repository.DayRepository;
import ipk.service.DayService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class DayServiceImpl implements DayService {
    private static final Logger LOGGER = Logger.getLogger(DayServiceImpl.class);
    private final DayRepository dayRepository;

    public DayServiceImpl(DayRepository dayRepository) {
        this.dayRepository = dayRepository;
    }

    @Override
    public Day save(Day day) {
        LOGGER.info("The day was saved");
        return dayRepository.save(day);
    }

    @Override
    public List<Day> getAll() {
        LOGGER.info("The days wer retrieved");
        return dayRepository.findAll();
    }
}
