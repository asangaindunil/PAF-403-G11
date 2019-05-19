package com.radishan.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.radishan.example.model.Payment;
import com.radishan.example.repository.PaymentRepository;



@Service
public class PaymentDAO {
	@Autowired
	PaymentRepository paymentRepository;
	
	/*to save ratings*/
	
	public Payment save(Payment pay) {
		return paymentRepository.save(pay);
	}
	
	/*search all ratings*/
	public List<Payment> findAll(){
		return paymentRepository.findAll();
		}
	
	
public Payment findOne(Long payid) {
	return paymentRepository.findOne(payid);
	
}
	 
	
	/*delete a rating*/
public void delete(Payment pay) {
	paymentRepository.delete(pay);
}
}
