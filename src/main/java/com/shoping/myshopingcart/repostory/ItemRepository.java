package com.shoping.myshopingcart.repostory;
import com.shoping.myshopingcart.model.Item;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface ItemRepository extends JpaRepository<Item, Long> { 

	@Query(value="select i.* from item i where i.visibility =1",nativeQuery=true)
	List<Item> findActiveItems();
	
	@Query(value="select i.* from item i where i.sup_id =?1",nativeQuery=true)
	List<Item> findItembySupplier(int sup_id);
}
	