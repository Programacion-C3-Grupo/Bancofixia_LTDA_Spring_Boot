package com.ProgramacionC3.ProyectoCiclo3.controller;

import com.ProgramacionC3.ProyectoCiclo3.entities.Enterprise;
import com.ProgramacionC3.ProyectoCiclo3.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    @GetMapping("/empresa")
    public List<Enterprise> listar(){
        return enterpriseService.listar();
    }

    @PostMapping("/empresa")
    public void insertar(@RequestBody Enterprise ent){ enterpriseService.insertar(ent);
    }

    @PutMapping("/empresa")
    public void actualizar(@RequestBody Enterprise ent){
        enterpriseService.actualizar(ent);
    }

    @DeleteMapping("/empresa")
    public void eliminar (@RequestBody Enterprise ent){
        enterpriseService.eliminar(ent);
    }

}
