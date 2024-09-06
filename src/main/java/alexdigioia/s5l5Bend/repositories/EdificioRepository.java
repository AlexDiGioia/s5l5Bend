package alexdigioia.s5l5Bend.repositories;

import alexdigioia.s5l5Bend.entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, UUID> {
}
