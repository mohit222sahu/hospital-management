package com.innoeye.hospitalmanagementsystem.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.innoeye.hospitalmanagementsystem.model.DoctorDetails;

@Aspect
@Component
public class AuthorizeUserAspect {
	
	@Around("@annotation(com.innoeye.hospitalmanagementsystem.annotation.AuthorizeUser)")
	public Object authorizeUser(ProceedingJoinPoint joinPoint) throws Throwable {

		//BEFORE METHOD EXECUTION
		System.out.println("inside AuthorizeUserAspect class");
		DoctorDetails doctor = (DoctorDetails) joinPoint.getArgs()[0];
		System.out.println("Doctor Object: " + doctor);
		//Only user id 33 is authorize to login, other user are not valid users.
		if (doctor.getFirstName().equalsIgnoreCase("Arvind")) {
			System.out.println("Invalid User : " + doctor.getFirstName());
			return doctor.getFirstName() + " is Invalid User. Please login with correct credential.";
		}

		//This is where ACTUAL METHOD will get invoke
		Object result = joinPoint.proceed();

		// AFTER METHOD EXECUTION
		//System.out.println(result);
		return result;
	}
}
