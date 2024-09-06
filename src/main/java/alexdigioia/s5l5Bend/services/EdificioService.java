package alexdigioia.s5l5Bend.services;

import alexdigioia.s5l5Bend.entities.Edificio;
import alexdigioia.s5l5Bend.repositories.EdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EdificioService {

    @Autowired
    private EdificioRepository edificioRepository;

    public Edificio salvaEdificio(Edificio edificio) {
        return edificioRepository.save(edificio);
    }

    public Edificio trovaEdificio(UUID id) {
        return edificioRepository.findById(id).orElse(null);
    }
}