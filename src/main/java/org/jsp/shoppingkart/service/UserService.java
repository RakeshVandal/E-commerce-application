package org.jsp.shoppingkart.service;

import java.util.List;
import java.util.Optional;

import org.jsp.shoppingkart.dao.ResponseStructure;
import org.jsp.shoppingkart.dao.UserDao;
import org.jsp.shoppingkart.dto.User;
import org.jsp.shoppingkart.exception.IdNotFoundException;
import org.jsp.shoppingkart.exception.InValidCredentialException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class UserService {
	@Autowired
	private UserDao dao;

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		structure.setMessage("User Registred sucessfully");
		structure.setBody(dao.saveUser(user));
		structure.setCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<User>> updateUser(User user) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		structure.setMessage("User Updated sucessfully");
		structure.setBody(dao.updateUser(user));
		structure.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<User>> findUser(int id) {
		Optional<User> recUser = dao.findUser(id);
		ResponseStructure<User> structure = new ResponseStructure<>();
		if (recUser.isPresent()) {
			structure.setBody(recUser.get());
			structure.setMessage("User found sucessfully");
			structure.setCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);

		}
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<List<User>>> findAll() {
		ResponseStructure<List<User>> structure=new ResponseStructure<>();
		 
		structure.setMessage(" All Users found sucessfully");
		structure.setBody( dao.findAll());
		structure.setCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<User>>>(structure,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<String>> deleteUser(int id) {
		Optional<User> recUser = dao.findUser(id);
		ResponseStructure<String> structure = new ResponseStructure<>();
		if (recUser.isPresent()) {
			dao.deleteUser(id);
			structure.setMessage("User found sucessfully");
			structure.setBody("User deleted");
			structure.setCode(HttpStatus.OK.value());
			return  new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.OK);

		}
		throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<User>> verifyUser(long phone,String password){
	
		ResponseStructure<User> structure = new ResponseStructure<>();
		Optional<User> recUser = dao.verifyUser(phone,password);
		if (recUser.isPresent()) {
			
			structure.setMessage("User verified sucessfully");
			structure.setBody(recUser.get());
			structure.setCode(HttpStatus.OK.value());
			return  new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);

		}
		throw new InValidCredentialException();
	}
	public ResponseEntity<ResponseStructure<User>> verifyUser(String email,String password){
		
		ResponseStructure<User> structure = new ResponseStructure<>();
		Optional<User> recUser = dao.verifyUser(email,password);
		if (recUser.isPresent()) {
			
			structure.setMessage("User verified sucessfully");
			structure.setBody(recUser.get());
			structure.setCode(HttpStatus.OK.value());
			return  new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);

		}
		throw new InValidCredentialException();
	}
}
