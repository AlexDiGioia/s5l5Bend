package alexdigioia.s5l5Bend.services;

import alexdigioia.s5l5Bend.entities.Edificio;
import alexdigioia.s5l5Bend.entities.Postazione;
import alexdigioia.s5l5Bend.repositories.EdificioRepository;
import alexdigioia.s5l5Bend.repositories.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataBaseCreazioneDefault {

    @Autowired
    private EdificioRepository edificioRepository;

    @Autowired
    private PostazioneRepository postazioneRepository;

    @Autowired
    private Edificio recintoTRex;

    @Autowired
    private Edificio millenniumFalcon;

    @Autowired
    private Postazione postazionePrivata;

    @Autowired
    private Postazione cabinaPilotaggio;

    public void startDatabase() {
        edificioRepository.save(recintoTRex);
        edificioRepository.save(millenniumFalcon);

        postazioneRepository.save(postazionePrivata);
        postazioneRepository.save(cabinaPilotaggio);
    }
}
