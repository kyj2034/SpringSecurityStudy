package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.securityDAO;
import com.sample.model.Employees;

@RestController
@RequestMapping(path = "/kangyejin")
public class MainController {
	@Autowired
	private securityDAO dao;
	
	@GetMapping(path="/", produces="application/json")
	public Employees getEmployees() {
		return dao.getAllEmployees();
	}
}
