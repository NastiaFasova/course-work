package ipk.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "listener")
public class Listener {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String email;
}
