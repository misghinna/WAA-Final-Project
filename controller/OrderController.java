package miu.main.controller;


import miu.main.domain.Order;
import miu.main.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrder();
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrderById(@RequestParam("id") long id) {
        return orderService.getOrderByID(id);
    }

    @PostMapping("/")
    private void placeOrder(@RequestBody Order order) {
        orderService.create(order);
    }

    @PatchMapping("/{id}")
    private void updateOrder(@RequestBody Order order, @PathVariable long id) {
        orderService.Update(order, id);
    }

    @GetMapping("/buyers/{id}")
    public List<Order> getOrdersByBuyerId(@PathVariable("id") long id) {
        return orderService.getOrdersByBuyerID(id);
    }
}
