package com.rozetka.utils;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import com.rozetka.steps.Variables.Variables;

import java.io.*;
import java.util.Properties;

public class PropertyLoader {
    static final String PROP_PATH =System.getProperty("user.dir")+"\\src\\test\\resources\\Rozetka.properties";
    
    public static final String loadProperty(String name) {
        BufferedInputStream propFileInStream=null;
        Properties proper = new Properties();
        String value = "";
        try {
            propFileInStream = new BufferedInputStream( new FileInputStream(PROP_PATH));
            proper.load(propFileInStream);
            if (name != null) {
                value = proper.getProperty(name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                propFileInStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return value;
    }


    public static final void updateProperty(String propName, String propValue){
        PropertiesConfiguration Config;
        try {
            Config =new PropertiesConfiguration(PROP_PATH);
            Config.setProperty(propName, propValue);
            Config.save();
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }
}
