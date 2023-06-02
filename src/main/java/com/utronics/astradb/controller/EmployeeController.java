package com.utronics.astradb.controller;

import com.utronics.astradb.model.Employee;
import com.utronics.astradb.service.EmpKafkaProducer;
import com.utronics.astradb.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmpKafkaProducer empKafkaProducer;
    @GetMapping("/getAllEmployees")
    public Flux<Employee> getAll(){
        return employeeService.getAllEmployees();
    }
    @GetMapping("/getEmployeeById/{id}")
    public Mono<Employee> getById(@PathVariable Integer id){
        return employeeService.getEmployeeById(id);
    }
    @PostMapping("/insertEmployee")
    public Mono<Employee> insertEmployee(@RequestBody Employee employee){
        empKafkaProducer.sendMessages(employee);
        return employeeService.insertEmployee(employee);
    }
    @PutMapping("/updateEmployee")
    public  Mono<Employee> updateEmployee(@RequestBody Employee employee){
        empKafkaProducer.sendMessages(employee);
        return employeeService.updateEmployee(employee);
    }
    @DeleteMapping("/deleteEmployee/{id}")
    public Mono<Void> deleteEmployee(@PathVariable Integer id){
        return employeeService.deleteEmployee(id);
    }
}
