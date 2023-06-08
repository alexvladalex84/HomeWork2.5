package pro.sky.hw2_5kcollectionlistssets.Service;

import org.springframework.stereotype.Service;
import pro.sky.hw2_5kcollectionlistssets.Employee;
import pro.sky.hw2_5kcollectionlistssets.Service.Exeption.ArrayIsFull;
import pro.sky.hw2_5kcollectionlistssets.Service.Exeption.EmployeeAlreadyAddedException;
import pro.sky.hw2_5kcollectionlistssets.Service.Exeption.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    final int amountWorkers = 3;
    List<Employee> employees = new ArrayList<>();

    public String addEmployee(String firstName, String lastName) {
        Employee name = new Employee(firstName, lastName);
        if (employees.size() > amountWorkers) {
            throw new ArrayIsFull("Привышен лимит количества сотрудников!");
        } else if (employees.contains(name)) {
            throw new EmployeeAlreadyAddedException("Попытка добавить уже существующего сотрудника!");
        } else {
            employees.add(name);
        }
        return "Сотрудник " + name + " добавлен!" + listEmployees();


    }

    public String deleteEmployee(String firstName, String lastName) {
        Employee name = new Employee(firstName, lastName);
        if (!employees.contains(name)) {
            throw new EmployeeNotFoundException("Попытка найти не существующего сотрудника для удаления его из списка! ");
        } else {
            employees.remove(name);
        }
        return "Сотрудник " + name + " удален" + listEmployees();
    }

    public String findEmployee(String firstName, String lastName) {
        Employee name = new Employee(firstName, lastName);
        if (!employees.contains(name)) {
            throw new EmployeeNotFoundException("Попытка найти не существующего сотрудника в поиске!");
        } else {
            employees.contains(name);
        }
        return "По вашему запросу найден cотрудник :" + name + " " + listEmployees();
    }

    public String listEmployees() {
        return " Список сотрудников : " + employees;
    }


}
