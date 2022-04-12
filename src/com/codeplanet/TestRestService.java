package com.codeplanet;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestRestService {

	@Autowired
	
	TestRestRepository TestRestRepository ;
	
	public ArrayList <Map<String ,String>> getFirstApi(String email) {
		
	return	TestRestRepository.getFirstApi(email);
		
	
	}

}
