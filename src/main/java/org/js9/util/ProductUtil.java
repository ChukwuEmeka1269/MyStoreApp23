package org.js9.util;

import org.js9.database.ProductDatabase;
import org.js9.model.Product;

import java.util.List;

public class ProductUtil implements ProductDatabase {

    public  List<Product> fetchStoreProductFromFile(String filename){
        return getStoreProducts(filename);
    }

    public Product fetchProductByName(String productName){
        return storeProducts.get(productName);
    }


}
