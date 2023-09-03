package org.js9.fileUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//Reads value from a property file
public class PropertyFileReader {

    public static String getValue(String property, String location){
        Properties properties = new Properties();
        String propValue = "";

        try(FileInputStream inputStream = new FileInputStream(location)){
            properties.load(inputStream);
            propValue = properties.getProperty(property);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        return propValue;
    }

}
