package com.example.demo.service;

import java.security.SecureRandom;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired private  UserRepository userRepo;
	@Autowired 
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	
	@Override
	public void deleteUser(String userId) {
		userRepo.deleteByUserId(userId);
	}
	
	
	@Override
	public UserDto findUserByUserId(String userId) {
		Optional<User> result=userRepo.findByUserId(userId);
		User user=null;
		if(result.isPresent()) {
	        	user=result.get();
	    }
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto userDto = mapper.map(user, UserDto.class);
		userDto.setUserId(UserServiceImpl.generateRandomString());
		return userDto;
	}
	
	
	
	//registering the user
		@Override
		public UserDto createUser(UserDto userDetails) {
			ModelMapper mapper = new ModelMapper();
			mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			
			if(userDetails.getPassword().equals(userDetails.getMatchingPassword())) {
				System.out.println("user's password matched");
				String email= userDetails.getEmail();
				User userAlreadyExists = userRepo.findByEmail(email);
				if(userAlreadyExists==null) {
			userDetails.setUserId(UserServiceImpl.generateRandomString());
			User user = mapper.map(userDetails, User.class);
			//becryptpassword
			String bpass=bCryptPasswordEncoder.encode(user.getPassword());
			user.setPassword(bpass);
			UserDto userDto = mapper.map(user, UserDto.class);
			userRepo.save(user);
			return userDto;
				}
		   }
			System.out.println("user already exist.!");
			return null;
		}
		
	
	
	
	//verifying the user
	@Override
	public UserDto verifyUser(String email, String pass ) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		User user = userRepo.findByEmail(email);
		if(user!=null) {
		   UserDto userdto = mapper.map(user, UserDto.class);	
			    if(userdto.getEmail().equals(email) && bCryptPasswordEncoder.matches(pass, userdto.getPassword()))
			    {
				return userdto;
			    }
			  else
			  {
				return null;
			  }
			}
		else {
			return null;
			}
	}
	
	
	//creating our own uId
	public static String generateRandomString() {
        String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
        String CHAR_UPPER = CHAR_LOWER.toUpperCase();
        String NUMBER = "0123456789";
        int length=6;
        String DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_UPPER + NUMBER;
        SecureRandom random = new SecureRandom();
        if (length < 1) throw new IllegalArgumentException();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            // 0-62 (exclusive), random returns 0-61
            int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
            char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);
            sb.append(rndChar);
        }
        return sb.toString();
    }


}
