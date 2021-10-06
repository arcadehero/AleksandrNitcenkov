package com.epam.tc.nitcenkov.hw4.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class Util {
    private static final Properties PROPERTIES = new Properties();

    public static String URL;
    public static String LOGIN;
    public static String INVALID_LOGIN;
    public static String PASSWORD;
    public static String TITLE;
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
            INVALID_LOGIN = prop.getProperty("invalidLogin");
            PASSWORD = prop.getProperty("password");
            TITLE = prop.getProperty("title");
            USER_NAME = prop.getProperty("user-name");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
