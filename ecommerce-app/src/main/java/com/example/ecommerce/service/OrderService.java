package com.example.ecommerce.service;

import com.example.ecommerce.model.Order;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.User;
import com.example.ecommerce.repository.OrderRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository repo;
    public OrderService(OrderRepository repo) { this.repo = repo; }

    public Order checkout(List<Product> cart, User user) {
        Order order = new Order();
        order.setUser(user);
        order.setProducts(cart);
        order.setOrderDate(LocalDateTime.now());
        double total = cart.stream().mapToDouble(p -> p.getPrice().doubleValue()).sum();
        order.setTotal(total);
        return repo.save(order);
    }
}