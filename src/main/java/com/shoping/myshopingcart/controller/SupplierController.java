package com.shoping.myshopingcart.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.hiras.paf.*;
import com.hiras.paf.dao.SupplierDAO;
import com.hiras.paf.model.Supplier;



public class SupplierController {
	
	@Autowired
	SupplierDAO SupplierDAO;
	
	/* to save an Supplier*/
	@PostMapping("/Suppliers")
	public Supplier createSupplier(@Valid @RequestBody Supplier sup) {
		return SupplierDAO.save(sup);
	}
	
	/*get all Suppliers*/
	@GetMapping("/Suppliers")
	public List<Supplier> getAllSuppliers(){
		return SupplierDAO.findAll();
	}
	
	/*get Supplier by supid*/
	@GetMapping("/Suppliers/{id}")
	public ResponseEntity<Supplier> getSupplierById(@PathVariable(value="id") Long supid){
		
		Supplier sup=SupplierDAO.findOne(supid);
		
		if(sup==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(sup);
		
	}
	
	
	/*update an Supplier by supid*/
	@PutMapping("/Suppliers/{id}")
	public ResponseEntity<Supplier> updateSupplier(@PathVariable(value="id") Long supid,@Valid @RequestBody Supplier supDetails){
		
		Supplier sup=SupplierDAO.findOne(supid);
		if(sup==null) {
			return ResponseEntity.notFound().build();
		}
		
		sup.setName(supDetails.getName());
		sup.setDesignation(supDetails.getDesignation());
		sup.setExpertise(supDetails.getExpertise());
		
		Supplier updateSupplier=SupplierDAO.save(sup);
		return ResponseEntity.ok().body(updateSupplier);
		
		
		
	}
	
	/*Delete an Supplier*/
	@DeleteMapping("/Suppliers/{id}")
	public ResponseEntity<Supplier> deleteSupplier(@PathVariable(value="id") Long supid){
		
		Supplier sup=SupplierDAO.findOne(supid);
		if(sup==null) {
			return ResponseEntity.notFound().build();
		}
		SupplierDAO.delete(sup);
		
		return ResponseEntity.ok().build();
		
		
	}
	
	

}
