package com.Sprint3.sprint3.controller;

import com.Sprint3.sprint3.entities.Employee;
import com.Sprint3.sprint3.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/users")
    private List<Employee> seeEmployees(){
        return employeeService.seeEmployee();
    }

    @PostMapping("/users")
    private void createEmployee(@RequestBody Employee employee){

        employeeService.CreateAndUpdateEmployee(employee);
    }

    @GetMapping("/users/{id}")
    public Employee searchEmployee(@PathVariable long id){
        return employeeService.seeEmployeeId(id);
    }

    @DeleteMapping("/users/{id}")
    private void deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
    }

    @PatchMapping("/users/{id}")
    public void updateEmployee(@PathVariable long id, @RequestBody Map<Object, Object> dataToUpdate){
        employeeService.updateEmployee(id,dataToUpdate);
    }

}
