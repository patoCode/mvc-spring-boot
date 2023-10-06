package com.F5.crud.service;

import com.F5.crud.entities.Persona;

import java.util.List;

public interface IPersona {


    public void save(Persona p);
    public void delete(Persona p);
    public Persona get(Persona p);
    public List<Persona> all();
}
