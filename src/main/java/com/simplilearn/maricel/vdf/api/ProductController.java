package com.simplilearn.maricel.vdf.api;

import com.simplilearn.maricel.vdf.exceptions.ProductNotFoundException;
import com.simplilearn.maricel.vdf.model.Product;
import com.simplilearn.maricel.vdf.service.OrderService;
import com.simplilearn.maricel.vdf.service.ProductService;
import com.simplilearn.maricel.vdf.service.ProductServiceImpl;
import com.simplilearn.maricel.vdf.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    public String getAllProducts(Model model) {
        model.addAttribute("products",productService.getAllProducts());
        model.addAttribute("orders", orderService.getAllOrders());
        return "customer.html";
    }
    @GetMapping("/getAllAdminPage")
    public String getAllProductsAdmin(Model model) {
        model.addAttribute("products",productService.getAllProducts());
        model.addAttribute("orders", orderService.getAllOrders());
        model.addAttribute("users", userService.getAllUsers());
        return "admin.html";
    }

    @GetMapping("/getById")
    public Product getProductById(@RequestParam int id) throws ProductNotFoundException {
        return productService.getProductById(id);
    }

    @GetMapping("/getAllByCategory")
    public String getProductsByCategory(@RequestParam String categoryToShow, Model model) {
        model.addAttribute("products", productService.getProductsByCategory(categoryToShow));
        model.addAttribute("orders", orderService.getAllOrders());
        return "admin.html";
    }

    @GetMapping("/getAllByCategoryCustomer")
    public String getProductsByCategoryCustomer(@RequestParam String categoryToShow, Model model) {
        model.addAttribute("products", productService.getProductsByCategory(categoryToShow));
        model.addAttribute("orders", orderService.getAllOrders());
        model.addAttribute("users", userService.getAllUsers());
        return "customer.html";
    }

    @PostMapping("/add")
    public String saveProduct(@RequestParam String productName,
            @RequestParam float price,
            @RequestParam int quantity,
            @RequestParam String category,
                              Model model) throws ProductNotFoundException {
        Product product = new Product();
        product.setProductName(productName);
        product.setCategory(category);
        product.setPrice(price);
        product.setQuantity(quantity);
        productService.addProduct(product);
        model.addAttribute("products",productService.getAllProducts());
        model.addAttribute("orders", orderService.getAllOrders());
        model.addAttribute("users", userService.getAllUsers());
        return "admin";
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestParam int id, @RequestBody Product product) throws ProductNotFoundException {
        return productService.updateProduct(id, product);
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam int productId, Model model) throws ProductNotFoundException {
        productService.deleteProduct(productId);
        model.addAttribute("products",productService.getAllProducts());
        model.addAttribute("orders", orderService.getAllOrders());
        model.addAttribute("users", userService.getAllUsers());
        return "admin";
    }
}
