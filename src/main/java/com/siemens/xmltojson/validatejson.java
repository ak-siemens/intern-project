package com.siemens.xmltojson;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
public class validatejson {

	public void valjson(JSONObject json) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			User u = mapper.readValue(json.getJSONObject("user").toString() , User.class);
			System.out.println("User's age is "+ u.getAge());
			System.out.println("User's first name is "+ u.getFirstname());
			System.out.println("User's last name is "+ u.getLastname());
			
			Address a= u.getAddress();
			System.out.println("User's address is "+ a.toString());
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
