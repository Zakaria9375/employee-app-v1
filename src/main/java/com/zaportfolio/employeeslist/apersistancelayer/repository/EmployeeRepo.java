package com.zaportfolio.employeeslist.apersistancelayer.repository;

import com.zaportfolio.employeeslist.apersistancelayer.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    public List<Employee> findAllByOrderByLastNameAsc();
}
