/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 *
 * @author Er. Jayesh Prajapati < Jayesh at www.bulwarks.com >
 */
public class DBConfig {

    public static void create() {
        Properties prop = new Properties();
        OutputStream output = null;

        try {

            output = new FileOutputStream("d:\\jdbc.properties");

            // set the properties value
            prop.setProperty("database", "localhost");
            prop.setProperty("dbuser", "mkyong");
            prop.setProperty("dbpassword", "password");

            // save properties to project root folder
            prop.store(output, null);

        }
        catch (IOException io) {
            io.printStackTrace();
        }
        finally {
            if (output != null) {
                try {
                    output.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void edit() {
        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream("d:\\jdbc.properties");

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println(prop.getProperty("database"));
            System.out.println(prop.getProperty("dbuser"));
            System.out.println(prop.getProperty("dbpassword"));

            OutputStream output = new FileOutputStream("d:\\jdbc.properties");

            // set the properties value
            prop.setProperty("database", "etender");
            prop.setProperty("dbuser", "root");
            prop.setProperty("dbpassword", "root");

            // save properties to project root folder
            prop.store(output, null);

        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        finally {
            if (input != null) {
                try {
                    input.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void edit(String source, String destination,
            DataSourceCustom dataSource, String dbSchemaName) {
        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream(source);

            // load a properties file
            prop.load(input);

            OutputStream output = new FileOutputStream(destination);

            dataSource.setUrl(dataSource.getUrl().replaceAll("e_schema",
                    dbSchemaName));
            dataSource.setDatabase(dbSchemaName);

            // set the properties value
            prop.setProperty("jdbc.database", dataSource.getDatabase());

            prop.setProperty("jdbc.driverClassName",
                    dataSource.getDriverClassName());
            prop.setProperty("jdbc.url", dataSource.getUrl());
            prop.setProperty("jdbc.username", dataSource.getUsername());
            prop.setProperty("jdbc.password", dataSource.getPassword());

            prop.setProperty("jdbc2.driverClassName",
                    dataSource.getDriverClassName());
            prop.setProperty("jdbc2.url", dataSource.getUrl());
            prop.setProperty("jdbc2.username", dataSource.getUsername());
            prop.setProperty("jdbc2.password", dataSource.getPassword());

            // save properties to project root folder
            prop.store(output, null);

        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        finally {
            if (input != null) {
                try {
                    input.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void load() {
        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream("d:\\jdbc.properties");

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println(prop.getProperty("database"));
            System.out.println(prop.getProperty("dbuser"));
            System.out.println(prop.getProperty("dbpassword"));

        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        finally {
            if (input != null) {
                try {
                    input.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        create();
        load();
        edit();
    }
}
