package main.java.stockmarket.Contollers;

import java.util.List;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import main.java.stockmarket.Repositories.UserRepository;

import main.java.stockmarket.Entities.*;

@RestController
public class UserController {

	private final UserRepository repository;

	public UserController(UserRepository repository) {
		super();
		this.repository = repository;
	}
	
	@GetMapping("/users")
	List<User> all()
	{
		return repository.findAll();
	}
	
	@PostMapping("/users")
	User newUser(@RequestBody User newUser) {
		return repository.save(newUser);
	}
	
	@GetMapping("/users/{userId}")
	User getOne(@PathVariable Long id) {
		return repository.getOne(id);// TO DO: Add exception
	}
	
	@PutMapping("/users/{userId}")
	User replaceEmployee(@RequestBody User newUser, @PathVariable Long userId) {
		return repository.findById(userId)
				.map(User -> {
					User.setFirstName(newUser.getFirstName());
					User.setLastName(newUser.getLastName());
					User.setEmail(newUser.getEmail());
					return repository.save(User);
					})
				.orElseGet(() -> {
					newUser.setId(userId);
					return repository.save(newUser);
				});
	}
	
	@DeleteMapping("/users/{userId]}")
	void deleteEmployee(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
}
