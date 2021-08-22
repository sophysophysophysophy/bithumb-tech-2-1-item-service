package net.sophy.api.item.controller;

import lombok.RequiredArgsConstructor;
import net.sophy.api.item.domain.Item;
import net.sophy.api.item.service.ItemService;
import net.sophy.api.item.service.ItemServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;

    @GetMapping("/{id}")
    public Optional<Item> findById(@PathVariable long id) {
        return itemService.findById(id);
    }

    @GetMapping("/count")
    public int count() {
        return itemService.count();
    }

    @GetMapping("/exists")
    public boolean existById(@PathVariable long id) {
        return itemService.existById(id);
    }



    public List<Item> findAll() {
        return itemService.findAll();
    }

    @PutMapping
    public void update(@RequestBody Item item) {
        itemService.save(item);
    }

    @PostMapping
    public void save(@RequestBody Item entity) {
        itemService.save(entity);
    }

    @DeleteMapping("/{id}")
    public void deleteById(long id) {
        itemService.deleteById(id);
    }

    @DeleteMapping
    public void deleteAll() {
        itemService.deleteAll();
    }



}
