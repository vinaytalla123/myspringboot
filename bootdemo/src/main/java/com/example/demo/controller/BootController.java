package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.model.Employee;

@RestController
public class BootController {
	@Autowired
	EmployeeDao empDao;
	
	
	@RequestMapping("/")
	public String urlButton() {
		return "login";
	}

	@RequestMapping("/home")
	public ModelAndView homeContrler(Employee emp) {
		
		empDao.save(emp);
        ModelAndView mav = new ModelAndView();
		mav.addObject("emp", emp);
	    mav.setViewName("home");
		return mav;
	}
	
	
	@PostMapping("/login")
	public Employee homePostContrler(@RequestBody Employee emp) {
		
		empDao.save(emp);
       
		return emp;
	}
	
	
	
	
	
	
	
	@RequestMapping("/display")
	//@ResponseBody
	public ModelAndView FetchEmployee(int eid) {
		//return empDao.findAll().toString();
		
		
		
		  ModelAndView mav = new ModelAndView(); 

		 Employee emp =  empDao.findById(eid).orElse(new Employee());
		  mav.addObject("emp", emp);
		  mav.setViewName("display");
		  
		  
		  return mav;
		 
		
	}
	
	
	@RequestMapping("/emp/222")
	@ResponseBody
	public String restEmpValues() {
		return empDao.findById(222).toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
