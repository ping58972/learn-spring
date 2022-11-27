package com.ping.gradlespringbootpractice.controller;

import com.google.gson.Gson;
import com.ping.gradlespringbootpractice.entiry.Customer;
import com.ping.gradlespringbootpractice.repository.CustomerRepo;
import com.ping.gradlespringbootpractice.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

//@RunWith(SpringRunner.class)
@WebMvcTest(controllers = CustomerController.class)
//@ExtendWith(MockitoExtension.class)
//@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {
    @MockBean
    CustomerService customerService;
    @MockBean
    CustomerRepo customerRepo;
    @Mock
    HttpServletRequest request;
//    @MockBean
//    JwtProvider jwtProvider;
    @Spy
    List<Customer> customersSpy = new ArrayList<>();
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//        MockitoAnnotations.initMocks(this);
    }

    @Test
//    @WithMockUser(authorities = "DELETE")
    void getAllCustomers() throws Exception {
        Customer customerExpect = Customer.builder().userId(1).build();
        customersSpy.add(customerExpect);
        Mockito.when(customerService.getAllCustomers()).thenReturn(customersSpy);
        Gson gson = new Gson();
        String json = gson.toJson(customersSpy);
        mockMvc.perform(MockMvcRequestBuilders.get("/customer/all")
                                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json(json))
        ;
        Mockito.verify(customerService, Mockito.times(1)).getAllCustomers();
    }
    @Test
//    @WithMockUser(authorities = "DELETE")
    void getCustomerByUserId() throws Exception {
        Customer customerExpect = Customer.builder().userId(1).build();
        Mockito.when(customerService.getCustomerByUserId(1)).thenReturn(customerExpect);
        Gson gson = new Gson();
        String json = gson.toJson(customerExpect);
        mockMvc.perform(MockMvcRequestBuilders.get("/customer/1")
                                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json(json))
        ;
        Mockito.verify(customerService, Mockito.times(2)).getCustomerByUserId(1);
    }
}

