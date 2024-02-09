package org.jsp.shoppingkart.service;

import java.util.List;
import java.util.Optional;

import org.jsp.shoppingkart.dao.MerchantDao;
import org.jsp.shoppingkart.dao.ResponseStructure;
import org.jsp.shoppingkart.dto.Merchant;
import org.jsp.shoppingkart.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MerchanttService {

	@Autowired
	private MerchantDao merchantDao;

	public ResponseEntity<ResponseStructure<Merchant>> saveMerchant(Merchant merchant) {
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		structure.setMessage("Merchant Registred successfully");
		structure.setBody(merchantDao.saveMerchant(merchant));
		structure.setCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<Merchant>> updateMerchant(Merchant merchant) {
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		structure.setMessage("Merchant Updated sucessfully");
		structure.setBody(merchantDao.updateMerchant(merchant));
		structure.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<Merchant>> findMerchant(int id) {
		Optional<Merchant> recUser = merchantDao.findMerchant(id);
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		if (recUser.isPresent()) {
			structure.setBody(recUser.get());
			structure.setMessage("Merchant found sucessfully");
			structure.setCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.OK);

		}
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<List<Merchant>>> findAll() {
		ResponseStructure<List<Merchant>> structure = new ResponseStructure<>();

		structure.setMessage(" All Merchants found sucessfully");
		structure.setBody(merchantDao.findAll());
		structure.setCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Merchant>>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<String>> deleteMerchant(int id) {
		Optional<Merchant> recUser = merchantDao.findMerchant(id);
		ResponseStructure<String> structure = new ResponseStructure<>();
		if (recUser.isPresent()) {
			merchantDao.deleteMerchant(id);
			structure.setMessage("Merchant found sucessfully");
			structure.setBody("Merchant deleted");
			structure.setCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);

		}
		throw new IdNotFoundException();
	}

}
