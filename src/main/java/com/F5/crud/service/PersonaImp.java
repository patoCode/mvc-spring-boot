package com.F5.crud.service;

import com.F5.crud.entities.Persona;
import com.F5.crud.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonaImp implements IPersona{

    @Autowired
    private PersonaRepository repo;

    @Override
    @Transactional(readOnly = true)
    public List<Persona> all() {
        return (List<Persona>) repo.findAll();
    }

    @Override
    @Transactional
    public void save(Persona p) {
        repo.save(p);
    }

    @Override
    @Transactional
    public void delete(Persona p) {
        repo.delete(p);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona get(Persona p) {
        return repo.findById(p.getId()).orElse(null);
    }


}
