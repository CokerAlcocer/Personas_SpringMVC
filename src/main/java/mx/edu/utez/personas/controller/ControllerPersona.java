package mx.edu.utez.personas.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;

@Controller
@RequestMapping("/personas")
public class ControllerPersona {

    @Autowired
    private PersonaServiceImpl pservicei;
    public List<BeanPersona> listaPersonas = new ArrayList<>();
    @GetMapping("/listar")
    public String consultarPersonas(Model model){
        listaPersonas = pservicei.consultarPersonas();
        model.addAttribute("listaPersona",listaPersonas);
        return "crud";
    }

    @GetMapping("/listar/{id}")
    public String consultarPersonasPorId(@PathVariable("id") int idPersona, Model model){
        BeanPersona uniquePer = pservicei.consultarPersonasPorId(idPersona);
        model.addAttribute("persona",uniquePer);
        return "crud";
    }


    @PostMapping("/registrar")
    public String registrarPersona(@ModelAttribute("persona") BeanPersona nPersona,Model model){
        listaPersonas = pservicei.registrarPersona(nPersona);
        model.addAttribute("listaPersonas",listaPersonas);
        return "criud";
    }
    @PutMapping("/modificar/{id}")
    public String modificarPersona(@ModelAttribute("persona") BeanPersona uppersona, Model model){
     listaPersonas = pservicei.modificarPersona(uppersona);
     model.addAttribute("listaPersonas",listaPersonas);
     return "crud";
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarPersona(@ModelAttribute("persona") BeanPersona dPersona, Model model){
        listaPersonas = pservicei.eliminarPersona(dPersoa);
        model.addAttribute("listaPersona",listaPersonas);
        return "crud";
    }

}
