package com.trycloud.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties = new Properties();
    //we are blocking access from other classes
    static {
        //whatever we put in the static block will be executed the first thing
        //before everything else.
        try {
            FileInputStream file = new FileInputStream("configuration.properties");
            properties.load(file);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static String getProperty(String keyWord){
        return properties.getProperty(keyWord);
    }
}


