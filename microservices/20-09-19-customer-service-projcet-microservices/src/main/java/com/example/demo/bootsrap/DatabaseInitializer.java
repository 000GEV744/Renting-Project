package com.example.demo.bootsrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserServiceImpl;


@Component
public class DatabaseInitializer implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired  private UserRepository userRepo; 
	@Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		init();
		
	}

	private void init() {
		User anuj  = new User("Anuj", "Singh", "anuj6@gg.com", "anuj@123", "958930452", "bjrang nagar", "Bhopak", "karnatakja", 486001, "India");
		anuj.setUserId(UserServiceImpl.generateRandomString());
		String bpass=bCryptPasswordEncoder.encode(anuj.getPassword());
	    anuj.setPassword(bpass);
		userRepo.save(anuj);
		
	}
}
