package com.jobll.web.user;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobll.web.user.UserRepository;
import com.jobll.web.user.User;

@Service
public class UserServiceImpl {

	@Autowired
	private UserRepository userRepository;
	
	
	public List<HashMap<String, Object>> select(User entity)throws Exception{
		userRepository.select(entity);
		return null;
	}
	public List<HashMap<String, Object>> read(User entity){
		userRepository.read(entity);
		return null;
	};
	public int create(User entity){
		userRepository.create(entity);
		return 0;
	}
	public int edit(User entity){
		userRepository.edit(entity);
		return 0;
	};
	public int delete(User entity){
		userRepository.delete(entity);
		return 0;
	};
	

}
