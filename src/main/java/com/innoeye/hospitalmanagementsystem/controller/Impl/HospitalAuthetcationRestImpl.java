package  com.innoeye.hospitalmanagementsystem.controller.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.innoeye.hospitalmanagementsystem.authentication.model.HospitalAuthenticationRequest;
import com.innoeye.hospitalmanagementsystem.authentication.model.HospitalAuthenticationResponse;
import com.innoeye.hospitalmanagementsystem.authentication.service.MyUserDetailsService;
import com.innoeye.hospitalmanagementsystem.controller.IHospitalAuthenticationController;
import com.innoeye.hospitalmanagementsystem.exceptions.HospitalException;
import com.innoeye.hospitalmanagementsystem.util.HospitalUtil;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class HospitalAuthetcationRestImpl implements IHospitalAuthenticationController{

	//@Autowired
	//private AuthenticationManager authenticationManager;

	@Autowired
	private MyUserDetailsService myUserDetailsService;

	@Autowired
	private HospitalUtil jwtTokenUtil;

	
	@Autowired
	public String ping() {
		return "Hello Authentication";
	}

	@Autowired
	public ResponseEntity<HospitalAuthenticationResponse> createAuthenticationToken(HospitalAuthenticationRequest authenticationRequest)
			throws HospitalException {
		System.out.println("inside createAuthenticationToken");
		String token = "";
		try {
			final UserDetails userDetails = myUserDetailsService
					.loadUserByUsername(authenticationRequest.getuserName());
			if (userDetails.getPassword().equals(authenticationRequest.getPassword())) {
				token = jwtTokenUtil.generateToken(userDetails);
			} else {
				throw new HospitalException("incorrect password");
			}
			System.out.println("token is : {}"+ token);
			//authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDetails.getUsername(),
				//	userDetails.getPassword(), userDetails.getAuthorities()));
		} catch (BadCredentialsException e) {
			throw new BadCredentialsException("incorrect username or password", e);
		} catch (HospitalException une) {
			System.out.println("HospitalException occured while createAuthenticatioRnToken : {} "+ une.getMessage());
//			return une.setMessage(token);
		}
		return ResponseEntity.ok(new HospitalAuthenticationResponse(token));

	}
}