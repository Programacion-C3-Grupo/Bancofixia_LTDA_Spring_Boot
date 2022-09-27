package com.ProgramacionC3.ProyectoCiclo3.controller.frontend;

//<<<<<<< Updated upstream

import com.ProgramacionC3.ProyectoCiclo3.controller.EnterpriseController;
import com.ProgramacionC3.ProyectoCiclo3.controller.TransactionController;
import com.ProgramacionC3.ProyectoCiclo3.entities.Employee;
import com.ProgramacionC3.ProyectoCiclo3.entities.Enterprise;
import com.ProgramacionC3.ProyectoCiclo3.entities.Transaction;
import com.ProgramacionC3.ProyectoCiclo3.service.EmployeeService;
import com.ProgramacionC3.ProyectoCiclo3.service.EnterpriseService;
import com.ProgramacionC3.ProyectoCiclo3.service.TransactionService;
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

    @Autowired
    TransactionService transactionService;

    @Autowired
    EnterpriseService enterpriseService;

    @Autowired
    EnterpriseController enterpriseController = new EnterpriseController();

    @Autowired
    TransactionController transactionController = new TransactionController();




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
       /* EmployeeController.insertar(employee);*/
        System.out.println(employee);
        return "redirect:/empleado";
    }

    @GetMapping("/employeetable")
    public String getemployeetable (Model model){
        model.addAttribute("employees", employeeService.listar());
        return "employeetable";
    }

    @PostMapping("/employeetable")
    public String employeetable (Model model){
        model.addAttribute("Employees", employeeService.listar());
        return "redirect:/employeetable";
    }

    @GetMapping("/Transaction")
    public String getTransaction(Model model)
    {
        model.addAttribute("FormularioTrasaccion",new Transaction());
        return "Transaction" ;
    }
    @PostMapping("/Transaction")
    public String postTransaction(@ModelAttribute("FormularioTrasaccion")Transaction transaction)
    {

        transactionController.insertar(transaction);
        System.out.println(transaction);
        return "redirect:/TransactionTable";
    }

    @GetMapping("/TransactionTable")
    public String TransactionTable(Model model){
        model.addAttribute("Transactions", transactionService.listar());
        return "TransactionTable";
    }

    //------------Empresa-------------
    @GetMapping("/empresa")
    public String getEmpresa(Model model)
    {
        model.addAttribute("formularioEmpresa",new Enterprise());
        return "empresa" ;
    }
    @PostMapping("/empresa")
    public String postEmpresa(@ModelAttribute("formularioEmpresa")Enterprise enterprise)
    {

        enterpriseController.insertar(enterprise);
        System.out.println(enterprise);
        return "redirect:/empresaTable";
    }

    @GetMapping("/empresaTable")
    public String empresaTable(Model model){
        model.addAttribute("empresas", enterpriseController.listar());
        return "empresaTable";
    }

}
