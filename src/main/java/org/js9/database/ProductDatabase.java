package org.js9.database;

import org.js9.fileUtil.StoreFileBufferReaderImpl;
import org.js9.fileUtil.StoreFileReader;
import org.js9.model.Product;

import java.util.*;

public interface ProductDatabase {
    Map<String, Product> storeProducts = new HashMap<>();
    StoreFileReader fileReader = new StoreFileBufferReaderImpl();

    default List<Product> getStoreProducts(){
        return new ArrayList<>(storeProducts.values());
    }


    //Gets product List from file(Products.txt)
    default List<Product> getStoreProducts(String fileName){
        List<Product> productList = new ArrayList<>();
        String[] contentFromFile = fileReader.readFile(fileName);
        //Starting the index from 1 because I want to ignore the headers
        for (int i = 1; i < contentFromFile.length; i++) {
            String line = contentFromFile[i];
            String[] product = line.split("\\s+");


            String productName = product[1].replace("-", " ");
            double productPrice = Double.parseDouble(product[2]);
            double productQuantity = Double.parseDouble(product[2]);

            Product product1 = new Product();
            product1.setName(productName);
            product1.setPrice(productPrice);
            product1.setQuantityInStore(productQuantity);

            //Add product to the List of products in store
            System.out.printf("-------------Adding %s to product list------------", product1.getName());
            System.out.println();
            productList.add(product1);

        }


        return productList;
    }

    default Product sellProductByName(String productName, double quantityToSell){
        Product product = storeProducts.get(productName);
        double remainingQuantityInStore = product.getQuantityInStore() - quantityToSell;
        product.setQuantityInStore(remainingQuantityInStore);

        storeProducts.replace(productName, product);

        return product;
    }


    default void addNewProduct(Product product){

    }

    default void restockProduct(Product product){

    }
}
