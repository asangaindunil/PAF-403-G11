package com.shoping.myshopingcart.model;

import java.sql.Date;

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
@Table(name="rating")
@EntityListeners(AuditingEntityListener.class)
public class Rating {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long rating_id;

	public Long getRating_id() {
		return rating_id;
	}
	public void setRating_id(Long rating_id) {
		this.rating_id = rating_id;
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	@NotNull
	private Long item_id;
	@NotNull
	private Long cus_id;
	@NotBlank
	private String comment;
	
//	@Temporal(TemporalType.TIMESTAMP)
//	@LastModifiedDate
	private Date date;
	@NotNull
	private int rate;
	
	

}
