package com.Api.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    // Get All Notes
    @GetMapping("/orders")
    public List<OrderPOJO> getAllNotes() {
        return orderRepository.findAll();
    }

    @GetMapping("/order/{id}")
    public OrderPOJO getNoteById(@PathVariable(value = "id") Integer id) throws OrderControllerNotFoundException {
        return orderRepository.findById(id).orElseThrow(() -> new OrderControllerNotFoundException(id));
    }

    @DeleteMapping("/order/{id}")
    public Boolean deleteOrder(@PathVariable(value = "id") Integer productId) throws OrderControllerNotFoundException {
        OrderPOJO order = orderRepository.findById(productId)
                .orElseThrow(() -> new OrderControllerNotFoundException(productId));

        orderRepository.delete(order);
        return true;
    }

    @PostMapping("/order")
    public OrderPOJO createNote(@RequestBody OrderPOJO product) {
        return orderRepository.save(product);
    }

    @PutMapping("/order/{id}")
    public OrderPOJO updateNote(@PathVariable(value = "id") Integer orderId,
                                @RequestBody OrderPOJO newOrder) throws OrderControllerNotFoundException {

        OrderPOJO oldOrder = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderControllerNotFoundException(orderId));
        return oldOrder;
    }
}