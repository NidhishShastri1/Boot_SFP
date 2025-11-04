package com.example.boot_sfp.controller;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.boot_sfp.model.Employee;
import com.example.boot_sfp.service.EMService;

@RestController
@RequestMapping("/employees")
public class Emcontroller {
	@Autowired
	EMService service;

	@PostMapping
	public String addEmployee(@RequestBody List<Employee> student) {
		return service.addEmployee(student);
	}

	@GetMapping("/sort")
	public List<Employee> fetchemployee() {
		return service.fetchemployee();
	}

	@GetMapping("/filter")
	public List<Employee> filterbydept(@RequestParam String dept) {
		return service.filterbydept(dept);
	}
	
	@GetMapping("/page")
	public boolean pagination(@RequestParam int pagenumber, @RequestParam int pagesize,@RequestParam String field) { 
		return  service.pagination(pagenumber, pagesize,field);
	}

}
