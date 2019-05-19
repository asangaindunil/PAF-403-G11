
package com.shoping.myshopingcart.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="orders")
@EntityListeners(AuditingEntityListener.class)
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long ord_id;

	public Long getOrd_id() {
		return ord_id;
	}

	public void setOrd_id(Long ord_id) {
		this.ord_id = ord_id;
	}

	public Long getItem_id() {
		return item_id;
	}

	public void setItem_id(Long item_id) {
		this.item_id = item_id;
	}

	public Long getCus_id() {
		return cus_id;
	}

	public void setCus_id(Long cus_id) {
		this.cus_id = cus_id;
	}

	public int getTot_qty() {
		return tot_qty;
	}

	public void setTot_qty(int tot_qty) {
		this.tot_qty = tot_qty;
	}

	public float getTot_price() {
		return tot_price;
	}

	public void setTot_price(float tot_price) {
		this.tot_price = tot_price;
	}

	public int getDelivery_status() {
		return delivery_status;
	}

	public void setDelivery_status(int delivery_status) {
		this.delivery_status = delivery_status;
	}

	public java.util.Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(java.util.Date created_at) {
		this.created_at = created_at;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@NotNull
	private Long item_id;
	
	@NotNull
	private Long cus_id;
	
	@NotNull
	private int tot_qty;
	
	@NotNull
	private float tot_price;

	private String remark;


	@NotNull
	private int delivery_status;
	
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private java.util.Date created_at;

}
