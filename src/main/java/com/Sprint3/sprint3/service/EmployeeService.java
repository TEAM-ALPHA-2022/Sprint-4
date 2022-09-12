package com.Sprint3.sprint3.service;

import com.Sprint3.sprint3.entities.Employee;
import com.Sprint3.sprint3.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public void CreateAndUpdateEmployee(Employee employee){
        //Guardar
        employeeRepository.save(employee);
    }

    public List<Employee> seeEmployee(){
        List<Employee> employees = new ArrayList<Employee>();
        employeeRepository.findAll().forEach(employee -> employees.add(employee));
        return employees;
    }

    public Employee seeEmployeeId(long id){
        Employee employeeFound = (Employee) employeeRepository.findById(id).get();

        if (employeeFound != null){
            return employeeFound;
        } else {
            return null;
        }
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }


    public void updateEmployee(long id, Map<Object, Object> dataToUpdate){
        Employee employeeFound = seeEmployeeId(id);

        dataToUpdate.forEach((clave, valor) -> {
            Field campo = ReflectionUtils.findField(Employee.class, (String) clave);
            campo.setAccessible(true);
            ReflectionUtils.setField(campo, employeeFound, valor);
        });

        employeeRepository.save(employeeFound);
    }

}
