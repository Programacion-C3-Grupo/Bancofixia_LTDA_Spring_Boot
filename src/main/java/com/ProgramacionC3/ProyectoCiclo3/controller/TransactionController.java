package com.ProgramacionC3.ProyectoCiclo3.controller;

import com.ProgramacionC3.ProyectoCiclo3.entities.Employee;
import com.ProgramacionC3.ProyectoCiclo3.entities.Enterprise;
import com.ProgramacionC3.ProyectoCiclo3.entities.Transaction;
import com.ProgramacionC3.ProyectoCiclo3.service.EnterpriseService;
import com.ProgramacionC3.ProyectoCiclo3.service.TransactionService;
import com.ProgramacionC3.ProyectoCiclo3.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/transacciones")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private EnterpriseService enterpriseService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping

    public List<Transaction> listar(){ return transactionService.listar();}

    @PostMapping
    public Transaction insertar(@RequestBody Transaction trans){
        Date date = new Date();
        trans.setCreatedAt(date);
        trans.setUpdatedAt(date);
        return transactionService.insertar(trans);
    }

    @PutMapping
    public Transaction actualizar(@RequestBody Transaction trans){
        Transaction transaction = transactionService.obtenerPorId(trans.getTransaction_id());
        trans.setCreatedAt(transaction.getCreatedAt());

        Long enterpriseId = trans.getEnterprise().getEnterprise_id();
        Enterprise enterprise = enterpriseService.obtenerPorId(enterpriseId);
        trans.setEnterprise(enterprise);

        Long employeeId = trans.getEmployee().getEmployee_id();
        Employee employee = employeeService.obtenerPorId(employeeId);
        trans.setEmployee(employee);


        Date date = new Date();
        trans.setUpdatedAt(date);
        return transactionService.actualizar(trans);
    }

    @DeleteMapping
    public void eliminar (@RequestBody Transaction trans){
        transactionService.eliminar(trans);
    }

}


