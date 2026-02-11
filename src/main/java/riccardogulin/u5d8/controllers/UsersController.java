package riccardogulin.u5d8.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import riccardogulin.u5d8.entities.User;
import riccardogulin.u5d8.payloads.UserPayload;
import riccardogulin.u5d8.services.UsersService;

import java.util.List;
import java.util.UUID;

/*

1. POST http://localhost:3001/users
2. GET http://localhost:3001/users
3. GET http://localhost:3001/users/{userId}
4. PUT http://localhost:3001/users/{userId}
5. DELETE http://localhost:3001/users/{userId}

*/

@RestController
@RequestMapping("/users")
public class UsersController {
	private final UsersService usersService;

	@Autowired
	public UsersController(UsersService usersService) {
		this.usersService = usersService;
	}

	// 1. POST http://localhost:3001/users (+ Payload)
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User createUser(@RequestBody UserPayload payload) {
		return this.usersService.save(payload);
	}

	// 2. GET http://localhost:3001/users
	@GetMapping
	public List<User> findAll() {
		return this.usersService.findAll();
	}

	// 3. GET http://localhost:3001/users/{userId}
	@GetMapping("/{userId}")
	public User findById(@PathVariable UUID userId) {
		return this.usersService.findById(userId);
	}

	// 4. PUT http://localhost:3001/users/{userId}
	@PutMapping("/{userId}")
	public User findByIdAndUpdate(@PathVariable UUID userId, @RequestBody UserPayload payload) {
		return this.usersService.findByIdAndUpdate(userId, payload);
	}

	// 5. DELETE http://localhost:3001/users/{userId}
	@DeleteMapping("/{userId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void findByIdAndDelete(@PathVariable UUID userId) {
		this.usersService.findByIdAndDelete(userId);
	}
}
