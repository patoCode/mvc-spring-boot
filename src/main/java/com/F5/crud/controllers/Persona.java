package com.F5.crud.controllers;

import com.F5.crud.service.IPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class Persona {

    @Autowired
    private IPersona personaService;

    @GetMapping("/")
    public String listar(Model model){
        model.addAttribute("personas", personaService.all());
        return "index";
    }

    @GetMapping("/create")
    public String create(com.F5.crud.entities.Persona persona){
        return "modify";
    }

    @PostMapping("/save")
    public String save(@Valid com.F5.crud.entities.Persona persona, Errors errores){
        if(errores.hasErrors()){
            return "modify";
        }

        personaService.save(persona);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(com.F5.crud.entities.Persona persona, Model model){
        persona = personaService.get(persona);
        model.addAttribute("persona", persona);
        return "modify";
    }

    @GetMapping("/delete")
    public String delete(com.F5.crud.entities.Persona persona){
        personaService.delete(persona);
        return "redirect:/";
    }

}
