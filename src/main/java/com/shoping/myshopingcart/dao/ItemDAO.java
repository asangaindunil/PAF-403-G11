package com.shoping.myshopingcart.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.shoping.myshopingcart.model.Item;
import com.shoping.myshopingcart.repostory.ItemRepository;

@Service
public class ItemDAO {

	@Autowired
	ItemRepository itemRepository;

	public Item save(Item item) {
		
		return itemRepository.save(item);
	}
	
	public List<Item> findAll(){
		return itemRepository.findAll();
	}
	
	
	public Item findOne(Long id) {
		return itemRepository.findOne(id);
	}
	
	public  List<Item>  findSupplierItems(int id) {
		return itemRepository.findItembySupplier(id);
	}
	
	public List<Item> findActive() {
		return itemRepository.findActiveItems();
	}

	public void delete(Item item) {
		 itemRepository.delete(item);
	}
	
}
