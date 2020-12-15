package ipk.service;

import ipk.model.Day;

import java.util.List;

public interface DayService {
    Day save(Day day);

    List<Day> getAll();
}
