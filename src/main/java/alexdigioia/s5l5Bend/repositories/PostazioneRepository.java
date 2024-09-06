package alexdigioia.s5l5Bend.repositories;

import alexdigioia.s5l5Bend.entities.Postazione;
import alexdigioia.s5l5Bend.entities.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, UUID> {
    List<Postazione> findByTipoAndEdificio_Citta(TipoPostazione tipo, String citta);
}