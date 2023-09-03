package org.js9.service.testUtil;

import org.js9.database.ProductDatabase;
import org.js9.model.Product;

import java.util.ArrayList;
import java.util.Map;

public class ProductUtil implements ProductDatabase{
    public static Map<String, Product> fetchProduct(){
        var product1 = new Product("product1", 2500.0, 50);
        var product2 = new Product("product2", 1500.0, 25);
        var product3 = new Product("product3", 3500.0, 350);
        var product4 = new Product("product4", 4500.0, 45);
        var product5 = new Product("product5", 250.0, 30);
        var product6 = new Product("product6", 650.0, 60);
        var product7 = new Product("product7", 150.0, 20);

        storeProducts.put("product1", product1);
        storeProducts.put("product2", product2);
        storeProducts.put("product3", product3);
        storeProducts.put("product4", product4);
        storeProducts.put("product5", product5);
        storeProducts.put("product6", product6);
        storeProducts.put("product7", product7);

        FILE_PRODUCT_WRITER.write("/Users/emirex/Documents/self-development/MyStoreApp/src/main/resources/Test.txt", new ArrayList<>(storeProducts.values()));

        return storeProducts;
    }

    public static double getQuantityInStore(String productName){
        return storeProducts.get(productName).getQuantityInStore();
    }
}
