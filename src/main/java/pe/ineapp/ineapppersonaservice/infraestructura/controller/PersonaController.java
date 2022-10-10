package pe.ineapp.ineapppersonaservice.Persona;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @GetMapping
    @RequestMapping("/getAll")
    public List<Persona> getPersona(){

        LocalDate date = LocalDate.of(2020, Month.APRIL,4);
        Persona persona = Persona.builder()
                .id(1L)
                .name("Christian")
                .lastname("Espinoza")
                .dni("45966557")
                .email("cespinoza@central.com.pe")
                .birthDate(date).build();
        Persona persona1 = Persona.builder()
                .id(2L)
                .name("Mathias")
                .lastname("Espinoza")
                .dni("89349483")
                .email("mespinoza@central.com.pe")
                .birthDate(date).build();

        return List.of(persona,persona1);
    }



}
