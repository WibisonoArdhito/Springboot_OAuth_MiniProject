package com.miniproject.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.miniproject.app.model.Users;
import com.miniproject.app.repository.UsersRepository;

public class UsersServiceImpl implements UsersService{
	
	@Autowired
	private UsersRepository repository;

	@Override
	public List<Users> findUsersAllByStatus(String status) {
		return repository.findAllByStatus(status);
	}

	@Override
	public void saveOrUpdate(Users users) {
		repository.save(users);
	}

	@Override
	public Users findUserById(int id) {
		return repository.findById(id);
	}

	@Override
	public void deleteUserById(int id) {
		repository.deleteById(id);	
	}

	@Override
	public Users findByUserNameAndStatus(String userName, String status) {
		return repository.findByUserNameAndStatus(userName, status);
	}

}
