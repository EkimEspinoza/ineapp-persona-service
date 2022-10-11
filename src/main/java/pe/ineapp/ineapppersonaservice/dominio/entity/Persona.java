package pe.ineapp.ineapppersonaservice.dominio.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

//1@AllArgsConstructor //Es como si tuvieramos creado el constructor
//2@NoArgsConstructor //Permite tener el constructor sin argumentos
//3@Setter //ya no es necesario crear los setter
//4@Getter //ya no es necesario crear los getter
//@Data // se puede simplificar (1-2-3-4)

@Entity
@Table(
       name ="tbl_Persona",
       uniqueConstraints = {
               @UniqueConstraint(name="persona_email_unique",columnNames = "email"),
               @UniqueConstraint(name="persona_dni_unique",columnNames = "dni"),
       }
)


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class Persona {
    @SequenceGenerator(
            name="persona_sequence",
            sequenceName = "persona_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "persona_sequence"
    )
    @Id
    Long id;
    String name;
    String lastname;
    String dni;
    String email;
    LocalDate birthDate;


}
