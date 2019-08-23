/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import bo.custom.impl.ChefBOImpl;
import bo.custom.impl.OrderBOImpl;
import bo.custom.impl.ReceptionBOImpl;

/**
 *
 * @author Bilal
 */
public class BOFactory {

    public enum BOTypes {
        ORDER, RECEPTION, CHEF;
    }

    private static BOFactory bOFactory;

    private BOFactory() {
    }

    public static BOFactory getInstance() {
        if (bOFactory == null) {
            bOFactory = new BOFactory();
        }
        return bOFactory;
    }

    public SuperBO getBO(BOTypes bOTypes) {
        switch (bOTypes) {
            case ORDER:
                return new OrderBOImpl();
            case RECEPTION:
                return new ReceptionBOImpl();
            case CHEF:
                return new ChefBOImpl();
            default:
                return null;
        }
    }
}
