package ipk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalTime;
import java.util.Set;

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
    @OneToMany
    private Set<Day> days;
    private LocalTime time;

    public Lesson(Teacher teacher, Subject subject,
                  Set<Day> days, LocalTime time) {
        this.teacher = teacher;
        this.subject = subject;
        this.days = days;
        this.time = time;
    }
}
