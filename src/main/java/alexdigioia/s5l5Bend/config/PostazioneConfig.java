package alexdigioia.s5l5Bend.config;

import alexdigioia.s5l5Bend.entities.Edificio;
import alexdigioia.s5l5Bend.entities.Postazione;
import alexdigioia.s5l5Bend.entities.TipoPostazione;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostazioneConfig {

    @Bean
    public Postazione postazionePrivata(@Qualifier("recintoTRex") Edificio edificio) {
        return new Postazione("Pappa del dinosauro", TipoPostazione.OPENSPACE, 1, edificio);
    }

    @Bean
    public Postazione cabinaPilotaggio(@Qualifier("millenniumFalcon") Edificio edificio) {
        return new Postazione("Cabina di pilotaggio", TipoPostazione.PRIVATO, 3, edificio);
    }
}
