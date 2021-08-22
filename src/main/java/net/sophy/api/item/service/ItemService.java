package net.sophy.api.item.service;

import net.sophy.api.item.domain.Item;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ItemService {
    List<Item> findAll();
//    Item getById(long id);
    Optional<Item> findById(long id);
    boolean existById(long id);
    int count();
    void save(Item entity);
    void deleteById(long id);
    void deleteAll();
}
