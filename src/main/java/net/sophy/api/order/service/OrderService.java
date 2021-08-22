package net.sophy.api.order.service;

import net.sophy.api.order.domain.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface OrderService {
    List<Order> findAll();
    //    Item getById(long id);
    Optional<Order> findById(long id);
    boolean existById(long id);
    int count();
    void save(Order entity);
    void deleteById(long id);
    void deleteAll();
}
