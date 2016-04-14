package it.ads.activitiesmanager.web.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import it.ads.activitiesmanager.service.IUserDS;
import it.ads.activitiesmanager.service.impl.UserDSImpl;
import it.ads.activitiesmanager.service.common.UserStruct;

/**
 * WelcomeController
 * 
 * @author Paolo Porcedda
 *
 */
@Controller
@RequestMapping(value = "/")
public class WelcomeController {
	
	@Autowired
	private IUserDS userService;
	
	@RequestMapping(value = { "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {

		ModelAndView model = new ModelAndView();
		model.addObject("welcomeMessage", "Welcome to \"WORKER\" area");
		model.setViewName("welcome");
		return model;
	}

	@RequestMapping(value = { "/admin**" }, method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("welcomeMessage", "Welcome to \"ADMIN\" area");//LoginMessageKeyEnum.LOGIN_ADMIN_OK.getKey());
		model.setViewName("welcome");
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid user/pwd");//BGLoginErrorEnum.LOGIN_ERROR.getKey());
		}

		if (logout != null) {
			model.addObject("msg", "Logout regularly completed");//LoginMessageKeyEnum.LOGIN_LOGOUT_OK.getKey());
		}
		model.setViewName("login");

		return model;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String welcome(Model model) {
		model.addAttribute("user",new UserStruct());
		return "/registerPost";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView register(@RequestParam(value = "errord", required = false) String errorData,
			@RequestParam(value = "errorr", required = false) String errorRegister, @ModelAttribute UserStruct user) {
		ModelAndView model = new ModelAndView();
		
		String error = userService.register(user);
		
		if(error.equals("errorData")) {
			model.addObject("errord", "Wrong data");			
		}
		else if(error.equals("errorRegister")) {
			model.setViewName("register");
		}

		return model;
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied(Principal user) {
		ModelAndView model = new ModelAndView();
		model.addObject("errorMessage", "You don't have permission to access to this page");//BGLoginErrorEnum.LOGIN_PERMISSION_ERROR.getKey());
		model.setViewName("errors/403");
		return model;

	}

}
