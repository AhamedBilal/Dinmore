/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.custom.impl;

import dao.custom.ReceptionDAO;
import entity.Reception;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Bilal
 */
public class ReceptionDAOImpl implements ReceptionDAO{
    private Session session;

    @Override
    public void setSesstion(Session session) {
        this.session=session;
    }

    @Override
    public boolean save(Reception t) throws Exception {
        return session.save(t)!=null;
        
    }

    @Override
    public boolean delete(Reception t) throws Exception {
        session.delete(t);
        return true;
    }

    @Override
    public boolean update(Reception t) throws Exception {
        session.update(t);
        return true;
    }

    @Override
    public Reception search(String id) throws Exception {
        return session.find(Reception.class, id);
    }

    @Override
    public List<Reception> getAll() throws Exception {
        return session.createQuery("FROM Reception").list();
    }
    
    
    
}
