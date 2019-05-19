package com.shoping.myshopingcart.repostory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoping.myshopingcart.model.Rating;

public interface RatingRepository  extends JpaRepository<Rating, Long> {

}
