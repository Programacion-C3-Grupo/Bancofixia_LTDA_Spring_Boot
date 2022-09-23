package com.ProgramacionC3.ProyectoCiclo3.controller;

import com.ProgramacionC3.ProyectoCiclo3.entities.Employee;
import com.ProgramacionC3.ProyectoCiclo3.entities.Enterprise;
import com.ProgramacionC3.ProyectoCiclo3.service.EmployeeService;
import com.ProgramacionC3.ProyectoCiclo3.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EnterpriseService enterpriseService;

    @GetMapping
    public List<Employee> Listar() {return employeeService.listar();}

    @PostMapping
    public Employee insertar (@RequestBody Employee ent) {
        Date date = new Date();
        ent.setCreatedAt(date);
        ent.setUpdatedAt(date);
        return employeeService.insertar(ent);
    }

    @PutMapping
    public Employee actualizar (@RequestBody Employee ent) {
        Employee employee = employeeService.obtenerPorId(ent.getEmployee_id());
        ent.setCreatedAt(employee.getCreatedAt());

        Long enterpriseId = ent.getEnterprise().getEnterprise_id();
        Enterprise enterprise = enterpriseService.obtenerPorId(enterpriseId);
        ent.setEnterprise(enterprise);
        Date date = new Date();
        ent.setUpdatedAt(date);
        return employeeService.actualizar(ent);
    }

    @DeleteMapping
    public void eliminar (@RequestBody Employee ent) {employeeService.eliminar(ent);}
}
