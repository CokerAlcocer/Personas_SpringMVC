package mx.edu.utez.personas.service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface PersonaService {

    boolean registerPersonas(Personas  personas);

    List<Personas> listPersonas();


}
