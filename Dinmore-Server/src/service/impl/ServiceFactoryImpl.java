/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import java.rmi.server.UnicastRemoteObject;
import service.ServiceFactory;
import service.SuperService;
import service.custom.impl.ChefServiceImpl;
import service.custom.impl.OrderServiceImpl;
import service.custom.impl.ReceptionServiceImpl;

/**
 *
 * @author Bilal
 */
public class ServiceFactoryImpl extends UnicastRemoteObject implements ServiceFactory {

    private static ServiceFactory serviceFactory;

    private ServiceFactoryImpl() throws Exception {
    }

    public static ServiceFactory getInstance() throws Exception {
        if (serviceFactory == null) {
            serviceFactory = new ServiceFactoryImpl();
        }
        return serviceFactory;
    }

    @Override
    public SuperService getService(ServiceType serviceType) throws Exception {
        switch (serviceType) {
            case ORDER:
                return new OrderServiceImpl();
            case RECEPTION:
                return new ReceptionServiceImpl();
            case CHEF:
                return new ChefServiceImpl();
            default:
                return null;
        }
    }

}
