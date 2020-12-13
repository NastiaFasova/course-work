package ipk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "listeners_group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    private List<Listener> listeners = new ArrayList<>();
    private LocalDate startOfStudying;
    @ManyToMany
    private List<Lesson> lessons = new ArrayList<>();

    public Group(List<Listener> listeners) {
        this.listeners = listeners;
    }
}
