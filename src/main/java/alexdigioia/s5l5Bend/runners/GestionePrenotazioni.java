package alexdigioia.s5l5Bend.runners;

import alexdigioia.s5l5Bend.entities.Postazione;
import alexdigioia.s5l5Bend.entities.Prenotazione;
import alexdigioia.s5l5Bend.entities.Utente;
import alexdigioia.s5l5Bend.repositories.PrenotazioneRepository;
import alexdigioia.s5l5Bend.repositories.UtenteRepository;
import alexdigioia.s5l5Bend.services.DataBaseCreazioneDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class GestionePrenotazioni implements CommandLineRunner {

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private Postazione postazionePrivata;

    @Autowired
    private Postazione cabinaPilotaggio;

    @Autowired
    private DataBaseCreazioneDefault dataBaseCreazioneDefault;

    @Override
    public void run(String... args) throws Exception {

        dataBaseCreazioneDefault.startDatabase();

        Utente utente1 = new Utente("luke", "Luke Skywalker", "luke@jedi.com");
        Utente utente2 = new Utente("Aldo", "Aldo Ciccipuzzi", "aldo@puzzi.com");
        utenteRepository.save(utente1);
        utenteRepository.save(utente2);

        Prenotazione prenotazione1 = new Prenotazione(null, utente1, cabinaPilotaggio, LocalDate.now().plusDays(1));
        Prenotazione prenotazione2 = new Prenotazione(null, utente2, postazionePrivata, LocalDate.now().plusDays(2));
        prenotazioneRepository.save(prenotazione1);
        prenotazioneRepository.save(prenotazione2);

        System.out.println("Utenti salvati:");
        utenteRepository.findAll().forEach(System.out::println);
        System.out.println("Prenotazioni salvate:");
        prenotazioneRepository.findAll().forEach(System.out::println);
    }
}