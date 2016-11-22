package com.ravi.jupudi.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ravi.jupudi.department.model.Department;
/**
 * 
 * @author Ravi Jupudi
 *
 */

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
