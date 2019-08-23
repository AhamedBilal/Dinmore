/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.custom.impl;

import bo.BOFactory;
import bo.custom.ChefBO;
import dto.ChefDTO;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import service.custom.ChefService;

/**
 *
 * @author Bilal
 */
public class ChefServiceImpl extends UnicastRemoteObject implements ChefService {
    
    private ChefBO bo;

    public ChefServiceImpl() throws Exception{
        bo=(ChefBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.CHEF);
    }
   

    @Override
    public boolean addChef(ChefDTO cdto) throws Exception {
        return bo.addChef(cdto);
    }

    @Override
    public boolean updateChef(ChefDTO cdto) throws Exception {
        return bo.updateChef(cdto);
    }

    @Override
    public boolean fireChef(String id) throws Exception {
        return bo.fireChef(id);
    }

    @Override
    public List<ChefDTO> getAllChefs() throws Exception {
        return bo.getAllChefs();
    }

    @Override
    public ChefDTO searchChef(String id) throws Exception {
        return bo.searchChef(id);
    }
    
}
