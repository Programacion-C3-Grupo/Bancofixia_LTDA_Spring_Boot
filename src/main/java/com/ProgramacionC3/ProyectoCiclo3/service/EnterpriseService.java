package com.ProgramacionC3.ProyectoCiclo3.service;

import com.ProgramacionC3.ProyectoCiclo3.entities.Employee;
import com.ProgramacionC3.ProyectoCiclo3.entities.Enterprise;
import com.ProgramacionC3.ProyectoCiclo3.repository.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EnterpriseService {
    @Autowired
    private EnterpriseRepository enterpriseRepository;

    public List<Enterprise> listar(){
        return enterpriseRepository.findAll();
    }

    public Enterprise obtenerPorId(Long id) {
        return enterpriseRepository.getById(id);
    }

    public Enterprise insertar(Enterprise enterprise){
        return enterpriseRepository.save(enterprise);
    }

    public Enterprise actualizar(Enterprise enterprise){
        return enterpriseRepository.save(enterprise);
    }

    public void eliminar(Enterprise enterprise){
        enterpriseRepository.delete(enterprise);
    }

}
