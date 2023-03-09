package mx.edu.utez.personas.service;

import mx.edu.utez.personas.model.Persona;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
@Service
public class PersonaServiceImpl implements PersonaService{

    private List<Persona> listaPersonas = new LinkedList<>();
    private List<Persona> listaPersonasID = new LinkedList<>();

    @Override
    public List<Persona> consultarPersonas(){
        return listaPersonas;
    }

    @Override
    public Persona consultarPersonasPorId(long id){
        Persona persona = null;
        for (int i = 0; i < listaPersonas.size();i++){
            Persona persona1 = listaPersonas.get(0);
            if(persona1.getId() == id){
                persona = persona1;
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
            listaPersonas.add(persona);
            flag = true;
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
                break;
            }
        }
        return flag;
    }
}
