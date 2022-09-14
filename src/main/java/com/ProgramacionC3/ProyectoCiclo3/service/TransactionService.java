package com.ProgramacionC3.ProyectoCiclo3.service;


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

    public void insertar (Transaction transaction) { transactionRepository.save(transaction);}

    public void actualizar (Transaction transaction){transactionRepository.save(transaction);}

    public void eliminar (Transaction transaction){transactionRepository.delete(transaction);}



}