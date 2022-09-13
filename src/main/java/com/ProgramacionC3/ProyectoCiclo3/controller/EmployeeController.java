package com.ProgramacionC3.ProyectoCiclo3.controller;

import com.ProgramacionC3.ProyectoCiclo3.entities.Employee;
import com.ProgramacionC3.ProyectoCiclo3.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> Listar() {return employeeService.listar();}

    @PostMapping
    public void insertar (@RequestBody Employee ent) {employeeService.insertar(ent);}

    @PutMapping
    public void actualizar (@RequestBody Employee ent) {employeeService.actualizar(ent);}
    @DeleteMapping
    public void eliminar (@RequestBody Employee ent) {employeeService.eliminar(ent);}
}
