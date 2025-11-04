package com.example.boot_sfp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Pageable;

import com.example.boot_sfp.model.Employee;
import com.example.boot_sfp.repository.Emrepository;

@Service
public class EMService {

	@Autowired
	Emrepository repo;

	public String addEmployee(List<Employee> student) {
		repo.saveAll(student);
		return "data inserted";
	}

	public List<Employee> fetchemployee() {
		return repo.findAll(Sort.by("name").ascending());
	}

	public List<Employee> filterbydept(String dept) {
		return repo.findByDept(dept);
	}

	/*// only pagination
	 * public Page<Employee> pagination(int pagenumber,int pagesize) {
	 * org.springframework.data.domain.Pageable pagable = PageRequest.of(pagenumber,
	 * pagesize); return repo.findAll(pagable); }
	 */
	
	
	// pagination + Sorting
	public boolean pagination(int pagenumber,int   pagesize, String field) { 
		Pageable pagable = PageRequest.of(pagenumber, pagesize,Sort.by(field).ascending());
		  Page<Employee> p =repo.findAll(pagable);
		  return p.hasNext();
	}

}
