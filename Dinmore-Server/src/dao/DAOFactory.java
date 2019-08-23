/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.custom.impl.ChefDAOImpl;
import dao.custom.impl.OrderDAOImpl;
import dao.custom.impl.ReceptionDAOImpl;

/**
 *
 * @author Bilal
 */
public class DAOFactory {

    public enum DAOTypes {
        ORDER, RECEPTION, CHEF;
    }

    public static DAOFactory dAOFactory;

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        if (dAOFactory == null) {
            dAOFactory = new DAOFactory();
        }
        return dAOFactory;
    }

    public SuperDAO getDAO(DAOTypes dAOTypes) {

        switch (dAOTypes) {
            case ORDER:
                return new OrderDAOImpl();
            case RECEPTION:
                return new ReceptionDAOImpl();
            case CHEF:
                return new ChefDAOImpl();
            default:
                return null;
        }
    }
}
