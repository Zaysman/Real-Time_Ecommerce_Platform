package com.isaiah.usermicroservice.repository;

import com.isaiah.usermicroservice.object.User;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	//Save or update user
	<S extends User> S save (S User);
	
	//Read operations
	Optional<User> findByid(long id);
	Optional<User> findByusername(String username);
	Optional<User> findByemail(String email);
	List<User> findAll();
	
	//Delete operations
	void deleteByid(long id);
	void deleteByUsername(String username);
	void delete(User user);
	
	
}
