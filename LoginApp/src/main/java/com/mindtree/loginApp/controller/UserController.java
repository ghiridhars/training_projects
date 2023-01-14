package com.mindtree.loginApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.loginApp.dto.UserDto;
import com.mindtree.loginApp.entity.User;
import com.mindtree.loginApp.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/home")
	public String index() {
		return "home";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/logInUser")
	public String addUser(UserDto u) {
		return "loginPage";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/signUpUser")
	public String addEmployee(UserDto u) {
		return "signUpPage";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/enterUser")
	public String enterUser(@ModelAttribute("user") UserDto udto, Model m) {
		System.out.println(udto);
		UserDto ud= userService.saveUser(udto);
		m.addAttribute("name", ud.getName());
		m.addAttribute("emailId", ud.getEmailId());
		m.addAttribute("password", ud.getPassword());
		m.addAttribute("contactNo", ud.getContactNo());

		return "redirect:home";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/checkUser")
	public String checkUser(@ModelAttribute("user") User user, Model m) {

		System.out.println(user);
		User result = userService.getByNamePassword(user.getName(), user.getPassword());

		if (result == null) {
			m.addAttribute("message", "Failure");
		} else {
			m.addAttribute("message", "Success");
		}
		return "result";
	}

}
