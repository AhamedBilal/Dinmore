/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxy;

import java.rmi.Naming;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.ServiceFactory;
import service.SuperService;
import service.custom.ChefService;
import service.custom.OrderService;
import service.custom.ReceptionService;

/**
 *
 * @author Bilal
 */
public class ProxyHandler implements ServiceFactory {

    private static ProxyHandler proxyHandler;
    private OrderService orderService;
    private ChefService chefService;
    private ReceptionService receptionService;
    private ServiceFactory serviceFactory;

    private ProxyHandler() {
        try {
            serviceFactory = (ServiceFactory) Naming.lookup("rmi://localhost:5050/DinmoreServer");
            orderService = (OrderService) serviceFactory.getService(ServiceType.ORDER);
            chefService = (ChefService) serviceFactory.getService(ServiceType.CHEF);
            receptionService = (ReceptionService) serviceFactory.getService(ServiceType.RECEPTION);
        } catch (Exception ex) {
            Logger.getLogger(ProxyHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ProxyHandler getInstance() {
        if (proxyHandler == null) {
            proxyHandler = new ProxyHandler();
        }
        return proxyHandler;
    }

    @Override
    public SuperService getService(ServiceType serviceType) throws Exception {
        switch (serviceType) {
            case ORDER:
                return orderService;
            case CHEF:
                return chefService;
            case RECEPTION:
                return receptionService;
            default:
                return null;
        }
    }

}
