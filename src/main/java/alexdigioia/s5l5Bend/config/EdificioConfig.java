package alexdigioia.s5l5Bend.config;

import alexdigioia.s5l5Bend.entities.Edificio;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EdificioConfig {

    @Bean
    public Edificio recintoTRex() {
        return new Edificio("Recinzione del T-Rex", "Isola dei dinosauri", "Jurassic Park");
    }

    @Bean
    public Edificio millenniumFalcon() {
        return new Edificio("Millennium Falcon", "Galassia lontana lontana", "Pordenone");
    }
}
