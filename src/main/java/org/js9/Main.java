package org.js9;

import org.js9.fileUtil.StoreFileProductWriterImpl;
import org.js9.model.*;

import org.js9.service.CashierServiceImpl;
import org.js9.service.CustomerServiceImpl;
import org.js9.service.ManagerServiceImpl;


import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Creating store.........................................");
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        Store store = new Store();

        System.out.println("-----------------------------------Product Creation Begins----------------------------------------------");
        Product fruitsAndFibre = new Product("Fruits And Fibre", 2800);
        fruitsAndFibre.setQuantityInStore(2000);

        Product goldenMorn = new Product("Golden Morn 500g", 1500);
        goldenMorn.setQuantityInStore(20);

        Product ariel = new Product("Ariel 1000g", 3500);
        ariel.setQuantityInStore(100);

        Product bread = new Product("Delicious cake bread", 3000);
        bread.setQuantityInStore(50);
        System.out.println("-----------------------------------End of Product Creation----------------------------------------------");

        System.out.println("..................................Adding products to store............................");
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        store.getStoreProducts().addAll(List.of(fruitsAndFibre, goldenMorn, ariel, bread));

        Store.storeProducts.putAll(Map.of("Fruits And Fibre", fruitsAndFibre, "Golden Morn 500g", goldenMorn, "Ariel 1000g", ariel, "Delicious cake bread", bread));

        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX  STORE PRODUCTS XXXXXXXXXXXXXXXXXXXXXXXXXXX");
        store.getStoreProducts().forEach(System.out::println);

        System.out.println("Creating store Manager.............................");
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        var manager = new Manager("Emeka", "Ukwuoma", Gender.MALE, "emeka@ukwuoma.com", StaffType.MANAGER);

        var managerAddress = new Address("Ojulari street", "Lekki", "Lagos", "NG", "00001");
        manager.setAddress(managerAddress);

        store.getManagersList().add(manager);

        var applicant1 = new Applicant("Applicant001", "001", Gender.FEMALE, 25, "applicant001@001.com",Qualification.Degree, Post.MANAGER);
        var applicant2 = new Applicant("Applicant002", "002", Gender.FEMALE, 25, "applicant002@002.com",Qualification.SecondarySchool, Post.MANAGER);
        var applicant3 = new Applicant("Applicant003", "003", Gender.MALE, 35, "applicant003@003.com",Qualification.Masters, Post.MANAGER);
        var applicant4 = new Applicant("Applicant004", "004", Gender.MALE, 27, "applicant004@004.com",Qualification.OrdinaryDiploma, Post.MANAGER);
        var applicant5 = new Applicant("Applicant005", "005", Gender.FEMALE, 26, "applicant005@005.com",Qualification.HigherDiploma, Post.CASHIER);
        var applicant6 = new Applicant("Applicant006", "006", Gender.MALE, 14, "applicant006@006.com",Qualification.Doctorate, Post.MANAGER);

        System.out.println("Hiring process begins.........................................................");
        System.out.println("Creating Manager Service......................................................");
        var managerService = new ManagerServiceImpl();
        managerService.hire(applicant1);
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        managerService.hire(applicant2);
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        managerService.hire(applicant3);
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        managerService.hire(applicant4);
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        managerService.hire(applicant5);
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        managerService.hire(applicant6);
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }


        System.out.println("----------------------------------Creating Customer----------------------------------------------------");
        var customer1 =  new Customer("Cust001", "C001", Gender.MALE, "Cust001", 25000.0);
        var customer2 =  new Customer("Cust002", "C002", Gender.MALE, "Cust002", 5000.0);
        var customer3 =  new Customer("Cust003", "C003", Gender.MALE, "Cust003", 13000.0);
        var customer4 =  new Customer("Cust004", "C004", Gender.MALE, "Cust004", 10000.0);
        var customer5 =  new Customer("Cust005", "C005", Gender.MALE, "Cust005", 1500.0);
        var customer6 =  new Customer("Cust006", "C006", Gender.MALE, "Cust007", 250.0);
        System.out.println("-----------------------------------X End of Customer Creation X----------------------------------------------");


        System.out.println("-----------------------------------CashierService Creation Begins----------------------------------------------");
        var cashierService = new CashierServiceImpl();
        Cashier genCash = store.getCashiersList().stream().filter(cashier -> cashier.getFirstName().equals("Applicant005")).findFirst().orElseGet(()-> new Cashier("Generic Cashier 001", "Gen001", Gender.OTHER, "gen001@gen.com", StaffType.CASHIER));
        genCash.setStore(store);

        System.out.println();
        System.out.println("-----------------------------------Creating CustomerService---------------------------------");
        var customerService = new CustomerServiceImpl();

        System.out.println("-----------------------------------Beginning Customer Purchase----------------------------------------");
        customerService.buy(customer1, "Fruits And Fibre", 25 );
//        cashierService.sell(customer1, genCash );
        System.out.println("-----------------------------------End of Customer Purchase----------------------------------------------");

        System.out.println("-----------------------------------Beginning Customer Purchase----------------------------------------");
        customerService.buy(customer2, "Fruits And Fibre", 5 );
        System.out.println("-----------------------------------End of Customer Purchase----------------------------------------------");

        System.out.println("-----------------------------------Beginning Customer Purchase----------------------------------------");
        customerService.buy(customer3, "Fruits And Fibre", 5 );

        System.out.println("-----------------------------------Beginning Customer Purchase----------------------------------------");
        customerService.buy(customer4, "Fruits And Fibre", 5 );
        customerService.buy(customer5, "Fruits And Fibre", 5 );
        customerService.buy(customer6, "Fruits And Fibre", 5 );


        System.out.println("-----------------------------------Adding Customer Fifo Queue----------------------------------------------");
        managerService.addCustomerToFifoQueue(customer3);
        managerService.addCustomerToFifoQueue(customer1);
        managerService.addCustomerToFifoQueue(customer2);
        System.out.println("-----------------------------------X End of Adding to Fifo Queue X----------------------------------------------");
        System.out.println("-----------------------------------Adding Customer to Priority Queue----------------------------------------------");
       managerService.addCustomerToPriorityQueue(customer4);
       managerService.addCustomerToPriorityQueue(customer5);
       managerService.addCustomerToPriorityQueue(customer6);

        System.out.println("-----------------------------------X End of Adding to Priority Queue X----------------------------------------------");

        cashierService.sell(managerService.getFifoQueue(), genCash);
        cashierService.sell(managerService.getPriorityQueue(), genCash);




        Product product9 = new Product("Product9", 12.0, 50.0);
        var storeFileWriter = new StoreFileProductWriterImpl();
        System.out.println("Product List");
        String fileName = "/Users/emirex/Documents/self-development/MyStoreApp/src/main/resources/Test.txt";
        storeFileWriter.write(fileName, product9);
        store.getStoreProducts(fileName).forEach(System.out::println);






    }
}