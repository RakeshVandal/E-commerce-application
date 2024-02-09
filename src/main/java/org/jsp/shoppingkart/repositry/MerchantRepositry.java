package org.jsp.shoppingkart.repositry;

import java.util.Optional;

import org.jsp.shoppingkart.dto.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MerchantRepositry extends JpaRepository<Merchant, Integer>{
	@Query("select m from Merchant m where m.phone=?1 and m.password=?2")
	public Optional<Merchant> verifyMerchant(long phone,String password);
	
	@Query("select m from Merchant m where m.email=?1 and m.password=?2")
	public Optional<Merchant> verifyMerchant(String email,String password);
}
