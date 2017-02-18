package com.jobll.web.login;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jobll.web.session.SessionUtil;
import com.jobll.web.usrinfo.UsrInfo;
//import com.jobll.web.sqlmappers.LoginMapper;

@Service
public class LoginService implements UserDetailsService {
	@Autowired
	private SessionUtil sessionUtil;
	
	@Resource
	private LoginRepository loginRepository;
	

	public UsrInfo getUsr(String usr_id) throws Exception {
		UsrInfo usrInfo= null;
		if (usr_id != null && !"".equals(usr_id)) usrInfo = loginRepository.getUsr(usr_id);
		return usrInfo;
	}
	@Override
	public UserDetails loadUserByUsername(String usr_id) throws UsernameNotFoundException {
		try {
			//UserVo domainUser = getUser(usr_id);
			UsrInfo domainUser = getUsr(usr_id);
			
			sessionUtil.setNewSession("SessionBean",domainUser);
			
				
			boolean enabled = true;
			boolean accountNonExpired = true;
			boolean credentialsNonExpired = true;
			boolean accountNonLocked = true;
			
			if (domainUser == null) throw new UsernameNotFoundException("Not Found ID : " + usr_id);
			 
			return new User(
					domainUser.getUsr_id(),
					domainUser.getUsr_pwd(),
					enabled,
					accountNonExpired,
					credentialsNonExpired,
					accountNonLocked,
					getAuthorities(1));

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
/*
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		try {
			UserVo domainUser = getUser(userId);

			boolean enabled = true;
			boolean accountNonExpired = true;
			boolean credentialsNonExpired = true;
			boolean accountNonLocked = true;
			
			if (domainUser == null) throw new UsernameNotFoundException("Not Found ID : " + userId);
			
			return new User(
					domainUser.getUserId(),
					domainUser.getPassWd(),
					enabled,
					accountNonExpired,
					credentialsNonExpired,
					accountNonLocked,
					getAuthorities(1));

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	*/
	/**
	 * Retrieves a collection of {@link GrantedAuthority} based on a numerical role
	 * @param role the numerical role
	 * @return a collection of {@link GrantedAuthority
	 */
	public Collection<? extends GrantedAuthority> getAuthorities(Integer role) {
		List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
		return authList;
	}

	/**
	 * Converts a numerical role to an equivalent list of roles
	 * @param role the numerical role
	 * @return list of roles as as a list of {@link String}
	 */
	public List<String> getRoles(Integer role) {
		List<String> roles = new ArrayList<String>();

		if (role.intValue() == 1) {
			roles.add("ROLE_USER");
			roles.add("ROLE_ADMIN");

		} else if (role.intValue() == 2) {
			roles.add("ROLE_USER");
		}

		return roles;
	}

	/**
	 * Wraps {@link String} roles to {@link SimpleGrantedAuthority} objects
	 * @param roles {@link String} of roles
	 * @return list of granted authorities
	 */
	public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}
}
