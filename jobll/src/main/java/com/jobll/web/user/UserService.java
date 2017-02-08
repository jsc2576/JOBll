package com.jobll.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import com.jobll.web.home.Home;
import com.jobll.web.user.User;
import com.jobll.web.user.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

@Service
public interface UserService {

	
	public List<HashMap<String, Object>> select(User entity) throws Exception;
	public List<HashMap<String, Object>> read(User entity);
	public int create(User entity);
	public int edit(User entity);
	public int delete(User entity);

}
