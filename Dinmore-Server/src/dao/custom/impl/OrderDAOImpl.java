/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.custom.impl;

import dao.custom.OrderDAO;
import entity.Order;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Bilal
 */
public class OrderDAOImpl implements OrderDAO {

    private Session session;

    @Override
    public void setSesstion(Session session) {
        this.session = session;
    }

    @Override
    public boolean save(Order o) throws Exception {
        return (session.save(o) != null);
    }

    @Override
    public boolean delete(Order t) throws Exception {
        session.delete(t);
        return true;
    }

    @Override
    public boolean update(Order t) throws Exception {
        session.update(t);
        return true;
    }

    @Override
    public Order search(String id) throws Exception {
        return session.get(Order.class, id);
    }

    @Override
    public List<Order> getAll() throws Exception {
        return session.createQuery("FROM Orders").list();
    }

}
