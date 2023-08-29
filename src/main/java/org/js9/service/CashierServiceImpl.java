package org.js9.service;

import org.js9.database.ProductDatabase;
import org.js9.model.*;
import org.js9.util.NameFormat;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class CashierServiceImpl implements CashierService, ProductDatabase {

    @Override
    public void sell(Customer customer, Staff cashier) {
        List<Product> storeProducts = getStoreProductList();
        List<Product> customerProductList = customer.getProductList();
        double customerBalance = customer.getAccountBalance();
        for(Product product : customerProductList){
            double quantity = product.getQuantityToBuy();
            double totalCost = customer.calculateTotalPrice();
            if(!storeProducts.contains(product)){
                System.out.println("Sorry we do not have this product currently. Please check back soon.");
                break;
            }
            if(customerBalance < totalCost){
                System.out.println("Insufficient balance to purchase this item.");
                break;
            }

            Store store = fetchStore(cashier);
            System.out.printf("----------------- Selling product { %s } to customer { %s } -------------------------------", product.getName(), customer.getName());
            System.out.println();
            store.sellProductByName(product.getName(), quantity);
            System.out.printf("%s successfully purchased %s qty of %s.", customer.getName(), (int)product.getQuantityToBuy(), product.getName());
            System.out.println();
            customerBalance -= totalCost;
        }

        customer.setAccountBalance(customerBalance);

    }


    private Store fetchStore(Staff cashier){
        return cashier.getStore();
    }

    private  List<Product> getStoreProductList() {
        return new ArrayList<>(storeProducts.values());
    }



    @Override
    public void dispenseReceipt(Customer customer, Staff cashier){
        List<Product> productList = customer.getProductList();
        int count = 0;
        int totalQuantity = 0;
        double totalPrice = 0.0;

        System.out.println("                              "  + cashier.getStore().getName());
        System.out.println("                              "  + cashier.getStore().getAddress());
        System.out.printf("Thank you for patronizing %s store. \nYou were attended to by: %s",
                cashier.getStore().getName(), NameFormat.formatName(cashier.getFirstName(), cashier.getLastName()));

        System.out.println("S/N             Item                              Qty               Price");
        for(Product product1 : productList){
            double productQuantity = product1.getQuantityToBuy();
            totalQuantity += productQuantity;
            double product1Price = product1.getPrice();
            totalPrice += product1Price;
            System.out.println(count++ + "          " + product1.getName() + "                              " + productQuantity + "               "+ product1Price);
        }


        String totalPriceFormatted = NumberFormat.getCurrencyInstance().format(totalPrice);
        System.out.println("           Total Item Bought = " + count);
        System.out.println("                                                  Total Qty = " + totalQuantity);
        System.out.println("                                                  Total Amount Paid = " + totalPriceFormatted);
        


    }

    private Receipt getReceipt(Product product, Customer customer, Staff cashier) {
        var receipt = new Receipt();
        receipt.setAttendedBy(NameFormat.formatName(cashier.getFirstName(), cashier.getLastName()));
        receipt.setProduct(product);
        receipt.setCustomerName(customer.getName());
        receipt.setTotalQuantity(customer.calculateTotalQuantity());
        receipt.setTotalPrice(customer.calculateTotalPrice());
        receipt.setStoreName(cashier.getStore().getName());
        return receipt;
    }


}
