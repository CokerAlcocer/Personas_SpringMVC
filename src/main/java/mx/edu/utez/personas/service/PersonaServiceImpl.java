package mx.edu.utez.personas.service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;

public class PersonaServiceImpl implements PersonaService{

    private List<Persona> listaPersonas = new LinkedList<>();
    private List<Persona> listaPersonasID = new LinkedList<>();

    @Autowired
    public List<Persona> consultarPersonas(){
        return listaPersonas;
    }

    @Autowired
    public Persona consultarPersonaPorId(int id){
        Persona persona = null;
        for (int i = 0; i < listaPersonas.size();i++){
            Persona persona1 = listaPersonas.get(0);
            if(persona1.getIdPersona() == id){
                persona = persona1;
                break;
            }
        }
        return persona;
    }
    public Boolean registrarPersona(Persona persona){
        Boolean flag;
        if (persona.getNombre() == null ||
                persona.getApellidoP == null ||
                persona.getApellidoM == null ||
                persona.getEdad() == null ||
                persona.getsexo() == null ||
                persona.getEstadoCivil() == null
        ){
            flag = false;
        }else{
            listaPersonas.add(persona);
            flag = true;
        }
        return flag;
    }

    public Boolean modificarPersona(Persona persona){
        boolean flag = false;
        Persona person1 = null;
        for (int i = 0; i < listaPersonas.size(); i++){
            persona1 = listaPersonas.get(i);
            if (person1.getIdPersona == persona.getIdPersona()){
                listaPersonas.set(i, persona);
                flag = true;
                break;
            }
        }
        return flag;
    }

    public Boolean eliminarPersona(int id) {
        boolean flag = false;
        for (int i = 0; i < listaPersonas.size(); i++){
            Persona persona = listaPersonas.get(i);
            if (persona.idPersona == id){
                listaPersonas.remove(i);
                flag = true;
                break;
            }
        }
        return flag;
    }
}
