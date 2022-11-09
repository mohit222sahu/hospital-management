package com.innoeye.hospitalmanagementsystem.authentication.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import com.innoeye.hospitalmanagementsystem.authentication.service.MyUserDetailsService;
import com.innoeye.hospitalmanagementsystem.util.HospitalUtil;

@Service
public class HospitalRequestFilter extends OncePerRequestFilter
{
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private HospitalUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
     final String authorizationHeader = request.getHeader("Authorization");
     String userName=null;
     String jwt=null;
     System.out.println("before doFilterInternal");
     
     if (authorizationHeader !=null && authorizationHeader.startsWith("Bearer ")){
         jwt = authorizationHeader.substring(7);
         userName=jwtUtil.getUsernameFromToken(jwt);
     }
     
     if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null){
    	 System.out.println("userName = "+userName); 
         UserDetails userDetails=this.myUserDetailsService.loadUserByUsername(userName);
         if (jwtUtil.validateToken(jwt,userDetails)){
             UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken= new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
             usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
             SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
         }
         System.out.println("method complete doFilterInternal");
     }
     filterChain.doFilter(request,response);
    }
}
