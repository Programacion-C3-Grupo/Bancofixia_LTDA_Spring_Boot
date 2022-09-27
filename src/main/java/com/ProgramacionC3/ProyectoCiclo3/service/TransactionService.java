package com.ProgramacionC3.ProyectoCiclo3.service;


import com.ProgramacionC3.ProyectoCiclo3.entities.Employee;
import com.ProgramacionC3.ProyectoCiclo3.entities.Enterprise;
import com.ProgramacionC3.ProyectoCiclo3.entities.Transaction;
import com.ProgramacionC3.ProyectoCiclo3.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> listar(){ return transactionRepository.findAll();}

    public Transaction obtenerPorId(Long id) {
        return transactionRepository.getById(id);
    }

    public Transaction insertar (Transaction transaction) { return transactionRepository.save(transaction);}

    public Transaction actualizar (Transaction transaction){ return transactionRepository.save(transaction);}

    public String eliminar (Transaction transaction){
        transactionRepository.delete(transaction);
        return "Movimiento eliminado exitosamente";
    }

}
