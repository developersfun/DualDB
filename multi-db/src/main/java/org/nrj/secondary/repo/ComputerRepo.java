package org.nrj.secondary.repo;

import org.nrj.secondary.entities.Computer;
import org.springframework.data.repository.CrudRepository;

public interface ComputerRepo extends CrudRepository<Computer, Integer>{
	
}
