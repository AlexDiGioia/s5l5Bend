package alexdigioia.s5l5Bend.services;

import alexdigioia.s5l5Bend.entities.Prenotazione;
import alexdigioia.s5l5Bend.repositories.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public Prenotazione savePrenotazione(Prenotazione prenotazione) throws Exception {

        boolean exists = prenotazioneRepository.existsByPostazioneAndDataPrenotazione(prenotazione.getPostazione(), prenotazione.getDataPrenotazione());
        if (exists) {  //controlla se esiste una prenotazione con la stessa data di quella che voglio inserire
            throw new Exception("Questa data non è disponibile, qualcuno ha prenotato prima di te.");
        }
        return prenotazioneRepository.save(prenotazione);
    }

    public List<Prenotazione> findAll() {
        return prenotazioneRepository.findAll();
    }
}