package alexdigioia.s5l5Bend.repositories;

import alexdigioia.s5l5Bend.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, String> {
}
