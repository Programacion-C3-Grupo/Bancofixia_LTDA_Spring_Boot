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

    public Employee obtenerPorId(Long id) {
        return employeeRepository.getById(id);
    }

    public Employee insertar(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee actualizar(Employee employee){
        return employeeRepository.save(employee);
    }

    public void eliminar(Employee employee){
        employeeRepository.delete(employee);
    }
}
