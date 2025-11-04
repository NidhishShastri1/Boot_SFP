package com.example.boot_sfp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.boot_sfp.model.Employee;

public interface Emrepository extends JpaRepository<Employee, Long>{
	List<Employee> findByDept(String dept);
	List<Employee> findByAge(int age);

}
