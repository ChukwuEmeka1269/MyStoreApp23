package org.js9.fileUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StoreFileProductBufferReaderImpl implements StoreFileReader {
    @Override
    public String[] readFile(String name) {

        List<String> productList = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(name))){
            String line;
            while((line = br.readLine()) != null){
                productList.add(line);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return productList.toArray(new String[0]);
    }
}
