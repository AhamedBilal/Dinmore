/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.custom.impl;

import bo.custom.OrderBO;
import dao.DAOFactory;
import dao.custom.OrderDAO;
import dto.ChefDTO;
import dto.OrderDTO;
import entity.Chef;
import entity.Order;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import resources.HibernateUtil;

/**
 *
 * @author Bilal
 */
public class OrderBOImpl implements OrderBO {

    private OrderDAO dao;

    public OrderBOImpl() {
        dao = (OrderDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDER);
    }

    @Override
    public boolean addOrder(OrderDTO t) throws Exception {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            dao.setSesstion(session);
            session.beginTransaction();
            Order order = new Order(
                    t.getOrderID(),
                    t.getStatus(),
                    t.getRid(),
                    t.getCid(),
                    t.getName(),
                    t.getQty(),
                    t.getDuration(),
                    t.getOrderDate(),
                    t.getTel()
            );
            boolean result = dao.save(order);
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public boolean deleteOrder(String oid) throws Exception {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            dao.setSesstion(session);
            session.beginTransaction();
            Order order = dao.search(oid);
            boolean result = false;
            if (order != null) {
                result = dao.delete(order);
            }
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public List<OrderDTO> getAllOrders() throws Exception {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            dao.setSesstion(session);
            session.beginTransaction();
            List<Order> orders = dao.getAll();
            session.getTransaction().commit();
            if (orders != null) {
                System.out.println("Not Null");
                List<OrderDTO> alList = new ArrayList<>();
                for (Order o : orders) {
                    OrderDTO odto = new OrderDTO(
                            o.getOrderID(),
                            o.getStatus(),
                            o.getRid(),
                            o.getCid(),
                            o.getName(),
                            o.getQty(),
                            o.getDuration(),
                            o.getOrderDate(),
                            o.getTel()
                    );

                    System.out.println("Hello :" + o.getOrderID());
                    alList.add(odto);
                }
                return alList;
            } else {
                return null;
            }
        }
    }

    @Override
    public OrderDTO searchOrder(String oid) throws Exception {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            dao.setSesstion(session);
            session.beginTransaction();
            Order o = dao.search(oid);
            session.getTransaction().commit();
            if (o!=null) {
                return new OrderDTO(o.getOrderID(), o.getStatus(), o.getRid(), o.getCid(), o.getName(), o.getQty(), o.getDuration(), o.getOrderDate(), o.getTel());
            }
            return null;
        }
    }

    @Override
    public boolean updateChef(String id, int i, String cid) throws Exception {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            dao.setSesstion(session);
            session.beginTransaction();
            Order order = dao.search(id);
            boolean result = false;
            if (order != null) {
                order.setStatus(i);
                order.setCid(cid);
                result = dao.update(order);
            }
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public boolean updateQty(String id, int i) throws Exception {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            dao.setSesstion(session);
            session.beginTransaction();
            Order order = dao.search(id);
            boolean result = false;
            if (order != null) {
                order.setQty(i);
                result = dao.update(order);
            }
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public boolean finishOrder(String id, int i, String time) throws Exception {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            dao.setSesstion(session);
            session.beginTransaction();
            Order order = dao.search(id);
            boolean result = false;
            if (order != null) {
                order.setStatus(i);
                order.setDuration(time);
                result = dao.update(order);
            }
            session.getTransaction().commit();
            return result;
        }
    }

}
