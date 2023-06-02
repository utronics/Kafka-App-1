package com.utronics.astradb.service;

import com.utronics.astradb.model.Employee;
import com.utronics.astradb.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {
    @Autowired
   private EmployeeRepository employeeRepository;

    public Flux<Employee> getAllEmployees(){
       return employeeRepository.findAll().onErrorResume(e -> Flux.just(new Employee()));
   }
    public Mono<Employee> getEmployeeById(int id){
       return employeeRepository.findById(id);
   }

   public Mono<Employee> insertEmployee(Employee employee){
       return employeeRepository.insert(employee);
   }

   public Mono<Employee> updateEmployee(Employee employee){
       return employeeRepository.save(employee);
   }

   public Mono<Void> deleteEmployee(Integer id){
       return employeeRepository.deleteById(id);
   }
}
