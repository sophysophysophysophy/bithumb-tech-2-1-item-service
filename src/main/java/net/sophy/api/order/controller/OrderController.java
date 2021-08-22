package net.sophy.api.order.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import net.sophy.api.order.domain.Order;
import net.sophy.api.order.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;


    public List<Order> findAll() {
        return orderService.findAll();
    }

    @GetMapping("~/{id}")
    public Optional<Order> findById(long id) {
        return orderService.findById(id);
    }

    @GetMapping("~/exists/{id}")
    public boolean existById(long id) {
        return orderService.existById(id);
    }

    @GetMapping("~/count")
    public int count() {
        return (int) orderService.count();
    }

    public void save(Order entity) {
        orderService.save(entity);
    }

    public void deleteById(long id) {
        orderService.deleteById(id);
    }

    public void deleteAll() {
        orderService.deleteAll();
    }
}
