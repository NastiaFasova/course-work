package ipk.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "listener")
public class Listener {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    @Column(unique = true)
    private String email;
    private String password;
    @ManyToMany
    private Set<Role> roles = new HashSet<>();
}
