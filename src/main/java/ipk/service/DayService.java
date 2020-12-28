package ipk.service;

import java.util.List;
import ipk.model.Day;

public interface DayService {
    Day save(Day day);

    List<Day> getAll();
}
