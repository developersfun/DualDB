package org.nrj.operations;

import java.util.List;

import org.nrj.primary.entities.Mobile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DBController {
	
	@Autowired
	private DBService dbService;
	
	@RequestMapping(value="/get-mobile", method = RequestMethod.GET)
    public List<Mobile> getAllMobile(){
        return dbService.getAllMobile();
    }
    @RequestMapping(value="/add-mobile", method = RequestMethod.POST)
    public void addMobile(@RequestBody Mobile mobile){
        dbService.saveMobile(mobile);
    }
	
}
