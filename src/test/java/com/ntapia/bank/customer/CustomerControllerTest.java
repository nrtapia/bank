package com.ntapia.bank.customer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;



/**
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    private static final String PATH_CUSTOMER = "/customer";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @Test
    public void testGetPath() throws Exception {
        Customer customer1 = CustomerUtil.getCustomerStub1();
        Customer customer2 = CustomerUtil.getCustomerStub2();

        when(customerService.list()).thenReturn(Arrays.asList(customer1, customer2));

        mockMvc.perform(get(PATH_CUSTOMER))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].fullName", is(customer1.getFullName())))
                .andExpect(jsonPath("$[0].cards").isEmpty())
                .andExpect(jsonPath("$[1].fullName", is(customer2.getFullName())))
                .andExpect(jsonPath("$[1].cards").isEmpty());

        verify(customerService, times(1)).list();
    }

    @Test
    public void testGetPathEmpty() throws Exception {
        when(customerService.list()).thenReturn(Collections.emptyList());

        mockMvc.perform(get(PATH_CUSTOMER))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));

        verify(customerService, times(1)).list();
    }

    @Test
    public void testGetItemPath() throws Exception {
        Long id = 1L;
        Customer customer = CustomerUtil.getCustomerStub1();
        customer.setId(id);
        customer.setCards(Arrays.asList(
                Card.builder().id(1L).cardType("1").build(),
                Card.builder().id(2L).cardType("2").build()));

        when(customerService.get(id)).thenReturn(customer);

        mockMvc.perform(get(PATH_CUSTOMER + "/" + id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.fullName").value(customer.getFullName()))
                .andExpect(jsonPath("$.phone").value(customer.getPhone()))
                .andExpect(jsonPath("$.cards", hasSize(2)))
                .andExpect(jsonPath("$.cards[0].id").value(1L))
                .andExpect(jsonPath("$.cards[1].id").value(2L));

        verify(customerService, times(1)).get(id);
    }

    @Test
    public void testGetItemPathNotFound() throws Exception {
        Long id = 1L;
        when(customerService.get(id)).thenThrow(new CustomerNotFoundException());

        mockMvc.perform(get(PATH_CUSTOMER + "/" + id))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.id").doesNotExist())
                .andExpect(jsonPath("$.cards").doesNotExist());

        verify(customerService, times(1)).get(id);
    }

}
