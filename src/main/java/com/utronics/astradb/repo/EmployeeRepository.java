package com.utronics.astradb.repo;

import com.utronics.astradb.model.Employee;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

public interface EmployeeRepository extends ReactiveCassandraRepository<Employee, Integer> {


}
