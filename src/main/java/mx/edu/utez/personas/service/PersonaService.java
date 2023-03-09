package mx.edu.utez.personas.service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface PersonaService {

    boolean registrarPersona(Persona  personas);
    List<Persona> consultarPersonas();
    BeanPersona consultarPersonasPorId();
    
    List<Persona> modificarPersona();
    List<Persona> eliminarPersona();

}
