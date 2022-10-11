package pe.ineapp.ineapppersonaservice.aplicacion.service;

import antlr.StringUtils;
import org.apache.catalina.User;
import pe.ineapp.ineapppersonaservice.dominio.entity.Persona;
import pe.ineapp.ineapppersonaservice.infraestructura.request.UserRequest;
import pe.ineapp.ineapppersonaservice.infraestructura.response.BasicResponse;
import pe.ineapp.ineapppersonaservice.infraestructura.response.UserResponse;

import java.util.List;

public interface PersonaService {
   public BasicResponse addUser(UserRequest request);

   public UserResponse  getAll();

   public UserResponse getByDni(String dni);

   public BasicResponse updateUser(UserRequest request, String dni);

   public BasicResponse deleteUser(String dni);
}
