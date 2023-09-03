package org.js9.service;

import org.js9.model.*;
import org.js9.service.testUtil.ProductUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceTest {

    Store store ;
    Map<String, Product> productMap = null;
    Cashier cashier = null;
    CashierService cashierService = null;
    Customer customer = null;

    CustomerService customerService = null;

    @BeforeEach
    void init(){
        store =  new Store("Jendol Super Stores");
        productMap = ProductUtil.fetchProduct();
        cashier = new Cashier("Jane", "Doe", Gender.FEMALE, "janedoe@test.com", StaffType.CASHIER);
        cashier.setStore(store);
        cashierService = new CashierServiceImpl();
        customer = new Customer("John", "Doe", Gender.MALE, "John Doe", 5000000.0);
        customerService = new CustomerServiceImpl();

    }


    @Test
    void shouldIncreaseNumberOfProductInCustomerProductListWhenBuying() {
        //Given
        //When
        int countOfProductsInCustomerProductListBeforeBuying = customer.getProductList().size();
        customerService.buy(customer, "product1",  15);
        int countOfProductsInCustomerProductListAfterBuying = customer.getProductList().size();
        //Then
        assertTrue(countOfProductsInCustomerProductListAfterBuying>countOfProductsInCustomerProductListBeforeBuying);
    }
}