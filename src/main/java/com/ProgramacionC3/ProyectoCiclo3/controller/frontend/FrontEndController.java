package com.ProgramacionC3.ProyectoCiclo3.controller.frontend;

//<<<<<<< Updated upstream
import com.ProgramacionC3.ProyectoCiclo3.entities.Employee;
import com.ProgramacionC3.ProyectoCiclo3.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FrontEndController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    public String getIndex()
    {
        return "index";
    }

    @GetMapping("/empleado")
    public String getEmployee(Model model)
    {
        model.addAttribute("formularioEmpleado",new Employee());
        return "empleado";
    }
    @PostMapping("/empleado")
    public String postEmployee(@ModelAttribute("formularioEmpleado") Employee employee)
    {
        System.out.println(employee);
        return "redirect:/employeetable";
    }

    @GetMapping("/employeetable")
    public String getWelcome(Model model){
        model.addAttribute("employees", employeeService.listar());
        return "employeetable";
    }

}
