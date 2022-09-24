package com.ProgramacionC3.ProyectoCiclo3.controller.frontend;

<<<<<<< Updated upstream
import com.ProgramacionC3.ProyectoCiclo3.entities.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FrontEndController {

    @GetMapping("/")
    public String getIndex()
    {
        return "index";
    }

    @GetMapping("/Employees")
    public String getEmployee(@ModelAttribute("formularioEmployee") Employee employee)
    {
       return "Employees";
    }
    @PostMapping("/Employees")
    public String postEmployee(@ModelAttribute("formularioEmployee") Employee employee)
    {
        System.out.println(employee);
        return "redirect:/Employees";
    }
=======
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class FrontEndController {

    @GetMapping("/")
    public String getIndex(){
        return "index";

    }



>>>>>>> Stashed changes
}
