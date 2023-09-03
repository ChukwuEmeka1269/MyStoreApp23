package org.js9.fileUtil;

import org.js9.model.Product;

import java.util.List;

public interface StoreFileWriter {
    void write(String filename, List<Product> productList);

    void write(String filename, Product object);
}
