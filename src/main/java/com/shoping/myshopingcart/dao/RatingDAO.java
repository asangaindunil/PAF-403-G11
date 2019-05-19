package com.shoping.myshopingcart.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoping.myshopingcart.model.Rating;
import com.shoping.myshopingcart.repostory.RatingRepository;




@Service
public class RatingDAO {
	@Autowired
	RatingRepository ratingRepository;
	
	/*to save ratings*/
	
	public Rating save(Rating rat) {
		return ratingRepository.save(rat);
	}
	
	/*search all ratings*/
	public List<Rating> findAll(){
		return ratingRepository.findAll();
		}
	
	
public Rating findOne(Long ratid) {
	return ratingRepository.findOne(ratid);
	
}
	 
	
	/*delete a rating*/
public void delete(Rating rat) {
	ratingRepository.delete(rat);
}

}
