package com.ProgramacionC3.ProyectoCiclo3.controller;

import com.ProgramacionC3.ProyectoCiclo3.entities.Employee;
import com.ProgramacionC3.ProyectoCiclo3.entities.Enterprise;
import com.ProgramacionC3.ProyectoCiclo3.entities.Transaction;
import com.ProgramacionC3.ProyectoCiclo3.entities.UserResponse;
import com.ProgramacionC3.ProyectoCiclo3.service.EnterpriseService;
import com.ProgramacionC3.ProyectoCiclo3.service.TransactionService;
import com.ProgramacionC3.ProyectoCiclo3.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<UserResponse> insertar(@RequestBody Transaction trans){
        try {
            Date date = new Date();
            trans.setCreatedAt(date);
            trans.setUpdatedAt(date);
            return new ResponseEntity<>(
                    new UserResponse("Movimiento creado con éxito", transactionService.insertar(trans)),
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
    public ResponseEntity<UserResponse> actualizar(@RequestBody Transaction trans){
        try {
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
            return new ResponseEntity<>(
                    new UserResponse("Movimiento actualizado con éxito", transactionService.actualizar(trans)),
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
    public ResponseEntity<UserResponse> eliminar (@RequestBody Transaction trans){
        try {
            return new ResponseEntity<>(
                    new UserResponse(transactionService.eliminar(trans), null),
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


