package com.shoping.myshopingcart.dao;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiras.paf.model.*;
import com.hiras.paf.repository.SupplierRepository;

@Service
public class SupplierDAO {
	
	@Autowired
	SupplierRepository SupplierRepository;
	
	/*to save an Supplier*/
	
	public Supplier save(Supplier sup) {
		return SupplierRepository.save(sup);
	}
	
	
	/* search all Suppliers*/
	
	public List<Supplier> findAll(){
		return SupplierRepository.findAll();
	}
	
	
	/*get an Supplier by id*/
	public Supplier findOne(Long supid) {
		return SupplierRepository.findOne(supid);
	}
	
	
	/*delete an Supplier*/
	
	public void delete(Supplier sup) {
		SupplierRepository.delete(sup);
	}
	

}
