package com.sampleApplication.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sampleApplication.bean.Registration;

@RestController
public class SampleController {

	@RequestMapping(value="/reg",method=RequestMethod.POST)
	private String save(@RequestBody Registration reg)
	{
		System.out.println("Registered successfully");
		return "registered";	
	}
	
	
}
