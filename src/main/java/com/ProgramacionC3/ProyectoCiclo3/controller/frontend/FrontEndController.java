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

    @GetMapping("/Employees")
    public String getEmployee(Model model)
    {
        model.addAttribute("formularioEmployee",new Employee());
        return "Employees";
    }
    @PostMapping("/Employees")
    public String postEmployee(@ModelAttribute("formularioEmployee") Employee employee)
    {
        System.out.println(employee);
        return "redirect:/employeetable";
    }

    @GetMapping("/employeetable")
    public String getWelcome(Model model){
        model.addAttribute("employee", employeeService.listar());
        return "employeetable";
    }

}
