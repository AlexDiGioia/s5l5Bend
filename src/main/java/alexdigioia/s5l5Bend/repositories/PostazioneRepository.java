package alexdigioia.s5l5Bend.repositories;

import alexdigioia.s5l5Bend.entities.Postazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, UUID> {

    //List<Postazione> find();

    List<Postazione> findAllByDescrizione(String descrizione);

    Optional<Postazione> findByDescrizione(String descrizione);
}