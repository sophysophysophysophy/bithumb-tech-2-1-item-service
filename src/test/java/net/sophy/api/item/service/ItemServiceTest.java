package net.sophy.api.item.service;

import net.sophy.api.item.domain.Item;
import net.sophy.api.item.repository.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.verify;
import java.util.List;
import static org.mockito.BDDMockito.given;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ItemServiceTest {
    @MockBean private ItemServiceImpl itemService;
    @MockBean private ItemRepository itemRepository;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        itemService = new ItemServiceImpl(itemRepository);
    }

    @Test
    void findAll() {
        Item item = Item.builder()
                .itemBrand("Apple")
                .itemName("iPhone")
                .itemColor("White")
                .build();
        assertThat(item.getItemName(), is(equalTo("iPhone")));
        itemService.save(item);
        verify(itemRepository).save(item);
    }

    @Test
    void findById() {
    }

    @Test
    void existById() {
    }

    @Test
    void count() {
    }

    @Test
    void save() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void deleteAll() {
    }
}