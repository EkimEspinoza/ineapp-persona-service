package pe.ineapp.ineapppersonaservice.aplicacion.service;

import pe.ineapp.ineapppersonaservice.infraestructura.request.MovieRequest;
import pe.ineapp.ineapppersonaservice.infraestructura.request.UserRequest;
import pe.ineapp.ineapppersonaservice.infraestructura.response.BasicResponse;

public interface MovieService {

    public BasicResponse addMovie(MovieRequest request);


}
