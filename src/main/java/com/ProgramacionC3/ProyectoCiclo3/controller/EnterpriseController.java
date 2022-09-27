package com.ProgramacionC3.ProyectoCiclo3.controller;

import com.ProgramacionC3.ProyectoCiclo3.entities.Enterprise;
import com.ProgramacionC3.ProyectoCiclo3.entities.UserResponse;
import com.ProgramacionC3.ProyectoCiclo3.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Empresas")
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    @GetMapping
    public List<Enterprise> listar(){
        return enterpriseService.listar();
    }

    @PostMapping
    public ResponseEntity<UserResponse> insertar(@RequestBody Enterprise ent) {
        try {
            Date date = new Date();
            ent.setCreatedAt(date);
            ent.setUpdatedAt(date);
            return new ResponseEntity<>(
                    new UserResponse("Empresa creada con éxito", enterpriseService.insertar(ent)),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new UserResponse(e.getMessage(), null),
                    HttpStatus.OK
            );
        }
    }

    @PutMapping
    public ResponseEntity<UserResponse> actualizar(@RequestBody Enterprise ent){
        try {
            Enterprise enterprise = enterpriseService.obtenerPorId(ent.getEnterprise_id());
            ent.setCreatedAt(enterprise.getCreatedAt());
            Date date = new Date();
            ent.setUpdatedAt(date);
            return new ResponseEntity<>(
                    new UserResponse("Empresa actualizada con éxito", enterpriseService.actualizar(ent)),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new UserResponse(e.getMessage(), null),
                    HttpStatus.OK
            );
        }
    }

    @DeleteMapping
    public ResponseEntity<UserResponse> eliminar (@RequestBody Enterprise ent){
        try {
            return new ResponseEntity<>(
                    new UserResponse(enterpriseService.eliminar(ent), null),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new UserResponse(e.getMessage(), null),
                    HttpStatus.OK
            );
        }
    }

}
