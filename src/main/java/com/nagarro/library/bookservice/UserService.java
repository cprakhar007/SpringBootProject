package com.nagarro.library.bookservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.library.entity.User;

@Service
public class UserService {

	@Autowired
	private RestTemplate restTemplate;
	
	
	public boolean checkUser(User us,String username) {
		
		
		User cus= restTemplate.getForObject("http://localhost:8085/users/"+username, User.class);
		
		if(cus!=null) {
			
			if(cus.getUserpassword().equals(us.getUserpassword())) {
				return true;
			}
		}
		
		
		return false;
	}
	
}
