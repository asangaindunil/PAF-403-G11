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
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoping.myshopingcart.dao.ItemDAO;
import com.shoping.myshopingcart.model.Item;

@RestController
@RequestMapping("/shopping")
public class ItemController {

	@Autowired
	ItemDAO itemDAO;
	
	@PostMapping("/items")
	public Item createItem(@Valid @RequestBody Item item) {
		return itemDAO.save(item);
	}
	
	@GetMapping("/items")
	public List<Item> getAllItem(){
		return itemDAO.findAll();
		
	}
	
	@GetMapping("/activeitems")
	public List<Item> getActiveItem(){
	   return itemDAO.findActive();
		
	}
	
	@GetMapping("/items/{id}")
	public ResponseEntity<Item> getItemById(@PathVariable(value="id")long item_id){
		Item item =itemDAO.findOne(item_id);
		
		if(item==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(item);
	
	}
	@GetMapping("/supplier/{id}/items")
	public List<Item> getItemBySupplier(@PathVariable(value="id")int sup_id){
	
		return itemDAO.findSupplierItems(sup_id);
	
	}
	@PutMapping("/items/{id}")
	public ResponseEntity<Item> getItemById(@PathVariable(value="id")long item_id,@Valid @RequestBody Item itemDetails){
		Item item =itemDAO.findOne(item_id);
		
		if(item==null) {
			return ResponseEntity.notFound().build();
		}
		item.setName(itemDetails.getName());
		item.setDescription(itemDetails.getDescription());
		item.setQty(itemDetails.getQty());		
		item.setUnit_price(itemDetails.getUnit_price());
		item.setSup_id(itemDetails.getSup_id());
		item.setVisibility(itemDetails.getVisibility());
		item.setItem_pic(itemDetails.getItem_pic());

		Item updateItem = itemDAO.save(item);
		return ResponseEntity.ok().body(updateItem);
	}
	@DeleteMapping("/items/{id}")
	public ResponseEntity<Item> deleteItem(@PathVariable(value="id")long item_id){
		Item item =itemDAO.findOne(item_id);
		
		if(item==null) {
			return ResponseEntity.notFound().build();
		}
		itemDAO.delete(item);
		return ResponseEntity.ok().body(item);
	
	}
}
