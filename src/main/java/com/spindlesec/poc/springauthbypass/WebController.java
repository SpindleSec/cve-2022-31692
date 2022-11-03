package com.spindlesec.poc.springauthbypass;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

	@GetMapping("/admin")
	public String admin() {
		return "adminpage";
	}

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/forward")
	public String redirect() {
		return "forward:/admin";
	}
}
