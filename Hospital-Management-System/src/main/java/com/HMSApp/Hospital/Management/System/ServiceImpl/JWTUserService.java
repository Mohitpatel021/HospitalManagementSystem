package com.HMSApp.Hospital.Management.System.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.HMSApp.Hospital.Management.System.Repository.DoctorRepository;
import com.HMSApp.Hospital.Management.System.Repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class JWTUserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private DoctorRepository doctorRepository;
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username){
			if(userRepository.existsByUsername(username)) {
				return userRepository.findByUsername(username);
			}else {
				return doctorRepository.findByUsername(username);
		}
	}
}
