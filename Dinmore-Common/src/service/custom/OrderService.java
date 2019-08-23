/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.custom;

import dto.OrderDTO;
import java.util.List;
import service.SuperService;

/**
 *
 * @author Bilal
 */
public interface OrderService extends SuperService {

    public boolean addOrder(OrderDTO odto) throws Exception;

    public boolean updateChef(String id, int i, String cid) throws Exception;

    public boolean updateQty(String id, int i) throws Exception;

    public boolean deleteOrder(String oid) throws Exception;

    public List<OrderDTO> getAllOrders() throws Exception;

    public OrderDTO searchOrder(String oid) throws Exception;
    
    public boolean finishOrder(String id,int i,String time) throws Exception;
}
