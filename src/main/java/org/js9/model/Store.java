package org.js9.model;

import org.js9.database.StaffDatabase;
import org.js9.database.ProductDatabase;

import java.util.ArrayList;
import java.util.List;


public class Store extends  BaseEntity implements  StaffDatabase, ProductDatabase {
    private static  String name;
    private static Address address;

    public Store() {
        name = "Generic Store";
        address = new Address("7 Asajon way", "Sangotedo", "Lagos", "NG", "0000");
    }

    public Store(String name) {
        super();
        this.name = name;
    }

    public List<Manager> getManagersList(){
        return getManagers();
    }

    public List<Cashier> getCashiersList(){
        return getCashiers();
    }

//    public List<Product> getProductList(){
//        return new ArrayList<>(getStoreProducts());
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  Address getAddress() {
        return address;
    }

    public  void setAddress(Address address) {
        Store.address = address;
    }
}
