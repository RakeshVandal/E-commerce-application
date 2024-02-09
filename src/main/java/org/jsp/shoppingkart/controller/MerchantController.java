package org.jsp.shoppingkart.controller;

import java.util.List;

import org.jsp.shoppingkart.dao.ResponseStructure;
import org.jsp.shoppingkart.dto.Merchant;
import org.jsp.shoppingkart.service.MerchanttService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MerchantController {
	@Autowired
	private MerchanttService service;

	@PostMapping("/admin")
	public ResponseEntity<ResponseStructure<Merchant>> saveMerchant(@RequestBody Merchant merchant) {
		return service.saveMerchant(merchant);
	}

	@PutMapping("/admin")
	public ResponseEntity<ResponseStructure<Merchant>> updateMerchant(@RequestBody Merchant merchant) {
		return service.updateMerchant(merchant);
	}

	@GetMapping("/admin/{id}")
	public ResponseEntity<ResponseStructure<Merchant>> findMerchant(@PathVariable int id) {
		return service.findMerchant(id);
	}

	@GetMapping("/admin")
	public ResponseEntity<ResponseStructure<List<Merchant>>> findAll() {
		return service.findAll();
	}

	@DeleteMapping("/admin/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteMerchant(@PathVariable int id) {
		return service.deleteMerchant(id);
	}

}
