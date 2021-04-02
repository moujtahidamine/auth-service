package org.d3h.application.services;

import java.util.ArrayList;
import java.util.List;

import org.d3h.application.entities.Role;
import org.d3h.application.entities.User;
import org.d3h.application.payload.response.UserDetail;
import org.d3h.application.payload.response.UsersIdName;
import org.d3h.application.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	// Get users :	
	public List<UserDetail> getUsers(){
		
		List<UserDetail> users = new ArrayList<>();
		
		for(User u : userRepository.findAll() ) {
			Role[] roles = new Role[1];
			u.getRoles().toArray(roles);
			String role = roles[0].getName().name();
			UserDetail user = new UserDetail(
					u.getId(),
					u.getName(),
					u.getUsername(),
					u.getEmail(),
					u.isOnline(),
					u.isDisabled(),
					role,
					u.getCreatedAt().toString()
					
			);
			user.toString();
			users.add(user);
		}
			
		return users;
	}

	public boolean setOffline(String username) {
		
		System.out.println("username : "+username);
		User u = userRepository.findByUsername(username).orElse(null);
		System.out.println(u);
		if(u == null)
			return false;
			
		try {
			
			System.out.println("Avant : "+u.isOnline());
			u.setId(userRepository.findByUsername(username).get().getId());
			u.setOnline(false);
			userRepository.save(u);
			
			System.out.println(u.toString());
		}
		catch(Exception ex) {
			System.out.println("error : "+ ex);
			
			return false;
		}
		
		return true;
	}

	public List<UsersIdName> getOptions() {
		
		List<UsersIdName> res = new ArrayList<>();
		
		for(User u : userRepository.findAll()) {
	
			UsersIdName option = new UsersIdName();
			option.setId(u.getId());
			option.setName(u.getName());
			
			res.add(option);
		}
		
		return res;
	}

}
