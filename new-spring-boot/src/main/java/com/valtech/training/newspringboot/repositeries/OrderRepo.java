package com.valtech.training.newspringboot.repositeries;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.valtech.training.newspringboot.entity.Order;

public interface OrderRepo extends JpaRepository<Order, Long> {
	@Query(value="SELECT o FROM Order o where o.itemCount=?1")
	
	List<Order> findAllByItemCount(int itemCount);

	List<Order> findAllByItemCountGreaterThan(int itemCount);

	List<Order> findAllByItemAndItemCount(String item, int itemCount);

	int countByItem(String item);
}
