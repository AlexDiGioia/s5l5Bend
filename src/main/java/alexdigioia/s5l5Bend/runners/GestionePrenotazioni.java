package alexdigioia.s5l5Bend.runners;

import alexdigioia.s5l5Bend.entities.Postazione;
import alexdigioia.s5l5Bend.entities.Prenotazione;
import alexdigioia.s5l5Bend.entities.Utente;
import alexdigioia.s5l5Bend.services.DataBaseCreazioneDefault;
import alexdigioia.s5l5Bend.services.PostazioneService;
import alexdigioia.s5l5Bend.services.PrenotazioneService;
import alexdigioia.s5l5Bend.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@Component
public class GestionePrenotazioni implements CommandLineRunner {

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private PrenotazioneService prenotazioneService;

    @Autowired
    private PostazioneService postazioneService;

    @Autowired
    private DataBaseCreazioneDefault dataBaseCreazioneDefault;

    @Override
    public void run(String... args) throws Exception {

        dataBaseCreazioneDefault.startDatabase();

        Utente utente1 = new Utente("luke", "Luke Skywalker", "luke@jedi.com");
        Utente utente2 = new Utente("Aldo", "Aldo Ciccipuzzi", "aldo@puzzi.com");
        utenteService.saveUtente(utente1);
        utenteService.saveUtente(utente2);

        //li inizializzo se no nel constructor delle prenotazioni da errore
        Postazione postazioneJPark = null;
        Postazione cabinaPilotaggio = null;
        Optional<Postazione> postazioneOptional1 = postazioneService.findByDescrizione("Pappa del dinosauro");
        if (postazioneOptional1.isPresent()) {
            postazioneJPark = postazioneOptional1.get();
            System.out.println("Postazione trovata: " + postazioneJPark);
        } else {
            System.out.println("Nessuna postazione trovata con quella descrizione.");
        }

        Optional<Postazione> postazioneOptional2 = postazioneService.findByDescrizione("Cabina di pilotaggio");
        if (postazioneOptional2.isPresent()) {
            cabinaPilotaggio = postazioneOptional2.get();
            System.out.println("Postazione trovata: " + cabinaPilotaggio);
        } else {
            System.out.println("Nessuna postazione trovata con quella descrizione.");
        }

        Prenotazione prenotazione1 = new Prenotazione(utente1, cabinaPilotaggio, LocalDate.now().plusDays(1)); //plusDays=> giorni aggiunti alla data
        Prenotazione prenotazione2 = new Prenotazione(utente2, postazioneJPark, LocalDate.now().plusDays(2));
        prenotazioneService.savePrenotazione(prenotazione1);
        prenotazioneService.savePrenotazione(prenotazione2);

        
        System.out.println("Utenti salvati:");
        utenteService.findAll().forEach(System.out::println);
        System.out.println("Prenotazioni salvate:");
        prenotazioneService.findAll().forEach(System.out::println);
    }
}