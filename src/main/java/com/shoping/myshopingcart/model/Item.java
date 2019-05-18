package com.shoping.myshopingcart.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="item")
@EntityListeners(AuditingEntityListener.class)
public class Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long item_id;
	
	public Long getItem_id() {
		return item_id;
	}

	public void setItem_id(Long item_id) {
		this.item_id = item_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getSup_id() {
		return sup_id;
	}

	public void setSup_id(Long sup_id) {
		this.sup_id = sup_id;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public float getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(float unit_price) {
		this.unit_price = unit_price;
	}

	public String getItem_pic() {
		return item_pic;
	}

	public void setItem_pic(String item_pic) {
		this.item_pic = item_pic;
	}

	public int getVisibility() {
		return visibility;
	}

	public void setVisibility(int visibility) {
		this.visibility = visibility;
	}

	@NotBlank
	private String name;
	
	@NotBlank
	private String description;
	
	private Long sup_id;
	
	private int qty;
	
	private float unit_price;
	
	@NotBlank
	private String item_pic;


	private int visibility;
	
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private java.util.Date created_at;

	public java.util.Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(java.util.Date created_at) {
		this.created_at = created_at;
	}

}
