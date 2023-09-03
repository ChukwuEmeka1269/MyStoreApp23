package org.js9.service;

import org.js9.model.*;
import org.js9.service.testUtil.ProductUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CashierServiceTest  {

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
    void whenCustomerBuyCashierShouldReduceTheQuantityOfProductInStoreAfterSale(){
        //Given
        customerService.buy(customer, "product1", 10);
        customerService.buy(customer, "product2", 20);
        customerService.buy(customer, "product3", 50);
        double productQuantityInStoreBeforeSaleForProduct1 = ProductUtil.getQuantityInStore("product1");
        double productQuantityInStoreBeforeSaleForProduct2 = ProductUtil.getQuantityInStore("product2");
        double productQuantityInStoreBeforeSaleForProduct3 = ProductUtil.getQuantityInStore("product3");
        //When
        cashierService.sell(customer, cashier);

        double productQuantityInStoreAfterSaleForProduct1 = ProductUtil.getQuantityInStore("product1");
        double productQuantityInStoreAfterSaleForProduct2 = ProductUtil.getQuantityInStore("product2");
        double productQuantityInStoreAfterSaleForProduct3 = ProductUtil.getQuantityInStore("product3");
        //Then
        assertTrue(productQuantityInStoreBeforeSaleForProduct1 > productQuantityInStoreAfterSaleForProduct1);
        assertTrue(productQuantityInStoreBeforeSaleForProduct2 > productQuantityInStoreAfterSaleForProduct2);
        assertTrue(productQuantityInStoreBeforeSaleForProduct3 > productQuantityInStoreAfterSaleForProduct3);

    }


    @Test
    void shouldThrowExceptionWhenProductNotFoundForOneProductInCustomerProductListAndProductListSizeIs1(){
        customerService.buy(customer, "production1", 10);
        RuntimeException exception = assertThrows(RuntimeException.class, ()->cashierService.sell(customer, cashier));
        assertEquals("Product not found!", exception.getMessage());
    }

    @Test
    void shouldNotThrowExceptionWhenProductNotFoundForOneProductInCustomerProductListAndProductListSizeGreaterThan1(){
        customerService.buy(customer, "production1", 10);
        customerService.buy(customer, "product1", 10);
        customerService.buy(customer, "product2", 10);
        customerService.buy(customer, "product3", 10);
        assertDoesNotThrow(()-> cashierService.sell(customer, cashier));
    }


    @Test
    void dispenseReceipt() {
    }
}