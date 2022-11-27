package com.ping.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	//need a controller method to show the initial HTML from
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	//need a controller method to process the HTML form.
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	//new a controller method to read form data and add data to the model
	@RequestMapping("/processFormVersionTwo")
	public String processFormVersionTwo(HttpServletRequest request, Model model) {
		//read the request parameter from the HTML from
		String theName = request.getParameter("studentName");
		// Convert the data to all caps
		theName = theName.toUpperCase();
		
		//create the message
		String resultString = "Yo!" + theName;
		//add message to the model
		model.addAttribute("message", resultString);
		
		return "helloworld";
	}
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {
		//read the request parameter from the HTML from
		//String theName = request.getParameter("studentName");
		// Convert the data to all caps
		theName = theName.toUpperCase();
		
		//create the message
		String resultString = "Hey my friend from v3" + theName;
		//add message to the model
		model.addAttribute("message", resultString);
		
		return "helloworld";
	}
}
