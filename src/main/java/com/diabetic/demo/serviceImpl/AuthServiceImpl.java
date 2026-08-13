package com.diabetic.demo.serviceImpl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.diabetic.demo.entity.User;
import com.diabetic.demo.repository.UserRepository;

@Service
public class AuthServiceImpl {
   
	 private final UserRepository userRepository ;
	 private final PasswordEncoder passwordEncoder;
	 
	 public AuthServiceImpl(UserRepository userRepository,PasswordEncoder passwordEncoder) {
		 this.userRepository = userRepository;
		 this.passwordEncoder = passwordEncoder;
}

   public User login(String email, String password) {

          User user = userRepository.findByEmail(email).orElseThrow(() ->new RuntimeException("Invalid email or password"));

if (!passwordEncoder.matches(password, user.getPassword())) {
  throw new RuntimeException("Invalid email or password");
}

    return user;
 }
}
