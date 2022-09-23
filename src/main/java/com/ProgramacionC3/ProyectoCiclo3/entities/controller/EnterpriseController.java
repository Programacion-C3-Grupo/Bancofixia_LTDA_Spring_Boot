package com.ProgramacionC3.ProyectoCiclo3.entities.controller;

import com.ProgramacionC3.ProyectoCiclo3.entities.Enterprise;
import com.ProgramacionC3.ProyectoCiclo3.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    @GetMapping
    public List<Enterprise> listar(){
        return enterpriseService.listar();
    }

    @PostMapping
    public Enterprise insertar(@RequestBody Enterprise ent){
        return enterpriseService.insertar(ent);
    }

    @PutMapping
    public Enterprise actualizar(@RequestBody Enterprise ent){
        return enterpriseService.actualizar(ent);
    }

    @DeleteMapping
    public void eliminar (@RequestBody Enterprise ent){
        enterpriseService.eliminar(ent);
    }

}
