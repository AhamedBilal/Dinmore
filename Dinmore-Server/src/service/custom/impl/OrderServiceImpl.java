/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.custom.impl;

import bo.BOFactory;
import bo.custom.OrderBO;
import dto.OrderDTO;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import observer.Observer;
import observer.Subject;
import service.custom.OrderService;

/**
 *
 * @author Bilal
 */
public class OrderServiceImpl extends UnicastRemoteObject implements OrderService,Subject {

    private OrderBO bo;
    private static ArrayList<Observer> alObservers = new ArrayList<>();

    public OrderServiceImpl() throws Exception {
        bo = (OrderBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ORDER);
    }

    @Override
    public boolean addOrder(OrderDTO odto) throws Exception {
        boolean b = bo.addOrder(odto);
        notifyObservers();
        return b;
    }

    @Override
    public boolean updateChef(String id, int i, String cid) throws Exception {
        boolean b = bo.updateChef(id, i, cid);
        notifyObservers();
        return b;
    }

    @Override
    public boolean updateQty(String id, int i) throws Exception {
        boolean b = bo.updateQty(id, i);
        notifyObservers();
        return b;
    }

    @Override
    public boolean deleteOrder(String oid) throws Exception {
        boolean b = bo.deleteOrder(oid);
        notifyObservers();
        return b;
    }

    @Override
    public List<OrderDTO> getAllOrders() throws Exception {
        return bo.getAllOrders();
    }

    @Override
    public OrderDTO searchOrder(String oid) throws Exception {
        return bo.searchOrder(oid);
    }

    @Override
    public void registerObserver(Observer observer) throws Exception {
        alObservers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) throws Exception {
        alObservers.remove(observer);
    }

    @Override
    public void notifyObservers() throws Exception {
        new Thread(()->{
            for (Observer observer : alObservers) {
                try {
                    observer.updateObservers();
                } catch (Exception ex) {
                    Logger.getLogger(OrderServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }

    @Override
    public boolean finishOrder(String id, int i, String time) throws Exception {
        boolean b = bo.finishOrder(id, i,time);
        notifyObservers();
        return b;
    }

}
