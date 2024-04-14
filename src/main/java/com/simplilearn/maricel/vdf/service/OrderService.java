package com.simplilearn.maricel.vdf.service;

import com.simplilearn.maricel.vdf.exceptions.OrderNotFoundException;
import com.simplilearn.maricel.vdf.exceptions.ProductNotFoundException;
import com.simplilearn.maricel.vdf.exceptions.ProductOrOrderNotFoundException;
import com.simplilearn.maricel.vdf.model.Order;
import com.simplilearn.maricel.vdf.model.Product;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(int id) throws OrderNotFoundException;
    List<Order> getOrdersByCategory(String category);
    List<Order> addOrder(int productId) throws ProductOrOrderNotFoundException;
    Order updateOrder(int orderId, int productId) throws OrderNotFoundException;
    List<Order> deleteOrder(int id) throws OrderNotFoundException;
}
