package com.simplilearn.maricel.vdf.api;

import com.simplilearn.maricel.vdf.exceptions.OrderNotFoundException;
import com.simplilearn.maricel.vdf.exceptions.ProductOrOrderNotFoundException;
import com.simplilearn.maricel.vdf.model.Order;
import com.simplilearn.maricel.vdf.service.OrderService;
import com.simplilearn.maricel.vdf.service.OrderServiceImpl;
import com.simplilearn.maricel.vdf.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @GetMapping("/getAll")
    public List<Order> getOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/getById")
    public Order getOrderById(@RequestParam int id) throws OrderNotFoundException {
        return orderService.getOrderById(id);
    }

    @GetMapping("/getByCategory")
    public List<Order> getOrderByCategory(@RequestParam String category) {
        return orderService.getOrdersByCategory(category);
    }

    @GetMapping("/getByDate")
    public String getOrdersByDate() {
        return "TO DO";
    }

    @PostMapping("/add")
    public String placeOrder(@RequestParam int productId, Model model) throws ProductOrOrderNotFoundException {
        orderService.addOrder(productId);
        model.addAttribute("products", productService.getAllProducts());
       model.addAttribute("orders", orderService.getAllOrders());
       return "customer.html";
    }

    @PutMapping("/update")
    public Order updateOrder(@RequestParam int orderId,
                             @RequestParam int productId) throws OrderNotFoundException {
        return orderService.updateOrder(orderId, productId);
    }

    @DeleteMapping("/delete")
    public List<Order> deleteOrder(@RequestParam int id) throws OrderNotFoundException {
        return orderService.deleteOrder(id);
    }
}
