package com.prayaas.controllers;



//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

//import java.io.IOException;

import javax.servlet.http.HttpSession;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.prayaas.pojos.Activitytable;
import com.prayaas.services.AdminService;

@Controller
//@RequestMapping(value="/admin")
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	@RequestMapping(value="/upload")
	public String uploadActivityShow(Activitytable activity){
		return "uploadActivity"; //uploadActivity.jsp for uploading an activity
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String uploadActivity(Activitytable activity,HttpSession hs, @RequestParam MultipartFile file, HttpServletRequest request ){
		try {
/*			DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			activity.setActivity_Startdate(formatter.parse(request.getParameter("activity_Startdate1")));
			activity.setActivity_Enddate(formatter.parse(request.getParameter("activity_Enddate1")));*/
			if(!file.isEmpty()){
				Base64 base64 = new Base64();
				byte[] bytes = file.getBytes();
				//byte[] encodeBytes = DatatypeConverter.parse;
				String encodedStringBase64 = new String (base64.encode(bytes));
				activity.setImage(encodedStringBase64);
				hs.setAttribute("activityImage", encodedStringBase64);
			}
			//can have an else block with a default image
			Integer id = service.uploadActivity(activity);
			if(id == null){
				hs.setAttribute("activityStatus", "Activity not uploaded"); // for front-end to display status
				return "uploadActivity";
			}else{
				hs.setAttribute("activityDetails", activity); //activity image to be displayed
				hs.setAttribute("activityStatus", "Activity uploaded successfully");
				return "redirect:/uploadactivity";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Error in AdminController uploadActivity");
		}
		return null;
	}
}
