package ipk.model;

import java.util.Set;
import javax.persistence.*;
import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "lesson")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Teacher teacher;
    @ManyToOne
    private Subject subject;
    @ManyToMany
    private Set<Day> days;
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime time;

    public Lesson(Teacher teacher, Subject subject,
                  Set<Day> days, LocalTime time) {
        this.teacher = teacher;
        this.subject = subject;
        this.days = days;
        this.time = time;
    }
}
