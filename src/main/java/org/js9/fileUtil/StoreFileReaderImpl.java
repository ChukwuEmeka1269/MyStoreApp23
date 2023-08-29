package org.js9.fileUtil;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class StoreFileReaderImpl implements StoreFileReader {
    @Override
    public  String[] readFile(String filename) {

        try{
            Path path = Paths.get(filename);
            List<String> fileContent = Files.readAllLines(path);
            return fileContent.toArray(new String[0]);
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        var test = new StoreFileReaderImpl();
        String[] content = test.readFile("/Users/emirex/Documents/self-development/MyStoreApp/src/main/resources/Products.txt");
        for(String line : content){
            System.out.println(line);
        }
    }
}
