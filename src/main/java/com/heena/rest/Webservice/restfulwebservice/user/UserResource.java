package com.heena.rest.Webservice.restfulwebservice.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	@Autowired
	private UserDAO service;

	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.findall();
	}

	@GetMapping("/users/{id}")
	public User retrieveUserById(@PathVariable Integer id) {
		User user = service.findOne(id);
		if (user == null)
			throw new UserNotFoundException("id-" + id);
		return user;

	}
	
	@DeleteMapping("/users/{id}")
	public User deleteUserById(@PathVariable Integer id) {
		User user = service.deleteById(id);
		if (user == null)
			throw new UserNotFoundException("id-" + id);
		return user;
//HATEOAS- spring -boot - starter hateoas
	}

	@PostMapping("/users")
	public ResponseEntity<Object> CreateUser(@Valid @RequestBody User user) {
		User user1 = service.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user1.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

}
