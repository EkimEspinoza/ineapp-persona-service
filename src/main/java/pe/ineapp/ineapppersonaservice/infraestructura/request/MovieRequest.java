package pe.ineapp.ineapppersonaservice.infraestructura.request;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Id;

@Builder
@Data
public class MovieRequest {

    private Long id;
    private String title;
    private int year;
    private String genre;
    private String director;
    private int rating;
    private String password ;
}
