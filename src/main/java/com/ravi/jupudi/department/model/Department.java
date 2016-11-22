package com.ravi.jupudi.department.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Ravi Jupudi
 *
 */

@Entity
@Table(name = "department")
public class Department implements java.io.Serializable {
	
	private static final long serialVersionUID = 6357828988183886662L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = false, nullable = false)
	private Long id;

	@Column(name = "dept", unique = true, nullable = false, length = 50)
	private String dept;

	@Column(name = "salary_min_range", length = 50)
	private Long salary_min_range;

	@Column(name = "salary_max_range", length = 20)
	private Long salary_max_range;

	public Department() {
	}

	public Department(Long id) {
		this.id = id;
	}

	public Department(Long id, String dept, Long salary_min_range, Long salary_max_range) {
		this.id = id;		
		this.dept = dept;
		this.salary_min_range = salary_min_range;
		this.salary_max_range = salary_max_range;
	}


	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}	

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}	

	public Long getSalary_min_range() {
		return salary_min_range;
	}

	public void setSalary_min_range(Long salary_min_range) {
		this.salary_min_range = salary_min_range;
	}

	public Long getSalary_max_range() {
		return salary_max_range;
	}

	public void setSalary_max_range(Long salary_max_range) {
		this.salary_max_range = salary_max_range;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Id: ").append(this.id).append(", name: ").append(", Department: ").append(this.dept).append(", Salary_Min_Range: ")
				.append(this.salary_min_range).append(", Salary_Max_Range: ").append(this.salary_max_range);
		return sb.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (id == null || obj == null || getClass() != obj.getClass())
			return false;
		Department toCompare = (Department) obj;
		return id.equals(toCompare.id);
	}

	@Override
	public int hashCode() {
		return id == null ? 0 : id.hashCode();
	}

}
