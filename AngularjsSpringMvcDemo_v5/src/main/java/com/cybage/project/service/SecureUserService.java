package com.cybage.project.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cybage.project.model.User;

/*
 * Indicates that an annotated class is a "Service", originally defined by Domain-Driven Design (Evans, 2003) as 
 * "an operation offered as an interface that stands alone in the model, with no encapsulated state."
 * Describes transaction attributes on a method or class.
 * @see     org.springframework.stereotype.Service
 * @see     org.springframework.transaction.annotation.Transactional
 */
@Service("SecureUserService")
public class SecureUserService implements UserDetailsService {

	@Autowired
	UserService userService;

	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findUserBySSO(username);
		if(user==null)
		{
			throw new UsernameNotFoundException("User not found");
		}		
		List<GrantedAuthority> authority = new ArrayList<>();
		authority.add(new SimpleGrantedAuthority("ROLE_"+user.getRole()));
		return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),true,true,true,true,authority);
	}

}
