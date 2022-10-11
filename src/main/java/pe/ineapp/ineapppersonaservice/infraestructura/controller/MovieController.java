package pe.ineapp.ineapppersonaservice.infraestructura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.ineapp.ineapppersonaservice.aplicacion.service.MovieService;
import pe.ineapp.ineapppersonaservice.infraestructura.request.MovieRequest;
import pe.ineapp.ineapppersonaservice.infraestructura.response.BasicResponse;


@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;


    @PostMapping
    @RequestMapping("/addmovie")
    public ResponseEntity<BasicResponse> addmovie(@RequestBody MovieRequest request){
        BasicResponse response = movieService.addMovie(request);
        return ResponseEntity.status(response.getCode()).body(response);
    }
}
