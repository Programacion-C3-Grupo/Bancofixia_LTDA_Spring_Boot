package com.ProgramacionC3.ProyectoCiclo3.repository;

import com.ProgramacionC3.ProyectoCiclo3.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TransactionRepository extends JpaRepository <Transaction, Long> {
}
