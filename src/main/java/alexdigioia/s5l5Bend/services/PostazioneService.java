package alexdigioia.s5l5Bend.services;

import alexdigioia.s5l5Bend.entities.Postazione;
import alexdigioia.s5l5Bend.repositories.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PostazioneService {

    @Autowired
    private PostazioneRepository postazioneRepository;

    public Postazione salvaPostazione(Postazione postazione) {
        return postazioneRepository.save(postazione);
    }

    public Postazione trovaPostazione(UUID id) {
        return postazioneRepository.findById(id).orElse(null);
    }

    public List<Postazione> findAllByDescrizione(String descrizione) {
        return postazioneRepository.findAllByDescrizione(descrizione);
    }

    public Optional<Postazione> findByDescrizione(String descrizione) {
        return postazioneRepository.findByDescrizione(descrizione);
    }

}