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
import org.springframework.web.bind.annotation.RestController;

import com.shoping.myshopingcart.dao.RatingDAO;
import com.shoping.myshopingcart.model.Rating;





@RestController
@RequestMapping("/shopping")
public class RatingController {
	
	
	@Autowired
	RatingDAO ratingDAO;
	
	/*Save rating in to db*/
	@PostMapping("/rating")
	public Rating createRating(@Valid @RequestBody Rating rat) {
		return ratingDAO.save(rat);
	}
	
	/*GET ALL ratings*/
	@GetMapping("/rating")
	public List<Rating> getAllRatings(){
		return ratingDAO.findAll();
	}
/*get employee by a rat id*/
	@GetMapping("/rating/{id}")
	public ResponseEntity<Rating> getRatingById(@PathVariable(value="id") Long ratid){
		Rating rat=ratingDAO.findOne(ratid);
		if(rat==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(rat);
		}
	
	
/*update an rating by ratid*/
@PutMapping("/rating/{id}")
public ResponseEntity<Rating> UpdateRating(@PathVariable(value="id")Long ratid,@Valid @RequestBody Rating ratingDetails ){
	Rating rat=ratingDAO.findOne(ratid);
	if(rat==null) {
		return ResponseEntity.notFound().build();
	}
	
	rat.setComment(ratingDetails.getComment());
	
	
	rat.setItem_id(ratingDetails.getItem_id());
	rat.setRate(ratingDetails.getRate());
	
	Rating UpdateRating=ratingDAO.save(rat);
	return ResponseEntity.ok().body(UpdateRating);
}

/*delete rating*/
@DeleteMapping("/rating/{id}")
public ResponseEntity<Rating> deleteRating(@PathVariable(value="id") Long ratid){
	
	Rating rat=ratingDAO.findOne(ratid);
	if(rat==null) {
		return ResponseEntity.notFound().build();
	}
	ratingDAO.delete(rat);
	
	return ResponseEntity.ok().build();
	
	
}
}
