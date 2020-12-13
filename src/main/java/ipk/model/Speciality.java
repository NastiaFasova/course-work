package ipk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "speciality")
public class Speciality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int numberOfStudyingPerYear;
    private int monthsOfStudying;
    private boolean dormitory;
    @OneToMany
    private List<Group> groups;

    public Speciality(String name, int numberOfStudyingPerYear, int monthsOfStudying, boolean dormitory) {
        this.name = name;
        this.numberOfStudyingPerYear = numberOfStudyingPerYear;
        this.monthsOfStudying = monthsOfStudying;
        this.dormitory = dormitory;
    }
}
