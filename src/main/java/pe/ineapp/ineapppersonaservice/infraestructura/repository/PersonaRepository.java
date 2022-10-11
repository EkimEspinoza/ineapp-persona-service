package pe.ineapp.ineapppersonaservice.infraestructura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.ineapp.ineapppersonaservice.dominio.entity.Persona;

public interface PersonaRepository extends JpaRepository<Persona,Long> {

    public Persona findByDni(String dni);

}
