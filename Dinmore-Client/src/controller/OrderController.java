/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.OrderDTO;
import java.util.List;
import observer.Subject;
import proxy.ProxyHandler;
import service.ServiceFactory;
import service.custom.OrderService;

/**
 *
 * @author Bilal
 */
public class OrderController {

    public static boolean addOrder(OrderDTO odto) throws Exception {
        OrderService orderService = (OrderService) proxy.ProxyHandler.getInstance().getService(ServiceFactory.ServiceType.ORDER);
        return orderService.addOrder(odto);
    }

    public static boolean updateChef(String id, int i, String cid) throws Exception {
        OrderService orderService = (OrderService) proxy.ProxyHandler.getInstance().getService(ServiceFactory.ServiceType.ORDER);
        return orderService.updateChef(id, i, cid);
    }

    public static boolean updateQty(String id, int i) throws Exception {
        OrderService orderService = (OrderService) proxy.ProxyHandler.getInstance().getService(ServiceFactory.ServiceType.ORDER);
        return orderService.updateQty(id, i);
    }

    public static boolean deleteOrder(String oid) throws Exception {
        OrderService orderService = (OrderService) proxy.ProxyHandler.getInstance().getService(ServiceFactory.ServiceType.ORDER);
        return orderService.deleteOrder(oid);
    }

    public static List<OrderDTO> getAllOrders() throws Exception {
        OrderService orderService = (OrderService) proxy.ProxyHandler.getInstance().getService(ServiceFactory.ServiceType.ORDER);
        return orderService.getAllOrders();
    }
    
    public static boolean finishOrder(String id, int i, String time) throws Exception {
        OrderService orderService = (OrderService) proxy.ProxyHandler.getInstance().getService(ServiceFactory.ServiceType.ORDER);
        return orderService.finishOrder(id, i, time);
    }
    
    public static OrderDTO searchOrder(String oid) throws Exception {
        OrderService orderService = (OrderService) proxy.ProxyHandler.getInstance().getService(ServiceFactory.ServiceType.ORDER);
        return orderService.searchOrder(oid);
    }
    
    public static Subject getSubeject() throws Exception{
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceType.ORDER);
    }
}
