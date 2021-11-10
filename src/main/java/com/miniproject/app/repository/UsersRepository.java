package com.miniproject.app.repository;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.miniproject.app.model.Users;

@Repository
@Transactional
public interface UsersRepository extends CrudRepository<Users, String>{

	public List<Users> findAllByStatus(String status);
	
	public Users findByUserNameAndStatus(String userName, String status);

	public Users findById(Integer id);

	@Override
	public Users save(Users users);

	public void deleteById(Integer id);
}
