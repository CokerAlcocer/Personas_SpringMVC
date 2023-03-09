package mx.edu.utez.personas.controller;


import mx.edu.utez.personas.model.Persona;
import mx.edu.utez.personas.service.PersonaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/personas")
public class ControllerPersona {

    @Autowired
    private PersonaServiceImpl pservicei;
    public List<Persona> listaPersonas = new ArrayList<>();
    @GetMapping("/listar")
    public String consultarPersonas(Model model){
        listaPersonas = pservicei.consultarPersonas();
        model.addAttribute("listaPersona",listaPersonas);
        return "index";
    }

    @GetMapping("/listar/{id}")
    public String consultarPersonasPorId(@PathVariable("id") int idPersona, Model model){
        Persona uniquePer = pservicei.consultarPersonasPorId(idPersona);
        model.addAttribute("persona",uniquePer);
        return "index";
    }


    @PostMapping("/registrar")
    public String registrarPersona(@ModelAttribute("persona") Persona nPersona,Model model){
        if(pservicei.registrarPersona(nPersona)){
            listaPersonas = pservicei.consultarPersonas();
        }
        model.addAttribute("listaPersonas",listaPersonas);
        return "index";
    }
    @PutMapping("/modificar/{id}")
    public String modificarPersona(@ModelAttribute("persona") Persona uppersona, Model model){
     if (pservicei.modificarPersona(uppersona)){
         listaPersonas = pservicei.consultarPersonas();   
     }
     model.addAttribute("listaPersonas",listaPersonas);
     return "index";
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarPersona(@ModelAttribute("persona") Persona dPersona, Model model){
        if(pservicei.eliminarPersona(dPersona.getId())){
            listaPersonas = pservicei.consultarPersonas();
        }
        model.addAttribute("listaPersona",listaPersonas);
        return "index";
    }

}
