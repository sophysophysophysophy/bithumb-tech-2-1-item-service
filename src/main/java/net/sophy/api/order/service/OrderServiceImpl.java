package net.sophy.api.order.service;

import lombok.RequiredArgsConstructor;
import net.sophy.api.order.domain.Order;
import net.sophy.api.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service @RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(long id) {
        return orderRepository.findById(id);
    }

    @Override
    public boolean existById(long id) {
        return orderRepository.existsById(id);
    }

    @Override
    public int count() {
        return (int) orderRepository.count();
    }

    @Override
    public void save(Order entity) {
        orderRepository.save(entity);
    }

    @Override
    public void deleteById(long id) {
        orderRepository.deleteById(id);
    }


    @Override
    public void deleteAll() {
        orderRepository.deleteAll();
    }
}
