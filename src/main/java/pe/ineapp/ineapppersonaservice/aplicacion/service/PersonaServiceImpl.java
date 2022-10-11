package pe.ineapp.ineapppersonaservice.aplicacion.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.ineapp.ineapppersonaservice.dominio.entity.Persona;
import pe.ineapp.ineapppersonaservice.infraestructura.repository.PersonaRepository;
import pe.ineapp.ineapppersonaservice.infraestructura.request.UserRequest;
import pe.ineapp.ineapppersonaservice.infraestructura.response.BasicResponse;
import pe.ineapp.ineapppersonaservice.infraestructura.response.UserResponse;

import javax.transaction.Transactional;
import java.util.List;


@Log4j2
@Service
public class PersonaServiceImpl implements PersonaService{

    private static final String Password ="123456";
    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public BasicResponse addUser(UserRequest request){
       try {
            if(request.getPassword().equals(Password))
            {
                personaRepository.save(this.builPersonaFromRequest(request));
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
    @Override
    public UserResponse getAll(){

        List<Persona> personaList = personaRepository.findAll();


        if(personaList.isEmpty()){
        return UserResponse.builder()
                .personaList(null)
                .basicResponse(BasicResponse.whenNoDataFound("User"))
                .build();
        }

        return UserResponse.builder()
                .personaList(personaList)
                .basicResponse(BasicResponse.whenSuccess())
                .build();
    }

    @Override
    public UserResponse getByDni(String dni){
        try {
            Persona  persona = personaRepository.findByDni(dni);

            if(persona != null){
                return  UserResponse.builder()
                        .personaList(List.of(persona))
                        .basicResponse(BasicResponse.whenSuccess())
                        .build();
            }
            else{
                return UserResponse.builder()
                        .personaList(null)
                        .basicResponse(BasicResponse.whenNoDataFound("User"))
                        .build();
            }
        }
        catch (Exception ex){
            return UserResponse.builder()
                    .personaList(null)
                    .basicResponse(BasicResponse.whenError(ex.getMessage()))
                    .build();
        }
    }

    public Persona builPersonaFromRequest(UserRequest request){
        return Persona.builder()
                .name(request.getName())
                .lastname(request.getLastName())
                .dni(request.getDni())
                .email(request.getEmail())
                .birthDate(request.getBirthDate()).build();
    }

    @Transactional
    @Override
    public BasicResponse updateUser(UserRequest request , String dni){
    try {
        //Validar que exista
        Persona persona =  personaRepository.findByDni(dni);
        if(persona != null ){
            return BasicResponse.whenNoDataFound("User" + dni);
        } else{
            // validar que la clave sea correcta
            if(request.getPassword().equals(Password)){
                persona.setName(request.getName()!= null &&  !request.getName().isBlank() ? request.getName() : persona.getName());
                persona.setLastname(request.getLastName()!= null &&  !request.getLastName().isBlank() ? request.getLastName() : persona.getLastname());
                persona.setEmail(request.getEmail()!= null &&  !request.getEmail().isBlank() ? request.getEmail() : persona.getEmail());
                persona.setDni(request.getDni()!= null &&  !request.getDni().isBlank() ? request.getDni() : persona.getDni());
                persona.setBirthDate(request.getBirthDate()!= null  ? request.getBirthDate() : persona.getBirthDate());

                return BasicResponse.whenSuccess();
            }
            else{
                return BasicResponse.whenPassNotMatch();
            }
        }
    }
    catch (Exception ex){
        return BasicResponse.whenError(ex.getMessage());
        }
    }

    public BasicResponse deleteUser(String dni){
    try {
        Persona persona = personaRepository.findByDni(dni);
        if(persona == null){
            return BasicResponse.whenNoDataFound("User con dni " + dni);
        }else{
            personaRepository.delete(persona);
            return BasicResponse.whenSuccess();
        }
    }
    catch (Exception ex){
        return BasicResponse.whenError(ex.getMessage());
    }

    }
}


