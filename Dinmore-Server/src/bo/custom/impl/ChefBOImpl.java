/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.custom.impl;

import bo.custom.ChefBO;
import dao.DAOFactory;
import dao.custom.ChefDAO;
import dto.ChefDTO;
import entity.Chef;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import resources.HibernateUtil;

/**
 *
 * @author Bilal
 */
public class ChefBOImpl implements ChefBO {

    private ChefDAO dao;

    public ChefBOImpl() {
        dao = (ChefDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CHEF);
    }

    @Override
    public boolean addChef(ChefDTO e) throws Exception {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            dao.setSesstion(session);
            session.beginTransaction();
            Chef c = new Chef(e.getCid(), e.getPassword());
            boolean result = dao.save(c);
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public boolean updateChef(ChefDTO e) throws Exception {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            dao.setSesstion(session);
            session.beginTransaction();
            Chef c = new Chef(e.getCid(), e.getPassword());
            boolean result = dao.update(c);
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public boolean fireChef(String id) throws Exception {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            dao.setSesstion(session);
            session.beginTransaction();
            Chef em = dao.search(id);
            boolean result = false;
            if (em != null) {
                result = dao.delete(em);
            }
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public List<ChefDTO> getAllChefs() throws Exception {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            dao.setSesstion(session);
            session.beginTransaction();
            List<Chef> chefs = dao.getAll();
            session.getTransaction().commit();
            if (chefs != null) {
                System.out.println("Not Null");
                List<ChefDTO> alList = new ArrayList<>();
                for (Chef c : chefs) {
                    ChefDTO cdto=new ChefDTO(c.getCid(), c.getPassword());
                    alList.add(cdto);
                }
                return alList;
            } else {
                return null;
            }
        }
    }

    @Override
    public ChefDTO searchChef(String id) throws Exception {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            dao.setSesstion(session);
            session.beginTransaction();
            Chef c = dao.search(id);
            session.getTransaction().commit();
            if (c!=null) {
                System.out.println(c.getPassword());
                return new ChefDTO(c.getCid(), c.getPassword());
            }
            return null;
        }
    }

}
