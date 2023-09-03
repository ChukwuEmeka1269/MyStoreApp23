package org.js9.database;

import org.js9.fileUtil.StoreFileProductBufferReaderImpl;
import org.js9.fileUtil.StoreFileProductWriterImpl;
import org.js9.fileUtil.StoreFileReader;
import org.js9.fileUtil.StoreFileWriter;
import org.js9.model.Product;

import java.util.*;
import java.util.stream.Collectors;

public interface ProductDatabase {
    Map<String, Product> storeProducts = new HashMap<>();
    StoreFileReader FILE_PRODUCT_BUFFER_READER = new StoreFileProductBufferReaderImpl();

    StoreFileWriter FILE_PRODUCT_WRITER = new StoreFileProductWriterImpl();

    default List<Product> getStoreProducts(){
        return new ArrayList<>(storeProducts.values());
    }


    //Gets product List from file(Products.txt)
    default List<Product> getStoreProducts(String fileName){
        List<Product> productList = new ArrayList<>();
        String[] contentFromFile = FILE_PRODUCT_BUFFER_READER.readFile(fileName);
        //Starting the index from 1 because I want to ignore the headers
        for (int i = 1; i < contentFromFile.length; i++) {
            String line = contentFromFile[i];
            String[] product = line.split("\\s+");


            String productName = product[1].replace("-", " ");
            double productPrice = Double.parseDouble(product[2]);
            double productQuantity = Double.parseDouble(product[3]);

            Product product1 = new Product();
            product1.setName(productName);
            product1.setPrice(productPrice);
            product1.setQuantityInStore(productQuantity);

            //Add product to the List of products in store
            System.out.printf("-------------Adding %s to product list------------", product1.getName());
            System.out.println();
            productList.add(product1);

        }

        List<Product> products = productList.stream()
                .map(product -> storeProducts.put(product.getName(), product))
                .collect(Collectors.toList());


        return productList;
    }


    default void addNewProduct(Product product, String location){
        FILE_PRODUCT_WRITER.write(location, product);
    }

    default void restockProduct(String productName, double quantity){
        Product product = getProduct(productName);
        double restockedQuantity = product.getQuantityInStore() + quantity;
        product.setQuantityInStore(restockedQuantity);
        storeProducts.replace(productName, product);
    }


    default void editProductName(String oldName, String newName){
        Product product = getProduct(oldName);
        if(Objects.isNull(product)){
            System.out.println("Product Not found!");
            return;
        }
        product.setName(newName);
        storeProducts.replace(oldName, product);
    }

    default void deleteProduct(String productName){
        Product product = getProduct(productName);
        if(Objects.nonNull(product)){
            storeProducts.remove(productName);
        }
    }

    private  Product getProduct(String productName) {
        return storeProducts.get(productName);
    }


}
