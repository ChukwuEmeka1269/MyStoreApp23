package org.js9.fileUtil;

import org.js9.model.Product;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class StoreFileProductWriterImpl implements StoreFileWriter {
    @Override
    public void write(String filename, List<Product> productList) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))){
            for(int i=0; i<productList.size(); i++){
                if(i==0){
                    bw.write("S/N          ProductName                              Price                    Quantity");
                    bw.newLine();
                }else {
                    bw.write(i + ".          " + productList.get(i).getName().replace(" ", "-") + "                              " + productList.get(i).getPrice() + "                    " + productList.get(i).getQuantityInStore());
                    bw.newLine();
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void write(String filename, Product product) {

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))){
            bw.write("X.          " + product.getName().replace(" ", "-") + "                              " + product.getPrice() + "                    " + product.getQuantityInStore());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) {
        String filename = "/Users/emirex/Documents/self-development/MyStoreApp/src/main/resources/Test.txt";

        StoreFileWriter writer = new StoreFileProductWriterImpl();
//        Product fruitsAndFibre = new Product("Fruits And Fibre", 2800);
//        fruitsAndFibre.setQuantityInStore(10);
//
//        Product goldenMorn = new Product("Golden Morn 500g", 1500);
//        goldenMorn.setQuantityInStore(20);
//
//        Product ariel = new Product("Ariel 1000g", 3500);
//        ariel.setQuantityInStore(100);
//
//        Product bread = new Product("Delicious cake bread", 3000);
//        bread.setQuantityInStore(50);
//
        Product fanta = new Product("Fanta 250cl", 3000);
        fanta.setQuantityInStore(50);

//        List<Product> productList = List.of(fruitsAndFibre, goldenMorn, ariel, bread);
        writer.write(filename, fanta);
    }
}
