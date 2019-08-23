/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startup;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.impl.ServiceFactoryImpl;

/**
 *
 * @author Bilal
 */
public class ServerStart {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(5050);
            registry.rebind("DinmoreServer", ServiceFactoryImpl.getInstance());
            System.out.println("Server Has Been Strated Successfully");
        } catch (Exception ex) {
            Logger.getLogger(ServerStart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
