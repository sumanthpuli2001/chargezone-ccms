/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.sap.rfc.core.connection;

/**
 *
 * @author admin
 */
import com.sap.conn.jco.ext.DestinationDataEventListener;
import com.bul.zydex.controller.sap.system.model.SapSystem;
import java.util.Properties;
import com.sap.conn.jco.ext.DestinationDataProvider;

public class MyDestinationDataProvider implements DestinationDataProvider
{
    static String SAP_SERVER;
    private final Properties ABAP_AS_properties;
    
    public MyDestinationDataProvider(final SapSystem system) {
        final Properties properties = new Properties();
        properties.setProperty("jco.client.ashost", system.getHost());
        properties.setProperty("jco.client.sysnr", system.getSystemNumber());
        properties.setProperty("jco.client.client", system.getClient());
        properties.setProperty("jco.client.user", system.getUser());
        properties.setProperty("jco.client.passwd", system.getPassword());
        this.ABAP_AS_properties = properties;
    }
    
    public Properties getDestinationProperties(final String system) {
        return this.ABAP_AS_properties;
    }
    
    public void setDestinationDataEventListener(final DestinationDataEventListener eventListener) {
    }
    
    public boolean supportsEvents() {
        return false;
    }
    
    static {
        MyDestinationDataProvider.SAP_SERVER = "SAP_SERVER";
    }
}
