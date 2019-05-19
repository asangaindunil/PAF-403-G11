package com.radishan.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.radishan.example.dao.PaymentDAO;
import com.radishan.example.model.Payment;





@RestController
@RequestMapping("/company")
public class PaymentController {
	PaymentDAO paymentDAO;
	
	/*Save rating in to db*/
	@PostMapping("/payment")
	public Payment createRating(@Valid @RequestBody Payment pay) {
		return paymentDAO.save(pay);
	}
	
	/*GET ALL payments*/
	@GetMapping("/payment")
	public List<Payment>getAllPayments(){
		return paymentDAO.findAll();
	}
/*get payments by a pay id*/
	@GetMapping("/notes/{id}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable(value="id") Long payid){
		Payment pay=paymentDAO.findOne(payid);
		if(pay==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(pay);
		}
	
	
/*update an payments by payid*/
@PutMapping("/payment/{id}")
public ResponseEntity<Payment> UpdatePayment(@PathVariable(value="id")Long payid,@Valid @RequestBody Payment paymentDetails ){
	Payment pay=paymentDAO.findOne(payid);
	if(pay==null) {
		return ResponseEntity.notFound().build();
	}
	
	pay.setCus_id(paymentDetails.getCus_id());
	pay.setOrder_id(paymentDetails.getOrder_id());
	pay.setPay_type(paymentDetails.getPay_type());
	

	
	
	
     Payment UpdatePayment=paymentDAO.save(pay);
	return ResponseEntity.ok().body(UpdatePayment);
}

/*delete payment*/
@DeleteMapping("/payment/{id}")
public ResponseEntity<Payment> deletePayment(@PathVariable(value="id") Long payid){
	
	Payment pay=paymentDAO.findOne(payid);
	if(pay==null) {
		return ResponseEntity.notFound().build();
	}
	paymentDAO.delete(pay);
	
	return ResponseEntity.ok().build();
	
	
}

}
