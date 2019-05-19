package com.shoping.myshopingcart.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.shoping.myshopingcart.model.Order;
import com.shoping.myshopingcart.repostory.OrderRepository;

@Service
public class OrderDAO {

	@Autowired
	OrderRepository orderRepository;

	public Order save(Order order) {
		
		return orderRepository.save(order);
	}
	
	public List<Order> findAll(){
		return orderRepository.findAll();
	}
	
	
	public Order findOne(Long id) {
		return orderRepository.findOne(id);
	}


	public void delete(Order order) {
		 orderRepository.delete(order);
	}
	
}
