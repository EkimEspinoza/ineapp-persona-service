package pe.ineapp.ineapppersonaservice.infraestructura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.ineapp.ineapppersonaservice.dominio.entity.Movie;


public interface MovieRepository  extends JpaRepository<Movie,Long> {
    public Movie findByTitle(String title);
}
