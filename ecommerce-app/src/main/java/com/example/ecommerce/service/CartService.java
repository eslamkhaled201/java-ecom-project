package com.example.ecommerce.service;

import com.example.ecommerce.model.Product;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    private final List<Product> cart = new ArrayList<>();

    public List<Product> getCart() { return cart; }
    public void add(Product product) { cart.add(product); }
    public void remove(Long id) { cart.removeIf(p -> p.getId().equals(id)); }
    public void clear() { cart.clear(); }
}