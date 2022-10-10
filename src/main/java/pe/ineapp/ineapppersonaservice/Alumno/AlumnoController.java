package pe.ineapp.ineapppersonaservice.Alumno;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/alumno")
public class  AlumnoController {

    @GetMapping
    @RequestMapping("/getAll")

    public List<Alumno> getAlumno(){

        Alumno alumno = Alumno.builder()
                .id(1l)
                .nombre("Christian")
                .apellido("Espinoza")
                .dni("45966557")
                .curso("Programación I").build();
        Alumno alumno1 =Alumno.builder()
                .id(2l)
                .nombre("Mathias")
                .apellido("Bardales")
                .dni("89675623")
                .curso("Base de Datos I").build();

        return List.of(alumno,alumno1);
    }
}