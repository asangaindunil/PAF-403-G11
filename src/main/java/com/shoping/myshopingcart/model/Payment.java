package com.radishan.example.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="payment")
@EntityListeners(AuditingEntityListener.class)
public class Payment {
     
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long pay_id;
	@NotNull
	private Long cus_id;
	@NotBlank
	private String pay_type;
	@NotNull
	private Long order_id;
	@NotNull
	private Long postal_code;
	@NotBlank
	private String province;
	@NotBlank
	private String city;
	@NotBlank
	private String address;
	public Long getPay_id() {
		return pay_id;
	}
	public void setPay_id(Long pay_id) {
		this.pay_id = pay_id;
	}
	public Long getCus_id() {
		return cus_id;
	}
	public void setCus_id(Long cus_id) {
		this.cus_id = cus_id;
	}
	public String getPay_type() {
		return pay_type;
	}
	public void setPay_type(String pay_type) {
		this.pay_type = pay_type;
	}
	public Long getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}
	public Long getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(Long postal_code) {
		this.postal_code = postal_code;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	

}
