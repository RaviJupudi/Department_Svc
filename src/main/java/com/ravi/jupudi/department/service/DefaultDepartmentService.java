package com.ravi.jupudi.department.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.jupudi.department.model.Department;
import com.ravi.jupudi.department.repository.DepartmentRepository;

/**
 * 
 * @author Ravi Jupudi
 *
 */
@Service
public class DefaultDepartmentService implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department create(Department entity) {
		return departmentRepository.save(entity);
	}

	@Override
	public Department getById(Serializable id) {
		return departmentRepository.findOne((Long) id);
	}

	@Override
	public List<Department> getAll() {
		return departmentRepository.findAll();
	}

	@Override
	public void delete(Serializable id) {
		departmentRepository.delete((Long) id);
	}

}
