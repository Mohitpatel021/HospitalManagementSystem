package com.HMSApp.Hospital.Management.System.Service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
	 String extractUserName(String token);
	  String generateToken(UserDetails userDetails);
	  boolean isTokenValid(String token,UserDetails userDetails);

}
