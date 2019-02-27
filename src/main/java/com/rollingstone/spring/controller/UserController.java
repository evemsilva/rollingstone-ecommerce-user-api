package com.rollingstone.spring.controller;

import com.rollingstone.events.UserEvent;
import com.rollingstone.exceptions.HTTP404Exception;
import com.rollingstone.spring.model.User;
import com.rollingstone.spring.service.UserService;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController
		extends AbstractController {

    private final UserService userService;

    public UserController(UserService userService) {
	this.userService = userService;
    }

    /*---Add new User---*/
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
	User savedUser = userService.save(user);
	UserEvent categoryCreatedEvent = new UserEvent(this,"UserCreatedEvent", user);
	eventPublisher.publishEvent(categoryCreatedEvent);
	return ResponseEntity.ok().body("New user has been saved with ID:" + savedUser.getId());
    }

    /*---Get a User by id---*/
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") long id) {
	Optional<User> returnedUser = userService.get(id);
	User user = returnedUser.orElseThrow(() -> new HTTP404Exception("Resource Not Found"));

	UserEvent retrievedCreatedEvent = new UserEvent(this,"UserRetrievedEvent", user);
	eventPublisher.publishEvent(retrievedCreatedEvent);
	return ResponseEntity.ok().body(user);
    }

    /*---get all User---*/
    @GetMapping
    public @ResponseBody
    Page<User> getUsersByPage(@RequestParam(value = "pagenumber", defaultValue = DEFAULT_PAGE_NUMBER) Integer pageNumber,
				    @RequestParam(value = "pagesize", defaultValue = DEFAULT_PAGE_SIZE) Integer pageSize) {
	return userService.getUsersByPage(pageNumber, pageSize);
    }

    /*---Update a User by id---*/
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody User category) {
	checkResourceFound(this.userService.get(id));
	userService.update(id, category);
	return ResponseEntity.ok().body("User has been updated successfully.");
    }

    /*---Delete a User by id---*/
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
	checkResourceFound(this.userService.get(id));
	userService.delete(id);
	return ResponseEntity.ok().body("User has been deleted successfully.");
    }
}