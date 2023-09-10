package org.js9.model;

import org.js9.util.NameFormat;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Person {
    private String name;
    private double accountBalance;

    private List<Product> productList = new ArrayList<>();


    public Customer(String firstName, String lastName, Gender gender, String name, double accountBalance) {
        super(firstName, lastName, gender);
        this.name = name;
        this.accountBalance = accountBalance;
    }

    public double calculateTotalPrice(){
        return productList.stream().mapToDouble(item -> (item.getPrice() * item.getQuantityToBuy())).sum();
    }

    public double calculateTotalQuantity(){
        return productList.stream().mapToDouble(Product::getQuantityToBuy).sum();
    }

    public  String getCustomerFullName(){
        return NameFormat.formatName(getFirstName(), getLastName());
    }


    public Customer() {
        this.name = "Generic Customer";
        this.accountBalance = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }


}
