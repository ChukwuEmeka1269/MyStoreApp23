package org.js9.service;

import org.js9.model.Customer;
import org.js9.model.Staff;

import java.util.Queue;

public interface CashierService {
    void sell(Customer customer, Staff cashier);
    void sell(Queue<Customer> customerQueue, Staff cashier);
    void dispenseReceipt(Customer customer, Staff cashier);

}
