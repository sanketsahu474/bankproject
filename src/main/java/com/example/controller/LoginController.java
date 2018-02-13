package com.example.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.model.User;
import com.example.model.users;
import com.example.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public ModelAndView registration(){
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("registration");
		return modelAndView;
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult
					.rejectValue("email", "error.user",
							"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("registration");
			
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/admin/home", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		//added for change
		users use = new users();
		modelAndView.addObject("users", use);
		//till here
		modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
		modelAndView.setViewName("admin/home");
		return modelAndView;
	}
	
	@RequestMapping(value = "/admin/home", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid users use, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		users useExists =userService.findByCardno(use.getCardno());
		if(useExists != null) {
			bindingResult
			.rejectValue("cardno", "error.use",
					"There is already a user using this card no.");
}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("admin/home");
		} else {
			userService.saveusers(use);
			
			//modelAndView.addObject("user", new users());
			//for change
			modelAndView.addObject("cardno",""+use.getCardno());
			modelAndView.addObject("name",""+use.getFirstname()+" "+use.getMiddlename()+" "+use.getLastname()+" ");
			modelAndView.addObject("validdate",""+use.getValidfrom());
			modelAndView.addObject("expiry",""+use.getExpiry());
			modelAndView.addObject("cvv",""+use.getCvv());
			modelAndView.addObject("type",""+use.getCardtype());
			modelAndView.addObject("bankname",use.getBankname());
			modelAndView.addObject("successMessage", "User card details succesfully have been stored");
			modelAndView.setViewName("admin/home");
			
		}
		return modelAndView;
	}

}
