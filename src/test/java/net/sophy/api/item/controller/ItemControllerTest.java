package net.sophy.api.item.controller;

import net.sophy.api.item.service.ItemService;
import net.sophy.api.security.domain.SecurityProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// controller - service - repository 연결 문제 없는지 확인하는 test
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = ItemController.class)
@DisplayName("ItemController Test")
class ItemControllerTest {
    @Autowired private MockMvc mockMvc;
    @MockBean private ItemService itemService;



//    @BeforeEach
//    void setUp() {
//        mockMvc = MockMvcBuilders.standaloneSetup(
//                new ItemController(itemService)
//        ).addFilters(new CharacterEncodingFilter("UTF-8", true)).build();
//    }

    @Test @DisplayName("Connect Test")
    void connect() throws Exception {
        String success = "success";
        mockMvc.perform(get("/items/connect"))
                .andExpect(status().isOk())
                .andExpect(content().string(success));
    }

    @Test @DisplayName("Find By Id Test")
    void findById() throws Exception {
        String itemBrand = "Galaxy";
        String itemName = "Flip";
        String itemColor = "White";
        mockMvc.perform(get("/items")
                .param("itemBrand", itemBrand)
                .param("itemName", itemName)
                .param("itemColor", itemColor))
                .andExpect(jsonPath("$.itemBrand", is("Galaxy")))
                .andExpect(jsonPath("$.itemName", is("Flip")))
                .andExpect(jsonPath("$.itemColor", is("White")))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void count() {
    }

    @Test
    void existById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void update() {
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