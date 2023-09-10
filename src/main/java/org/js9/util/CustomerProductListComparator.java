package org.js9.util;

import org.js9.model.Customer;

import java.util.Comparator;

public class CustomerProductListComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        return Integer.compare(o1.getProductList().size(), o2.getProductList().size());
    }
}
