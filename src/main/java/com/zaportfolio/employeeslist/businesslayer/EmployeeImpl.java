package com.zaportfolio.employeeslist.businesslayer;


import com.zaportfolio.employeeslist.apersistancelayer.domain.Employee;
import com.zaportfolio.employeeslist.apersistancelayer.repository.EmployeeRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class EmployeeImpl implements EmployeeService {

            private final EmployeeRepo employeeRepo;
            @Autowired
            public EmployeeImpl(EmployeeRepo employeeRepo) {
                this.employeeRepo = employeeRepo;
            }


    @Override
    public List<Employee> findAll() {
        return employeeRepo.findAllByOrderByLastNameAsc();
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepo.findById(id).orElseThrow(()
            -> new NoSuchElementException("Employee not found with ID: " + id));
    }

    @Override
    public Employee create(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public Employee update(Long id, Employee employee) {
        Employee existingEmployee = employeeRepo.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Employee not found with ID: " + id));
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());

        return employeeRepo.save(existingEmployee);
    }


    @Override
    public void deleteById(Long id) {
        Employee existingEmployee1 = employeeRepo.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Employee not found with ID: " + id));

        employeeRepo.delete(existingEmployee1);
    }

}

