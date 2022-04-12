package com.codeplanet;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {
	@Autowired
	TestRestService TestRestService;
	
	@GetMapping("/FirstApi")
	public ArrayList <Map<String ,String>> getFirstApi(HttpServletRequest req)
	{
		ArrayList<Map<String, String>> arrayList=TestRestService.getFirstApi(req.getParameter("email"));
				
		
		
		return arrayList;
	}

}
