package com.cybage.project.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cybage.project.model.EmployeeProfile;
import com.cybage.project.service.EmployeeProfileService;
import com.cybage.project.service.EmployeeService;
/*
 * This class provide access to the application behavior which is typically defined by 
 * a service interface.Controllers interpret user input and transform such input into a
 * sensible model which will be represented to the user by the view.
 * {@code @Controller}Indicates that an annotated class is a "Controller"
 * @author      Aniket Deshmukh
 * @version     %1%
 */
@Controller
public class WebMvcController {


	@Autowired
	EmployeeService employeeService;

	@Autowired
	EmployeeProfileService employeeProfileService;

	@ModelAttribute("roles")
	public List<EmployeeProfile> initializeProfiles() {
		return employeeProfileService.findAll();
	}

	/*
	 * This method map "/home" web requests to homeOperation handler
	 * @param response      interface to provide HTTP-specific functionality in sending 
	 *                      a response.  For example, it has methods to access HTTP
	 *                      headers and cookies.
	 * @return              <code>"home"</code> A Holder for both Model and View in the
	 *                      web MVC framework.
	 * @see                 org.springframework.web.bind.annotation.RequestMapping    
	 */
	@RequestMapping(value="/home")
	public String homeOperation(HttpServletResponse response,Model model) throws IOException{
		//List<Employee> employees= employeeService.findAllEmployees();
	
	/*	Employee emp = new Employee();
		emp.setName("Mahesh");
		emp.setEmail("mahesh@gmail.com");
		emp.setPassword("Mahesh");
		Set<EmployeeProfile> pro = new HashSet<>();
		EmployeeProfile eprof1 = new EmployeeProfile();
		eprof1.setType("DBA");
		pro.add(eprof1);
		emp.setEmployeeProfiles(pro);
		employeeService.save(emp);
		*/
		return "home";
	}
	

}
