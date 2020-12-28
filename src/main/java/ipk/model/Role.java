package ipk.model;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private RoleName roleName;

    public enum RoleName {
        LISTENER, ADMIN
    }
}
