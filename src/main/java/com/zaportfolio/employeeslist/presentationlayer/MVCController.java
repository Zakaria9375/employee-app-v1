package com.zaportfolio.employeeslist.presentationlayer;


import com.zaportfolio.employeeslist.apersistancelayer.domain.Employee;
import com.zaportfolio.employeeslist.businesslayer.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/list")
public class MVCController {
    private final EmployeeService employeeService;

    public MVCController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String viewHandler(Model model){
        List<Employee> myEmployees = employeeService.findAll();
        model.addAttribute("employees",myEmployees);
        return "index";
    }
    @GetMapping("/new")
    public String viewForm(Model model) {
        Employee myEmployee = new Employee();
        model.addAttribute("employee", myEmployee);
        return "form/add";
    }
    @GetMapping("/update")
    public String updateEmployee(@RequestParam("employeeId") long theId, Model model){
        Employee myEmployee = employeeService.findById(theId);
        model.addAttribute("employee", myEmployee);
        return "form/add";
    }
    @PostMapping("/save")
    public String saveNewEmployee (@ModelAttribute("employee") Employee myEmployee){
        employeeService.create(myEmployee);
        return "redirect:/list";
    }
    @GetMapping ("/delete")
    public  String deleteEmployee(@RequestParam("employeeId") long theId){
        employeeService.deleteById(theId);
        return "redirect:/list";
    }

}
