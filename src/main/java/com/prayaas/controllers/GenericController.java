package com.prayaas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prayaas.pojos.Activitytable;
import com.prayaas.pojos.Usertable;

@Controller
public class GenericController {
	@RequestMapping(value="/{abc}")
	public String forwardView(@PathVariable("abc") String abc2, Usertable user, Activitytable activity){
		System.out.println("Generic Controller : "+abc2);
		return abc2;
	}
}
