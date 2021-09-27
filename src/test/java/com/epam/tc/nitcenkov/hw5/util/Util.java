package com.epam.tc.nitcenkov.hw5.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Util {
    public static String URL;
    public static String LOGIN;
    public static String PASSWORD;
    public static String USER_NAME;

    static {
        loadProperties();
    }

    private static void loadProperties() {
        try (InputStream input = new FileInputStream("src/test/resources/testng/user-data.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            URL = prop.getProperty("url");
            LOGIN = prop.getProperty("login");
            PASSWORD = prop.getProperty("password");
            USER_NAME = prop.getProperty("user-name");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

