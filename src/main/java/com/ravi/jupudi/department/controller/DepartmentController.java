package com.ravi.jupudi.department.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ravi.jupudi.department.model.Department;
import com.ravi.jupudi.department.service.DepartmentService;

/**
 * 
 * @author Ravi Jupudi
 *
 */

@RestController
@RequestMapping("/department")
public class DepartmentController {

	final static Logger logger = Logger.getLogger(DepartmentController.class);

	@Autowired
	DepartmentService deptService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Department> addEmployee(@RequestBody Department department) {
		deptService.create(department);
		logger.debug("Added:: " + department);
		return new ResponseEntity<Department>(department, HttpStatus.CREATED);
	}


	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> updateEmployee(@RequestBody Department department) {
		Department existingEmp = deptService.getById(department.getId());
		if (existingEmp == null) {
			logger.debug("Department with id " + department.getId() + " does not exists");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			deptService.create(department);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Department> getDepartment(@PathVariable("id") Long id) {
		Department department = deptService.getById(id);
		if (department == null) {
			logger.debug("Department with id " + id + " does not exists");
			return new ResponseEntity<Department>(HttpStatus.NOT_FOUND);
		}
		logger.debug("Found Department:: " + department);
		return new ResponseEntity<Department>(department, HttpStatus.FOUND);
	}


	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Department>> getAllEmployees() {
		List<Department> department = deptService.getAll();
		if (department.isEmpty()) {
			logger.debug("Department does not exists");
			return new ResponseEntity<List<Department>>(HttpStatus.NO_CONTENT);
		}
		logger.debug("Found " + department.size() + " Department");
		logger.debug(department);
		logger.debug(Arrays.toString(department.toArray()));
		return new ResponseEntity<List<Department>>(department, HttpStatus.OK);
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Long id) {
		Department employee = deptService.getById(id);
		if (employee == null) {
			logger.debug("Department with id " + id + " does not exists");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			deptService.delete(id);
			logger.debug("Department with id " + id + " deleted");
			return new ResponseEntity<Void>(HttpStatus.GONE);
		}
	}

}
