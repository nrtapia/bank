package com.ntapia.bank.customer;

import com.ntapia.bank.dao.CustomerRepository;
import com.ntapia.bank.exception.CustomerAlreadyExistException;
import com.ntapia.bank.exception.CustomerInvalidDataException;
import com.ntapia.bank.exception.CustomerNotFoundException;
import com.ntapia.bank.model.Customer;
import com.ntapia.bank.service.impl.CustomerServiceImpl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository repository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    private Customer mockCustomer;

    @Before
    public void init() {
        mockCustomer = CustomerUtil.getCustomerStub1();
    }

    @Test(expected = CustomerInvalidDataException.class)
    public void testCustomerInvalidDataNull() {
        customerService.save(null);
        verifyNeverCallFinByNullNameAndSave();
    }

    @Test(expected = CustomerInvalidDataException.class)
    public void testCustomerInvalidDataNameNull() {
        Customer customer = CustomerUtil.getCustomerStub2();
        customer.setFullName(null);
        customerService.save(customer);
        verifyNeverCallFinByNullNameAndSave();
    }

    @Test(expected = CustomerInvalidDataException.class)
    public void testCustomerInvalidDataNameEmpty() {
        mockCustomer.setFullName("  ");
        customerService.save(mockCustomer);
        verifyNeverCallFinByNullNameAndSave();
    }

    private void verifyNeverCallFinByNullNameAndSave() {
        verify(repository, never()).findByFullName(anyString());
        verify(repository, never()).save(any());
    }

    @Test(expected = CustomerAlreadyExistException.class)
    public void testCustomerAlreadyExist() {
        final String name = "HOMER";
        Optional<Customer> customer = Optional.of(Customer.builder().id(1L).fullName("Homer").build());
        when(repository.findByFullName(name)).thenReturn(customer);

        mockCustomer.setFullName(name);
        customerService.save(mockCustomer);
        verify(repository, times(1)).findByFullName(name);
        verify(repository, never()).save(any());
    }

    @Test
    public void testSaveOk() {
        mockCustomer.setFullName("Bart");
        when(repository.save(mockCustomer)).thenReturn(mockCustomer);
        when(repository.findByFullName(anyString())).thenReturn(Optional.empty());

        customerService.save(mockCustomer);
        verify(repository, times(1)).findByFullName(mockCustomer.getFullName());
        verify(repository, times(1)).save(mockCustomer);
    }

    @Test(expected = CustomerNotFoundException.class)
    public void testDeleteIdNotFound() {
        final Long id = 1L;
        when(repository.findById(id)).thenReturn(Optional.empty());
        customerService.delete(id);

        verify(repository, times(1)).findById(id);
        verify(repository, never()).delete(any());
    }

    @Test
    public void testDeleteOk() {
        final Long id = 1L;
        final Optional<Customer> expected = Optional.of(mockCustomer);

        when(repository.findById(id)).thenReturn(expected);
        doNothing().when(repository).delete(expected.get());
        customerService.delete(id);

        verify(repository, times(1)).findById(id);
        verify(repository, times(1)).delete(expected.get());
    }
}
