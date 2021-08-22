package net.sophy.api.item.service;

import lombok.RequiredArgsConstructor;
import net.sophy.api.item.domain.Item;
import net.sophy.api.item.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service @RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {       //control + i
    private final ItemRepository itemRepository;

//    autowired : spring context내에 있는 객체 가져오는 것. 이제 쓰지 않음
//    생성자 주입 : 이 객체가 나름대로 가지고 있음 . (?)


//    repository와 service는 같은 아이템을 공유하기 때문에 응집력 높음.
//   타 entity와는 낮은 결합도

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public Optional<Item> findById(long id) {
        return itemRepository.findById(id);
    }

    @Override
    public boolean existById(long id) {
        return itemRepository.existsById(id);
    }

    @Override
    public int count() {
        return (int) itemRepository.count();
    }

    @Override
    public void save(Item entity) {
        itemRepository.save(entity);
    }

    @Override
    public void deleteById(long id) {
        itemRepository.deleteById(id);
    }


    @Override
    public void deleteAll() {
        itemRepository.deleteAll();
    }
}
