package org.js9.service;

import org.js9.model.*;

import java.util.List;

public interface CashierService {
    void sell(Customer customer, Staff cashier);
    void dispenseReceipt(Customer customer, Staff cashier);
}
