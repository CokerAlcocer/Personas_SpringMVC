package mx.edu.utez.personas.service;
import mx.edu.utez.personas.model.Persona;

import java.util.List;

public interface PersonaService {

    boolean registrarPersona(Persona personas);
    List<Persona> consultarPersonas();
    Persona consultarPersonasPorId(long id);

    boolean modificarPersona(Persona persona);
    boolean eliminarPersona(long id);

}
