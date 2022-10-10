package pe.ineapp.ineapppersonaservice.Alumno;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Alumno {
    Long id;
    String nombre;
    String apellido;
    String dni;
    String curso;

}
