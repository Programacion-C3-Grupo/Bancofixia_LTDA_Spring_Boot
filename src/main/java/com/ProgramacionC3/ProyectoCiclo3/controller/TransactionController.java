package com.ProgramacionC3.ProyectoCiclo3.controller;

import com.ProgramacionC3.ProyectoCiclo3.entities.Enterprise;
import com.ProgramacionC3.ProyectoCiclo3.entities.Transaction;
import com.ProgramacionC3.ProyectoCiclo3.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacciones")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping

    public List<Transaction> listar(){ return transactionService.listar();}

    @PostMapping
    public Transaction insertar(@RequestBody Transaction trans){ return transactionService.insertar(trans);}

    @PutMapping
    public Transaction actualizar(@RequestBody Transaction trans){ return transactionService.actualizar(trans);
    }

    @DeleteMapping
    public void eliminar (@RequestBody Transaction trans){
        transactionService.eliminar(trans);
    }

}


