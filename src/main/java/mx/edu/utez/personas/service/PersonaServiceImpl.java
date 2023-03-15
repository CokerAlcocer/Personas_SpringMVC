package mx.edu.utez.personas.service;

import mx.edu.utez.personas.P2E4Application;
import mx.edu.utez.personas.model.Persona;
import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;
@Service
public class PersonaServiceImpl implements PersonaService{
    private static final Logger logger = LogManager.getLogger(PersonaServiceImpl.class);
    private List<Persona> listaPersonas = new LinkedList<>();
    private List<Persona> listaPersonasID = new LinkedList<>();

    @Override
    public List<Persona> consultarPersonas(){
        logger.info("Consultando Personas");
        return listaPersonas;

    }

    @Override
    public Persona consultarPersonasPorId(long id){
        Persona persona = null;
        for (int i = 0; i < listaPersonas.size();i++){
            Persona persona1 = listaPersonas.get(i);
            if(persona1.getId() == id){
                persona = persona1;
                logger.info("Consultando Persona Especifica");
                break;
            }
        }
        return persona;
    }
    @Override
    public boolean registrarPersona(Persona persona){
        boolean flag = false;
        if (persona.getNombre() == null ||
                persona.getPaterno() == null ||
                persona.getMaterno() == null ||
                persona.getEdad() == 0 ){

            flag = false;
        }else{
            int size = listaPersonas.size();
            System.out.println(size);
            persona.setId(size);
            listaPersonas.add(persona);
            flag = true;
            logger.debug("Registrando persona");
        }
        return flag;
    }
    @Override
    public boolean modificarPersona(Persona persona){
        boolean flag = false;
        Persona persona1 = null;
        for (int i = 0; i < listaPersonas.size(); i++){
            persona1 = listaPersonas.get(i);
            if (persona1.getId() == persona.getId()){
                listaPersonas.set(i, persona);
                flag = true;
                logger.warn("Actualizando persona");
                break;
            }
        }
        return flag;
    }
    @Override
    public boolean eliminarPersona(long id) {
        boolean flag = false;
        for (int i = 0; i < listaPersonas.size(); i++){
            Persona persona = listaPersonas.get(i);
            if (persona.getId() == id){
                listaPersonas.remove(i);
                flag = true;
                logger.warn("Eliminando persona");
                break;
            }
        }
        return flag;
    }
}
