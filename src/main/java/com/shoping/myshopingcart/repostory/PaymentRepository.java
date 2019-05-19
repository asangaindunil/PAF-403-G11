package com.radishan.example.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.radishan.example.model.Payment;

public interface PaymentRepository  extends JpaRepository<Payment, Long> {

}
