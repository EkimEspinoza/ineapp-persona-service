package pe.ineapp.ineapppersonaservice.infraestructura.controller;


import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.ineapp.ineapppersonaservice.dominio.entity.Persona;
import pe.ineapp.ineapppersonaservice.aplicacion.service.PersonaService;
import pe.ineapp.ineapppersonaservice.infraestructura.repository.PersonaRepository;
import pe.ineapp.ineapppersonaservice.infraestructura.request.UserRequest;
import pe.ineapp.ineapppersonaservice.infraestructura.response.BasicResponse;
import pe.ineapp.ineapppersonaservice.infraestructura.response.UserResponse;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;



    @GetMapping
    @RequestMapping("/getall")
    public UserResponse getAll(){
        return personaService.getAll();
    }

    @GetMapping
    @RequestMapping("/getbydni")
    public UserResponse getByDni(@RequestParam String dni){
        return personaService.getByDni(dni) ;
    }

    @PostMapping
    @RequestMapping("/addUser")
    public ResponseEntity<BasicResponse> adduser(@RequestBody UserRequest request){
        BasicResponse response = personaService.addUser(request);
        return ResponseEntity.status(response.getCode()).body(response);

    }


    @PutMapping
    @RequestMapping("/updateuser")
    public ResponseEntity<BasicResponse> updateUser(@RequestBody UserRequest request,
                                                        @RequestParam String dni){
        BasicResponse response = personaService.updateUser(request,dni);
        return ResponseEntity.status(response.getCode()).body(response);
    }

    @DeleteMapping
    @RequestMapping("/deleteuser")
    public ResponseEntity<BasicResponse> deleteUser(@RequestParam String dni){
        BasicResponse response = personaService.deleteUser(dni);
        return ResponseEntity.status(response.getCode()).body(response);
    }
}
