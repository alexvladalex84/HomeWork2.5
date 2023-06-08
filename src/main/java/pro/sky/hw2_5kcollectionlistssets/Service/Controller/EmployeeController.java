package pro.sky.hw2_5kcollectionlistssets.Service.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pro.sky.hw2_5kcollectionlistssets.Service.EmployeeService;
import pro.sky.hw2_5kcollectionlistssets.Service.Exeption.ArrayIsFull;
import pro.sky.hw2_5kcollectionlistssets.Service.Exeption.EmployeeAlreadyAddedException;
import pro.sky.hw2_5kcollectionlistssets.Service.Exeption.EmployeeNotFoundException;

//@RequestMapping(path = "/employee")
@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public String addEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        try {
            return employeeService.addEmployee(firstName, lastName);

        } catch (ArrayIsFull e) {
            e.printStackTrace();
            return "Привышен лимит количества сотрудников " + employeeService.listEmployees();

        } catch (EmployeeAlreadyAddedException e) {
            e.printStackTrace();
            return "Сотрудник " + firstName + " " + lastName + " уже сущестует ";
        }
    }

    @GetMapping(path = "/remove")
    public String deleteEmployee(String firstName, String lastName) {
        try {
            return employeeService.deleteEmployee(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            e.printStackTrace();
            return "Такого сотрудника не существует " + employeeService.listEmployees();
        }

    }

    @GetMapping(path = "/find")
    public String findEmployee(String firstName, String lastName) {
        try {
            return employeeService.findEmployee(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            e.printStackTrace();
            return "Такого сотрудника не существует " + employeeService.listEmployees();

        }
    }


}
