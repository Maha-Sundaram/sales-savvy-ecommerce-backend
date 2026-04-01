package com.salessavvy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salessavvy.entity.Orders;
import com.salessavvy.entity.User;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {

	List<Orders> findByUser(User user);

}
