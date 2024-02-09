package com.example.demo.Persistence.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Entities.Maker;
import com.example.demo.Persistence.IMakerDAO;
import com.example.demo.Repository.MakerRepository;


@Component
public class MakerDAOimpl implements IMakerDAO{

    //Inyeccion de dependencias
    @Autowired
    private MakerRepository makerRepository;

    @Override
    public List<Maker> findAll() {
        return (List<Maker>) makerRepository.findAll();    
    }

    @Override
    public Optional<Maker> findById(Long id) {
        return makerRepository.findById(id);
    }

    @Override
    public void save(Maker maker) {
        makerRepository.save(maker);
    }

    @Override
    public void deleteById(Long id) {
        makerRepository.deleteById(id);
    }


    
}
