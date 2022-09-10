package com.ProgramacionC3.ProyectoCiclo3.controller;

import com.ProgramacionC3.ProyectoCiclo3.entities.Transaction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class TransactionController {

    @GetMapping("/transaction")

    public ResponseEntity <List <Transaction>> getTransaction(){

        return null;
    }

    @GetMapping("/transaction/{id}")

    public ResponseEntity<Transaction> getTransaction(@PathVariable Long id){
        return null;
    }
                                                                                     // preguntar duda no me deja recibir la misma variable
    @GetMapping("/transaction")
    public ResponseEntity<Transaction> getTransaction(@RequestParam String id){
        return null;
    }

}
