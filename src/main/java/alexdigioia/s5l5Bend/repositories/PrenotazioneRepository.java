package alexdigioia.s5l5Bend.repositories;

import alexdigioia.s5l5Bend.entities.Postazione;
import alexdigioia.s5l5Bend.entities.Prenotazione;
import alexdigioia.s5l5Bend.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, UUID> {

    List<Prenotazione> findByUtenteAndDataPrenotazione(Utente utente, LocalDate dataPrenotazione);

    List<Prenotazione> findByPostazioneAndDataPrenotazione(Prenotazione postazione, LocalDate dataPrenotazione);

    boolean existsByPostazioneAndDataPrenotazione(Postazione postazione, LocalDate data);
}
