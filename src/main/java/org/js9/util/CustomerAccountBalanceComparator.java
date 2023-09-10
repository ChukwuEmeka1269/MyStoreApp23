package org.js9.util;

import org.js9.model.Customer;

import java.util.Comparator;

public class CustomerAccountBalanceComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        return Double.compare(o2.getAccountBalance(), o1.getAccountBalance());
    }
}
