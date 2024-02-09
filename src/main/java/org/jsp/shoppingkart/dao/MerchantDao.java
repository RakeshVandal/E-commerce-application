package org.jsp.shoppingkart.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.shoppingkart.dto.Merchant;
import org.jsp.shoppingkart.repositry.MerchantRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MerchantDao {
	@Autowired
	private MerchantRepositry repositry;
	
	public Merchant saveMerchant(Merchant merchant) {
		return repositry.save(merchant);
	}

	public Merchant updateMerchant(Merchant merchant) {
		return repositry.save(merchant);	
	}
	public Optional<Merchant> findMerchant(int id) {
		return repositry.findById(id);
	}
	public List<Merchant> findAll() {
		return repositry.findAll();
	}
	public void deleteMerchant( int id) {
		 repositry.deleteById(id);
	}
	public Optional<Merchant> verifyMerchant(long phone,String password){
		return repositry.verifyMerchant(phone, password);
	}
	public Optional<Merchant> verifMerchant(String email,String password){
		return repositry.verifyMerchant(email, password);
	}
	
}
