package com.ProgramacionC3.ProyectoCiclo3.controller;

import com.ProgramacionC3.ProyectoCiclo3.entities.Employee;
import com.ProgramacionC3.ProyectoCiclo3.entities.Enterprise;
import com.ProgramacionC3.ProyectoCiclo3.entities.UserResponse;
import com.ProgramacionC3.ProyectoCiclo3.service.EmployeeService;
import com.ProgramacionC3.ProyectoCiclo3.service.EnterpriseService;
import com.ProgramacionC3.ProyectoCiclo3.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private EnterpriseService enterpriseService;

    @GetMapping
    public List<Employee> Listar() { return employeeService.listar();}

    @PostMapping
    public ResponseEntity<UserResponse> insertar (@RequestBody Employee ent) {
        try {
            Date date = new Date();
            ent.setCreatedAt(date);
            ent.setUpdatedAt(date);
            return new ResponseEntity<>(
                    new UserResponse("Empleado creado con éxito", employeeService.insertar(ent)),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    new UserResponse(e.getMessage(), null),
                    HttpStatus.OK
            );
        }
    }

    @PutMapping
    public ResponseEntity<UserResponse> actualizar (@RequestBody Employee ent) {
        try {
            Employee employee = employeeService.obtenerPorId(ent.getEmployee_id());
            ent.setCreatedAt(employee.getCreatedAt());
            Long enterpriseId = ent.getEnterprise().getEnterprise_id();
            Enterprise enterprise = enterpriseService.obtenerPorId(enterpriseId);
            ent.setEnterprise(enterprise);
            Date date = new Date();
            ent.setUpdatedAt(date);
            return new ResponseEntity<>(
                    new UserResponse("Empleado actualizado con éxito", employeeService.actualizar(ent)),
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
    public ResponseEntity<UserResponse> eliminar (@RequestBody Employee ent) {
        try {
            return new ResponseEntity<>(
                    new UserResponse(employeeService.eliminar(ent), null),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    new UserResponse(e.getMessage(), null),
                    HttpStatus.OK
            );
        }
    }
}
