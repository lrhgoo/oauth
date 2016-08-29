package com.mind.oauth.security;


import com.mind.oauth.entity.SysUser;
import com.mind.oauth.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserService implements UserDetailsService {

	@Autowired
	SysUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) {
		
		SysUser user = userRepository.findByUsername(username);

		if(user == null){
			throw new UsernameNotFoundException("用户名不存在");
		}
		
		return user;
	}

}
