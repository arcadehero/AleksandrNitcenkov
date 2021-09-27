package com.epam.tc.nitcenkov.hw9.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Util {

    public static String BASE_URI;
    public static String KEY;
    public static String TOKEN;
    public static String BOARD_NAME;
    public static String LIST_NAME;
    public static String CARD_NAME;

    static {
        loadProperties();
    }

    private static void loadProperties() {
        try (InputStream input = new FileInputStream("src/test/resources/test-api.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            BASE_URI = prop.getProperty("base_uri");
            KEY = prop.getProperty("key");
            TOKEN = prop.getProperty("token");
            BOARD_NAME = prop.getProperty("boardName");
            LIST_NAME = prop.getProperty("listName");
            CARD_NAME = prop.getProperty("cardName");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
