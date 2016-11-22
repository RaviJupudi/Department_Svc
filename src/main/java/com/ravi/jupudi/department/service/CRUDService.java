package com.ravi.jupudi.department.service;

/**
 * @author Ravi Jupudi
 */
import java.io.Serializable;
import java.util.List;

public interface CRUDService<E> {

	E create(E entity);

	E getById(Serializable id);

	List<E> getAll();

	void delete(Serializable id);
}
