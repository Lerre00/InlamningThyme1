package com.example.thymeleaflektion2.controllers;

import com.example.thymeleaflektion2.models.Buy;
import com.example.thymeleaflektion2.models.Customer;
import com.example.thymeleaflektion2.models.Item;
import com.example.thymeleaflektion2.repositories.BuyRepository;
import com.example.thymeleaflektion2.repositories.CustomerRepository;
import com.example.thymeleaflektion2.repositories.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CustomerControllerTest {


    @Autowired
    private MockMvc mvc;

    @MockBean
    private ItemRepository mockItemRepo;

    @MockBean
    private CustomerRepository mockCustomerRepo;

    @MockBean
    private BuyRepository mockBuyRepo;

    @BeforeEach
    public void init() {

        LocalDate d1 = LocalDate.of(2008, 2, 25);
        LocalDate d2 = LocalDate.of(1999, 1, 3);
        LocalDate d3 = LocalDate.of(2020, 12, 30);

        Customer c1 = new Customer("Anton", "000918");
        Customer c2 = new Customer("Elias", "020918");
        Customer c3 = new Customer("Jani", "000999");

        c1.setId(1L);
        c2.setId(2L);
        c3.setId(3L);

        List<Customer> findAllCustomerList = List.of(c1,c2,c3);

        when(mockCustomerRepo.findById(1L)).thenReturn(Optional.of(c1));
        when(mockCustomerRepo.findById(2L)).thenReturn(Optional.of(c2));
        when(mockCustomerRepo.findById(3L)).thenReturn(Optional.of(c3));
        when(mockCustomerRepo.findAll()).thenReturn(findAllCustomerList);


        Item i1 = new Item("Tandborste",12L);
        Item i2 = new Item("Toaborste", 25L);
        Item i3 = new Item("Diskborste", 10L);

        List<Item> list1 = List.of(i1,i2);
        List<Item> list2 = List.of(i2,i3);
        List<Item> list3 = List.of(i1,i2,i3);

        List<Item> findAllItemList = List.of(i1,i2,i3);

        when(mockItemRepo.findById(1L)).thenReturn(Optional.of(i1));
        when(mockItemRepo.findById(2L)).thenReturn(Optional.of(i2));
        when(mockItemRepo.findById(3L)).thenReturn(Optional.of(i3));
        when(mockItemRepo.findAll()).thenReturn(findAllItemList);

        Buy b1 = new Buy(d1,c1,list1);
        Buy b2 = new Buy(d2,c2,list2);
        Buy b3 = new Buy(d3,c3,list3);

        List<Buy> findAllBuyList = List.of(b1,b2,b3);


        when(mockBuyRepo.findById(1L)).thenReturn(Optional.of(b1));
        when(mockBuyRepo.findById(2L)).thenReturn(Optional.of(b2));
        when(mockBuyRepo.findById(3L)).thenReturn(Optional.of(b3));
        when(mockBuyRepo.findAll()).thenReturn(findAllBuyList);
    }

    @Test
    void getAllCustomersUsingMockExpectingMultipleJsonObjects() throws Exception{
        final String expected = "[{\"id\":1,\"name\":\"Anton\",\"ssn\":\"000918\"},{\"id\":2,\"name\":\"Elias\",\"ssn\":\"020918\"},{\"id\":3,\"name\":\"Jani\",\"ssn\":\"000999\"}]";
        final String url = "/customers";

        this
                .mvc
                .perform(get(url))
                .andExpect(status().isOk())
                .andExpect(content()
                        .json(expected));
    }

    @Test
    void getCustomerByIdUsingMockExpectingOneJsonObject() throws Exception{
        final String expected ="{\"id\":1,\"name\":\"Anton\",\"ssn\":\"000918\"}";
        final String url = "/customers/1";

        this
                .mvc
                .perform(get(url))
                .andExpect(status().isOk())
                .andExpect(content()
                        .json(expected));
    }

    @Test
    void postCustomerUsingMockExpectingString() throws Exception{
        final String expected = "Customer Leroy saved";
        final String url = "/customers";
        final String content = "{\"id\":4, \"name\": \"Leroy\", \"ssn\":123}";
        //"{\"id\":4, \"name\": \"Leroy\", \"ssn\":123}"
        this
                .mvc
                .perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(expected)));
    }
}