package com.Api.order;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderPOJO, Integer> {
    OrderPOJO findByCurrency(String currency);
}