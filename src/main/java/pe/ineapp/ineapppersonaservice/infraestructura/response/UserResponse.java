package pe.ineapp.ineapppersonaservice.infraestructura.response;

import lombok.Builder;
import lombok.Data;
import pe.ineapp.ineapppersonaservice.dominio.entity.Persona;

import java.util.List;


@Builder
@Data

public class UserResponse {
    private List<Persona> personaList;
    private BasicResponse basicResponse;


}
