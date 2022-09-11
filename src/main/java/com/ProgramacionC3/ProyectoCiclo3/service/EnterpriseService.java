package com.ProgramacionC3.ProyectoCiclo3.service;

import com.ProgramacionC3.ProyectoCiclo3.entities.Enterprise;
import com.ProgramacionC3.ProyectoCiclo3.repository.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EnterpriseService {
    @Autowired
    private EnterpriseRepository enterpriseRepository;

    public void insertar(Enterprise enterprise){
        enterpriseRepository.save(enterprise);
    }

}
