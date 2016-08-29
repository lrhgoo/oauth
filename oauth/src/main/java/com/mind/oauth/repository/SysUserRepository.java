package com.mind.oauth.repository;


import com.mind.oauth.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserRepository extends JpaRepository<SysUser, Long> {
	
	SysUser findByUsername(String username);

}
