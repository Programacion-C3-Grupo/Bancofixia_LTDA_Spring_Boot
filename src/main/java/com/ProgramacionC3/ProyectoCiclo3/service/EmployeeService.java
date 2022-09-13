package com.ProgramacionC3.ProyectoCiclo3.service;

import com.ProgramacionC3.ProyectoCiclo3.entities.Employee;
import com.ProgramacionC3.ProyectoCiclo3.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> listar(){
        return employeeRepository.findAll();
    }

    public void insertar(Employee employee){
        employeeRepository.save(employee);
    }

    public void actualizar(Employee employee){
        employeeRepository.save(employee);
    }

    public void eliminar(Employee employee){
        employeeRepository.delete(employee);
    }
}
