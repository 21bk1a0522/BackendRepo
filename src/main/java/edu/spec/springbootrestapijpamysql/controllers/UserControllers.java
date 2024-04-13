package edu.spec.springbootrestapijpamysql.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.spec.springbootrestapijpamysql.entities.User;
import edu.spec.springbootrestapijpamysql.exceptions.ResouceNotFoundException;
import edu.spec.springbootrestapijpamysql.respiratories.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserControllers {
@Autowired
private UserRepository userRepository;
@GetMapping
public List<User> getAllUsers(){
	return this.userRepository.findAll();
	}
@GetMapping("/{id}")
public User getUserById(@PathVariable(value="id")long userId) {
	return this.userRepository.findById(userId).orElseThrow(()->new ResouceNotFoundException("user not found with id:"+userId));
	
}
@PostMapping
public User createUser(@RequestBody User user) {
	return this.userRepository.save(user);
	}
@PutMapping("/{id}")
public User updateUser(@RequestBody User user,@PathVariable("id")long userId) {
	User existingUser = this.userRepository.findById(userId).orElseThrow(()->new ResouceNotFoundException("user not found"+userId));
	existingUser.setFirst_name(user.getFirst_name());
	existingUser.setLast_name(user.getLast_name());
	existingUser.setEmail(user.getEmail());
return this.userRepository.save(existingUser);
}
@DeleteMapping("/{id}")
public ResponseEntity<User> deleteUser(@PathVariable("id")long userId){
User existingUser = this.userRepository.findById(userId).orElseThrow(()->new ResouceNotFoundException("user not found with id:"+userId));
this.userRepository.delete(existingUser);
return ResponseEntity.ok().build();
}
}