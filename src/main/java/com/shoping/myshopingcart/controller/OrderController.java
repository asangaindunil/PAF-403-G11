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

import com.shoping.myshopingcart.dao.OrderDAO;
import com.shoping.myshopingcart.model.Order;

@RestController
@RequestMapping("/shopping")
public class OrderController {

	@Autowired
	OrderDAO orderDAO;
	
	@PostMapping("/orders")
	public Order createOrder(@Valid @RequestBody Order order) {
		return orderDAO.save(order);
	}
	
	@GetMapping("/orders")
	public List<Order> getAllOrder(){
		return orderDAO.findAll();
		
	}
	
//	@GetMapping("/activeorders")
//	public List<Order> getActiveOrder(){
//	   return orderDAO.findActive();
//		
//	}
	
	@GetMapping("/orders/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable(value="id")long ord_id){
		Order order =orderDAO.findOne(ord_id);
		
		if(order==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(order);
	
	}
//	@GetMapping("/supplier/{id}/orders")
//	public List<Order> getOrderBySupplier(@PathVariable(value="id")int sup_id){
//	
//		return orderDAO.findSupplierOrders(sup_id);
//	
//	}
	@PutMapping("/orders/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable(value="id")long ord_id,@Valid @RequestBody Order orderDetails){
		Order order =orderDAO.findOne(ord_id);
		
		if(order==null) {
			return ResponseEntity.notFound().build();
		}
		order.setOrd_id(orderDetails.getOrd_id());
		order.setItem_id(orderDetails.getItem_id());
		order.setCus_id(orderDetails.getCus_id());		
		order.setTot_price(orderDetails.getTot_price());
		order.setTot_qty(orderDetails.getTot_qty());
		order.setDelivery_status(orderDetails.getDelivery_status());

		Order updateOrder = orderDAO.save(order);
		return ResponseEntity.ok().body(updateOrder);
	}
	@DeleteMapping("/orders/{id}")
	public ResponseEntity<Order> deleteOrder(@PathVariable(value="id")long order_id){
		Order order =orderDAO.findOne(order_id);
		
		if(order==null) {
			return ResponseEntity.notFound().build();
		}
		orderDAO.delete(order);
		return ResponseEntity.ok().body(order);
	
	}
}
