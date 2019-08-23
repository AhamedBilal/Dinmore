/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.custom.impl;

import dao.custom.ChefDAO;
import entity.Chef;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Bilal
 */
public class ChefDAOImpl implements ChefDAO{
    
    private Session session;

    @Override
    public void setSesstion(Session session) {
        this.session=session;
    }

    @Override
    public boolean save(Chef t) throws Exception {
        return session.save(t)!=null;
    }

    @Override
    public boolean delete(Chef t) throws Exception {
        session.delete(t);
        return true;
    }

    @Override
    public boolean update(Chef t) throws Exception {
        session.update(t);
        return true;
    }

    @Override
    public Chef search(String id) throws Exception {
        return session.find(Chef.class, id);
    }

    @Override
    public List<Chef> getAll() throws Exception {
        return session.createQuery("FROM Chef").list();
    }
    
}
