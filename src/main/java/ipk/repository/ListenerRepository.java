package ipk.repository;

import ipk.model.Listener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ListenerRepository extends JpaRepository<Listener, Long> {
    @Query("SELECT l FROM Listener l LEFT JOIN FETCH l.roles Role where l.email = :email")
    Listener findByEmail(String email);
}
