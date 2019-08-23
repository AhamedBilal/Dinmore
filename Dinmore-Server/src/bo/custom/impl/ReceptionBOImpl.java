/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.custom.impl;

import bo.custom.ReceptionBO;
import dao.DAOFactory;
import dao.custom.ReceptionDAO;
import dto.ReceptionDTO;
import entity.Reception;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import resources.HibernateUtil;

/**
 *
 * @author Bilal
 */
public class ReceptionBOImpl implements ReceptionBO{
    
    private ReceptionDAO dao;

    public ReceptionBOImpl() {
        dao=(ReceptionDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.RECEPTION);
    }
    
    

    @Override
    public boolean addReception(ReceptionDTO rdto) throws Exception {
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            dao.setSesstion(session);
            session.beginTransaction();
            Reception r=new Reception(rdto.getRid(), rdto.getPassword());
            boolean result =dao.save(r);
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public boolean updateReception(ReceptionDTO rdto) throws Exception {
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            dao.setSesstion(session);
            session.beginTransaction();
            Reception r=new Reception(rdto.getRid(), rdto.getPassword());
            boolean result =dao.update(r);
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public boolean fireReception(String id) throws Exception {
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            dao.setSesstion(session);
            session.beginTransaction();
            Reception r=dao.search(id);
            boolean result = false;
            if (r != null) {
                result = dao.delete(r);
            }
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public List<ReceptionDTO> getAllReceptions() throws Exception {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            dao.setSesstion(session);
            session.beginTransaction();
            List<Reception> receptions = dao.getAll();
            session.getTransaction().commit();
            if (receptions != null) {
                List<ReceptionDTO> alList=new ArrayList<>();
                for (Reception rr : receptions) {
                    ReceptionDTO r = new ReceptionDTO(rr.getRid(), rr.getPassword());
                    alList.add(r);
                }
                return alList;
            }else{
                return null;
            }
        }
    }

    @Override
    public ReceptionDTO searchReception(String id) throws Exception {
        try ( Session session = HibernateUtil.getSessionFactory().openSession()) {
            dao.setSesstion(session);
            session.beginTransaction();
            Reception c = dao.search(id);
            session.getTransaction().commit();
            if (c!=null) {
                System.out.println(c.getRid());
                return new ReceptionDTO(c.getRid(), c.getPassword());
            }
            return null;
            
        }
    }
    
}
