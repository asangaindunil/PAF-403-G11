package com.shoping.myshopingcart.repostory;
import com.shoping.myshopingcart.model.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


public interface OrderRepository extends JpaRepository<Order, Long> { 


}
	