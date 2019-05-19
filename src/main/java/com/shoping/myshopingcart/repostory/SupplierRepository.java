package com.shoping.myshopingcart.repostory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hiras.paf.model.Supplier;


public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}