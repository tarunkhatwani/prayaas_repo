package com.prayaas.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;

import com.prayaas.javamail.JavaMail;
import com.prayaas.pojos.Activitytable;
import com.prayaas.pojos.Usertable;
import com.prayaas.services.ExploreService;


@Controller
//@RequestMapping(value="/user")
public class ExploreController {

	@Autowired
	ExploreService service;
	
	@RequestMapping(value="/register")
	public String navigateRegister(Usertable user){ //dependency injection for saving the state
		return "register";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String registerUser(Usertable user, HttpSession hs){
		Integer id = service.registerUser(user);
		if(id == null){
			System.out.println("Unsuccessfull Registration");
			hs.setAttribute("checkLogin", "fail");
			return "register";
		}else{
			System.out.println("Registration Successfull");
			hs.setAttribute("checkLogin", "success"); //for front-end to display name of the user after login instead of login/register
			//button
			hs.setAttribute("user", user);
			return "redirect:/index";
		}
	}
	
	@RequestMapping(value="/logout")
	public String logoutDo(HttpSession hs){
		System.out.println("Invalidating Session");
		hs.invalidate();
		return "redirect:/index";
	}
	
	@RequestMapping(value="/login")
	public String naviagteLogin(Activitytable activity)
	{
		return "login";
	}
	
	@RequestMapping(value = "/activityinfo" , method=RequestMethod.POST)
	public String showActivity(/*@RequestParam(value="id")Integer activity_Id,*/Activitytable activity, HttpSession hs, Model map,HttpServletRequest request){
		//System.out.println(activity.getActivity_Id());
		try {
			//System.out.println("hiiiiii" + request.getParameter("activity_Id"));
			Integer id=Integer.parseInt(request.getParameter("activity_Id"));
			//System.out.println(id+"lllllllllllllllllll");
			Activitytable activity1 = service.getActivityInfo(id); 
			//System.out.println(activity1+"oooooooooooooooooooooooo");
			hs.setAttribute("activityInfo", activity1);
			return "redirect:/activityinfo";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.println("errorrr!!!!!!!!!!!");
			return "Activity";
		}
	}
	
	@RequestMapping(value = "/registeractivity", method = RequestMethod.POST)
	public String registerForAct(Usertable user, Activitytable activity, HttpSession hs){
		if(hs.getAttribute("user") == null){
			hs.setAttribute("status", "Login/Register first or you've already registered"); //To be displayed in the Front-end
			return "redirect:/index";
		}else{
			Integer id = service.registerForAct((Usertable)hs.getAttribute("user"), (Activitytable)hs.getAttribute("activityInfo"));
			if(id == null){
				hs.setAttribute("status", "Registration UnSuccessfull");
				return "redirect:/activityinfo";
			}else{
				hs.setAttribute("status", "Registration Successfull");
				JavaMail mail = new JavaMail(((Usertable)hs.getAttribute("user")).getUser_Email(), 
						(Activitytable)hs.getAttribute("activityInfo"));
				return "redirect:/Activity";
			}
		}
		//return null;
	}
	
	@RequestMapping(value = "/loginCheck" ,method = RequestMethod.POST)
	public void loginCheck(Usertable user, HttpSession session, HttpServletResponse response, Activitytable activity, Model map)
	{
		Usertable userLogin = service.validate(user);
		if(userLogin != null)
		{
			session.setAttribute("user", userLogin);
			PrintWriter out = null;
			try
			{
				if(userLogin.getUser_Email().equals("admin@admin.com"))
				{
					out = response.getWriter();
					out.print("admin");
				}
				else
				{
					List<Activitytable> activityTable = service.getActivityDetails(userLogin.getUser_City());
					session.setAttribute("activityTable", activityTable);
					out = response.getWriter();
					out.print("success");
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
