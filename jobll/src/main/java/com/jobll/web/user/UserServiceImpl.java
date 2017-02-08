/*package com.jobll.web.user;

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
	

}*/
package com.jobll.web.user;
 
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
 
import com.jobll.web.user.User;
import com.jobll.web.user.UserMapper;
 
@Service
public class UserServiceImpl implements UserService {
     
     @Autowired UserMapper userMapper;
 
     @Override
     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
          User user = userMapper.readUser(username);
          user.setAuthorities(getAuthorities(username));
         
          return user;
     }
     
     public Collection<GrantedAuthority> getAuthorities(String username) {
          List<String> string_authorities = userMapper.readAuthority(username);
          List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
          for (String authority : string_authorities) {
               authorities.add(new SimpleGrantedAuthority(authority));
          }
          return authorities;
     }
}


