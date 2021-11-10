package com.miniproject.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miniproject.app.model.Users;
import com.miniproject.app.service.UsersService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value="users", description="APIs to modify users data")
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	@GetMapping("/user")
	@ApiOperation(value = "View a list of active users",response = Object.class)
	public Object getAllUserActive(@RequestHeader HttpHeaders requestHeader) {
		List<Users> listUsers = usersService.findUsersAllByStatus("ACTIVE");
		if (listUsers == null || listUsers.isEmpty()) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return listUsers;
	}
	
	@GetMapping("/userNotActive")
	@ApiOperation(value = "View a list of non-active users",response = Object.class)
	public Object getAllUserNotActive(@RequestHeader HttpHeaders requestHeader) {
		List<Users> listUsers = usersService.findUsersAllByStatus("NON-ACTIVE");
		if (listUsers == null || listUsers.isEmpty()) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return listUsers;
	}
	
	@PostMapping("/addUser") 
	@ApiOperation(value = "Add User")
	public ResponseEntity<String> addUser(@RequestBody Users users) {
    usersService.saveOrUpdate(users);
    return new ResponseEntity<>("SUCCESS", HttpStatus.OK); 
    }

	@DeleteMapping("/user/{id}")
	@ApiOperation(value = "Delete user by userId")
	public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
		usersService.deleteUserById(id);
		return new ResponseEntity<>("SUCCESS", HttpStatus.OK); 
	}

	@GetMapping("/user/{id}")
	@ApiOperation(value = "Get user detail user by userId")
	public ResponseEntity<Users> getUserById(@PathVariable Integer id) {
		Users users = usersService.findUserById(id);
		if (users == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

}
