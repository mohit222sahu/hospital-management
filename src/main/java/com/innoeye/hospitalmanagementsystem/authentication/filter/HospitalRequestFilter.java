package com.innoeye.hospitalmanagementsystem.authentication.filter;

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
     System.out.println("inside do doFilterInternal "); 
    final String authorizationHeader = request.getHeader("Authorization");
     String userName=null;
     String jwt=null;
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
     }
     response.addHeader("Access-Control-Allow-Origin", "*");
     response.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, PATCH, HEAD");
     response.addHeader("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
     response.addHeader("Access-Control-Expose-Headers", "Access-Control-Allow-Origin, Access-Control-Allow-Credentials");
     response.addHeader("Access-Control-Allow-Credentials", "true");
     response.addIntHeader("Access-Control-Max-Age", 10);
     System.out.println("after checking forwarded to  filterChain.doFilter"); 
     filterChain.doFilter(request,response);
    }
}
