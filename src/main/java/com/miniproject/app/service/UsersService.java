package com.miniproject.app.service;

import java.util.List;

import com.miniproject.app.model.Users;

public interface UsersService {

	public List<Users> findUsersAllByStatus(String status);
	public void saveOrUpdate(Users users);
	public Users findUserById(int id);
	public void deleteUserById(int id);
	public Users findByUserNameAndStatus(String userName, String status);
}
