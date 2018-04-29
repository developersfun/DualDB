package org.nrj.operations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.nrj.primary.entities.Mobile;
import org.nrj.primary.repo.MobileRepo;
import org.nrj.secondary.entities.Computer;
import org.nrj.secondary.repo.ComputerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {

	@Autowired
	private MobileRepo mobileRepo;

	@Autowired
	private ComputerRepo computerRepo;

	public void saveMobile(Mobile mobile) {

		mobileRepo.save(mobile);
	}

	public List<Mobile> getAllMobile() {

		List<Mobile> mobList = new ArrayList<Mobile>();
		
		mobileRepo.findAll().forEach(mobList::add);
		
		return mobList;
	}

	public List<Mobile> getMobile(Integer id) {

		List<Mobile> mobList = getAllMobile();
		
		return Arrays.asList(mobList.stream().filter(m->m.getMobId().intValue()==id).findFirst().get());
		
	}

	
	public void deleteMobile(Integer id) {
		
		mobileRepo.delete(getMobile(id).get(0));
	}


	public void saveComputer(Computer computer) {

		computerRepo.save(computer);
	}

	public List<Computer> getAllComputer() {

		List<Computer> compList = new ArrayList<Computer>();
		
		computerRepo.findAll().forEach(compList::add);
		
		return compList;
	}

	public List<Computer> getComputer(Integer id) {

		List<Computer> compList = getAllComputer();
		
		return Arrays.asList(compList.stream().filter(c->c.getCompId().intValue()==id).findFirst().get());
		
	}

	
	public void deleteComputer(Integer id) {
		
		computerRepo.delete(getComputer(id).get(0));
	}
	
}
