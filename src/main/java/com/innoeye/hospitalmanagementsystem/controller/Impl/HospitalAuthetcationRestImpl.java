package  com.innoeye.hospitalmanagementsystem.controller.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innoeye.hospitalmanagementsystem.authentication.service.MyUserDetailsService;
import com.innoeye.hospitalmanagementsystem.controller.HospitalAuthenticationRest;
import com.innoeye.hospitalmanagementsystem.exceptions.HospitalException;
import com.innoeye.hospitalmanagementsystem.util.HospitalAuthenticationRequest;
import com.innoeye.hospitalmanagementsystem.util.HospitalAuthenticationResponse;
import com.innoeye.hospitalmanagementsystem.util.HospitalUtil;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
//@RequestMapping(path="/authenticate")
public class HospitalAuthetcationRestImpl implements HospitalAuthenticationRest {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private MyUserDetailsService myUserDetailsService;

	@Autowired
	private HospitalUtil jwtTokenUtil;

	
	@Override
	public ResponseEntity<?> authenticate(HospitalAuthenticationRequest authenticationRequest)
			throws HospitalException {
		log.info("inside createAuthenticationToken");
		String token = "";
		try {
			final UserDetails userDetails = myUserDetailsService
					.loadUserByUsername(authenticationRequest.getuserName());
			if (userDetails.getPassword().equals(authenticationRequest.getPassword())) {
				token = jwtTokenUtil.generateToken(userDetails);
			} else {
				throw new HospitalException("incorrect password");
			}
			log.info("token is : {}", token);
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDetails.getUsername(),
					userDetails.getPassword(), userDetails.getAuthorities()));
		} catch (BadCredentialsException e) {
			throw new BadCredentialsException("incorrect username or password", e);
		} catch (HospitalException une) {
			log.error("HospitalException occured while createAuthenticatioRnToken : {} ", une.getMessage());
//			return une.setMessage(token);
		}
		return ResponseEntity.ok(new HospitalAuthenticationResponse(token));

	}
}