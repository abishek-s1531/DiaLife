package com.diabetic.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.diabetic.demo.entity.Roles;
import com.diabetic.demo.entity.User;
import com.diabetic.demo.repository.RolesRepository;
import com.diabetic.demo.repository.UserRepository;
import com.diabetic.demo.service.UserService;

@Service
public  class UserServiceImpl implements UserService{
      
	@Autowired
	private UserRepository userRepository;
	

	@Autowired
	private RolesRepository rolesRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public User saveUser(Long roleId, User user) {

	    Roles role = rolesRepository.findById(roleId).orElseThrow(() -> new RuntimeException("Role not found with id : " + roleId));

	    user.setRoles(role);

	    user.setPassword(passwordEncoder.encode(user.getPassword()));

	    return userRepository.save(user);
	}
	
	public User saveUser(User user) {

	    user.setPassword(passwordEncoder.encode(user.getPassword()));
	    return userRepository.save(user);
	}
	
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
	
	public User getUserById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id : "+id));
	}
	

	public User updateUser(User user, Long id, Long roleId) {
	    User existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id : " + id));

	    existingUser.setName(user.getName());
	    existingUser.setEmail(user.getEmail());
	    existingUser.setPassword(passwordEncoder.encode(user.getPassword()));

	    Roles role = rolesRepository.findById(roleId).orElseThrow(() -> new RuntimeException("Role not found with id : " + roleId));
	    existingUser.setRoles(role);
	    
	    return userRepository.save(existingUser);
	}
	public void deleteUser(Long id) {
		User existingId= userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id : "+id));
		userRepository.delete(existingId);
		
	}

	
}
