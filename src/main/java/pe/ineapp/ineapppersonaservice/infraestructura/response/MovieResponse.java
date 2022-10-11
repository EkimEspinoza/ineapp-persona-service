package pe.ineapp.ineapppersonaservice.infraestructura.response;

import lombok.Builder;
import lombok.Data;
import pe.ineapp.ineapppersonaservice.dominio.entity.Movie;

import java.util.List;

@Builder
@Data
public class MovieResponse {
    private List<Movie> movieList;
    private BasicResponse basicResponse;
}
