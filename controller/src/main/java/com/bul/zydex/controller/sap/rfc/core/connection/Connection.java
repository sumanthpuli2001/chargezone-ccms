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
import com.sap.conn.jco.JCoContext;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.ext.DestinationDataProvider;
import com.sap.conn.jco.ext.Environment;
import com.bul.zydex.controller.sap.system.model.SapSystem;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoRepository;

public class Connection
{
    static String SAP_SERVER;
    private JCoRepository repos;
    private JCoDestination dest;
    MyDestinationDataProvider myProvider;
    
    public Connection(final SapSystem system) {
        Environment.registerDestinationDataProvider((DestinationDataProvider)(this.myProvider = new MyDestinationDataProvider(system)));
        try {
            this.dest = JCoDestinationManager.getDestination(Connection.SAP_SERVER);
            System.out.println("Attributes:");
            System.out.println(this.dest.getAttributes());
            this.repos = this.dest.getRepository();
        }
        catch (JCoException e) {
            throw new RuntimeException((Throwable)e);
        }
    }
    
    public JCoFunction getFunction(final String functionStr) {
        JCoFunction function = null;
        try {
            function = this.repos.getFunction(functionStr);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Problem retrieving JCO.Function object.");
        }
        if (function == null) {
            throw new RuntimeException("Not possible to receive function. ");
        }
        return function;
    }
    
    public void execute(final JCoFunction function) {
        try {
            JCoContext.begin(this.dest);
            function.execute(this.dest);
        }
        catch (JCoException e) {
            e.printStackTrace();
            try {
                JCoContext.end(this.dest);
            }
            catch (JCoException e1) {
                e1.printStackTrace();
            }
        }
        finally {
            try {
                JCoContext.end(this.dest);
            }
            catch (JCoException e2) {
                e2.printStackTrace();
            }
        }
    }
    
    public void disconnect() {
        try {
            Environment.unregisterDestinationDataProvider((DestinationDataProvider)this.myProvider);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    
    static {
        Connection.SAP_SERVER = "SAP_SERVER";
    }
}