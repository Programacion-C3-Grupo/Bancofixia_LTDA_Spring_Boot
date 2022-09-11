package com.ProgramacionC3.ProyectoCiclo3.controller;

import com.ProgramacionC3.ProyectoCiclo3.entities.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriceService;

    @GetMapping
    public List<Enterprise> listar(){
        return enterpriceService.listar();
    }

    @PostMapping
    public Enterprise insertar(@RequestBody Enterprise ent){
        return enterpriceService.insertar(ent);
    }

    @PutMapping
    public Enterprise actualizar(@PutMapping Enterprise ent){
        return enterpriceService.actualizar(ent);
    }

    @DeleteMapping
    public void eliminar (@RequestBody Enterprise ent){
        enterpriceService.eliminar(ent);
    }

}
