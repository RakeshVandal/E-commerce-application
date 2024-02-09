package org.jsp.shoppingkart.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.shoppingkart.dto.User;
import org.jsp.shoppingkart.repositry.UserRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class UserDao {
	@Autowired
	private UserRepositry repositry;

	public User saveUser(User user) {
		return repositry.save(user);
	}

	public User updateUser(User user) {
		return repositry.save(user);	
	}

	public Optional<User> findUser(int id) {
		return repositry.findById(id);
	}

	public List<User> findAll() {
		return repositry.findAll();
	}

	
	public void deleteUser( int id) {
		 repositry.deleteById(id);
	}
	public Optional<User> verifyUser(long phone,String password){
		return repositry.verifyUser(phone, password);
	}
	public Optional<User> verifyUser(String email,String password){
		return repositry.verifyUser(email, password);
	}
}

