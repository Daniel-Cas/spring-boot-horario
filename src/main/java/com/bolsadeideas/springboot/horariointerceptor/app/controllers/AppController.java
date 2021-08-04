package com.bolsadeideas.springboot.horariointerceptor.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @Value("${config.horario.apertura}")
    private Integer apertura;

    @Value("${config.horario.cierre}")
    private Integer cierre;


    @GetMapping({"/","/index"})
    public String index(Model model){

        model.addAttribute("titulo", "Bienvenido a la lista de horarios");

        return "index";
    }

    @GetMapping("/cerrado")
    public String cerrado(Model model){

        StringBuilder mensaje = new StringBuilder("Cerrado, porfavor visitenos desde las ");
        mensaje.append(apertura);
        mensaje.append(" y las ");
        mensaje.append(cierre);
        mensaje.append(" horas. Gracias. ");

        model.addAttribute("titulo", "Fuera del horario de atención");
        model.addAttribute("mensaje", mensaje.toString());

        return "cerrado";
    }

}
