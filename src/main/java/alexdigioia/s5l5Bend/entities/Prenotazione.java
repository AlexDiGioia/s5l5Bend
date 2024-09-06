package alexdigioia.s5l5Bend.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.util.UUID;

public class Prenotazione {

    @Id
    @GeneratedValue
    private UUID idPrenotazione;

    @ManyToOne
    private Utente utente;

    @ManyToOne
    private Postazione postazione;

    private LocalDate dataPrenotazione;
}