/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.custom.impl;

import bo.BOFactory;
import bo.custom.ReceptionBO;
import dto.ReceptionDTO;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import service.custom.ReceptionService;

/**
 *
 * @author Bilal
 */
public class ReceptionServiceImpl extends UnicastRemoteObject implements ReceptionService{
    
    private ReceptionBO bo;

    public ReceptionServiceImpl() throws Exception{
        bo=(ReceptionBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.RECEPTION);
    }
    
    

    @Override
    public boolean addReception(ReceptionDTO rdto) throws Exception {
        return bo.addReception(rdto);
    }

    @Override
    public boolean updateReception(ReceptionDTO rdto) throws Exception {
        return bo.updateReception(rdto);
    }

    @Override
    public boolean fireReception(String id) throws Exception {
        return bo.fireReception(id);
    }

    @Override
    public List<ReceptionDTO> getAllReceptions() throws Exception {
        return bo.getAllReceptions();
    }

    @Override
    public ReceptionDTO searchReception(String id) throws Exception {
        return bo.searchReception(id);
    }
    
}
