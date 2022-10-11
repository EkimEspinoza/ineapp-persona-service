package pe.ineapp.ineapppersonaservice.aplicacion.service;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.ineapp.ineapppersonaservice.dominio.entity.Movie;
import pe.ineapp.ineapppersonaservice.infraestructura.repository.MovieRepository;
import pe.ineapp.ineapppersonaservice.infraestructura.request.MovieRequest;
import pe.ineapp.ineapppersonaservice.infraestructura.response.BasicResponse;

@Log4j2
@Service
public class MovieServicioImpl implements MovieService{

    private static final String Password ="123456";
    @Autowired
    private MovieRepository movieRepository;
    @Override
    public BasicResponse addMovie(MovieRequest request){
        try {
            if(request.getPassword().equals(Password))
            {
                movieRepository.save(this.builMovieFromRequest(request));
                return BasicResponse.whenSuccess() ;
            }
            else{
                return BasicResponse.whenPassNotMatch() ;
            }
        }
        catch (Exception ex){
            log.error(ex.getMessage());
            return BasicResponse.whenError(ex.getMessage()) ;

        }
    }
    public Movie builMovieFromRequest(MovieRequest request){
        return Movie.builder()
                .title(request.getTitle())
                .year(request.getYear())
                .genre(request.getGenre())
                .director(request.getDirector())
                .rating(request.getRating()).build();
    }
}
