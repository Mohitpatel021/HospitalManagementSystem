package com.HMSApp.Hospital.Management.System.Security;

import com.HMSApp.Hospital.Management.System.Exception.UserNotFoundException;
import com.HMSApp.Hospital.Management.System.Service.JwtService;
import com.HMSApp.Hospital.Management.System.ServiceImpl.JWTUserService;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

  private Logger logger = LoggerFactory.getLogger(OncePerRequestFilter.class);

  @Autowired
  private JwtService jwtService;

  @Autowired
  JWTUserService jwtUserServiceImpl;

  @Override
  protected void doFilterInternal(
    HttpServletRequest request,
    HttpServletResponse response,
    FilterChain filterChain
  ) throws ServletException, IOException {
    final String authHeader = request.getHeader("Authorization");
    String jwtToken = null;
    String username = null;
    if (authHeader == null || !authHeader.startsWith("Bearer")) {
      filterChain.doFilter(request, response);
      return;
    } else {
      jwtToken = authHeader.substring(7); //Bearer Has length 7
      try {
        username = jwtService.extractUserName(jwtToken);
      } catch (ExpiredJwtException e) {
        logger.error("Jwt Token is Expired !!Please Login again");
      } catch (UserNotFoundException e) {
        logger.error("User not Found With the Provieded UserName!!");
      } catch (Exception e) {
        logger.error("Error !! Something went Wrong");
      }
    }
    if (
      username != null &&
      SecurityContextHolder.getContext().getAuthentication() == null
    ) {
      try {
        UserDetails userdetails = jwtUserServiceImpl.loadUserByUsername(
          username
        );
        if (jwtService.isTokenValid(jwtToken, userdetails)) {
          SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
          UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
            userdetails,
            null,
            userdetails.getAuthorities()
          );
          token.setDetails(
            new WebAuthenticationDetailsSource().buildDetails(request)
          );
          securityContext.setAuthentication(token);
          SecurityContextHolder.setContext(securityContext);
        }
      } catch (UserNotFoundException e) {
        logger.error("User Not Found !!");
      }
    }
    filterChain.doFilter(request, response);
  }
}
