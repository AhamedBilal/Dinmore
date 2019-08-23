/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.ChefDTO;
import dto.ReceptionDTO;
import java.util.List;
import proxy.ProxyHandler;
import service.ServiceFactory;
import service.custom.ChefService;
import service.custom.ReceptionService;

/**
 *
 * @author Bilal
 */
public class AdminController {
    
    //chef managing
    
    public static boolean addChef(ChefDTO cdto) throws Exception{
        ChefService service=(ChefService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceType.CHEF);
        return service.addChef(cdto);
    }

    public static boolean updateChef(ChefDTO cdto) throws Exception{
        ChefService service=(ChefService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceType.CHEF);
        return service.updateChef(cdto);
    }

    public static boolean fireChef(String id) throws Exception{
        ChefService service=(ChefService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceType.CHEF);
        return service.fireChef(id);
    }

    public static List<ChefDTO> getAllChefs() throws Exception{
        ChefService service=(ChefService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceType.CHEF);
        return service.getAllChefs();
    }

    public static ChefDTO searchChef(String id) throws Exception{
        ChefService service=(ChefService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceType.CHEF);
        return service.searchChef(id);
    }
    
    //reception managing
    
    public static boolean addReception(ReceptionDTO rdto) throws Exception{
        ReceptionService service=(ReceptionService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceType.RECEPTION);
        return service.addReception(rdto);
        
    }

    public static boolean updateReception(ReceptionDTO rdto) throws Exception{
        ReceptionService service=(ReceptionService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceType.RECEPTION);
        return service.updateReception(rdto);
        
    }

    public static boolean fireReception(String id) throws Exception{
        ReceptionService service=(ReceptionService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceType.RECEPTION);
        return service.fireReception(id);
    }

    public static List<ReceptionDTO> getAllReceptions() throws Exception{
        ReceptionService service=(ReceptionService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceType.RECEPTION);
        return service.getAllReceptions();
    }

    public static ReceptionDTO searchReception(String id) throws Exception{
        ReceptionService service=(ReceptionService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceType.RECEPTION);
        return service.searchReception(id);
    }
}
