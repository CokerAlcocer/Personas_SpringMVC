package mx.edu.utez.personas.service;

import org.springframework.beans.factory.annotation.Override;

import java.util.LinkedList;
import java.util.List;

public class PersonaServiceImpl implements PersonaService{

    private List<Persona> listaPersonas = new LinkedList<>();
    private List<Persona> listaPersonasID = new LinkedList<>();

    @Override
    public List<Persona> consultarPersonas(){
        llenarLista();
        return listaPersonas;
    }
    public void llenarLista(){
        listaPersonas.add(new Persona("","","",true,true));
    }

    @Override
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
    @Override
    public Boolean registrarPersona(Persona persona){
        boolean flag = false;
        if (persona.getNombre() == null ||
                persona.getPaterno == null ||
                persona.getMaterno == null ||
                persona.getEdad() == null ){

            flag = false;
        }else{
            listaPersonas.add(persona);
            flag = true;
        }
        return flag;
    }
    @Override
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
    @Override
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
