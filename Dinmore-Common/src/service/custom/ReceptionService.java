/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.custom;

import dto.ReceptionDTO;
import java.util.List;
import service.SuperService;

/**
 *
 * @author Bilal
 */
public interface ReceptionService extends SuperService {

    public boolean addReception(ReceptionDTO rdto) throws Exception;

    public boolean updateReception(ReceptionDTO rdto) throws Exception;

    public boolean fireReception(String id) throws Exception;

    public List<ReceptionDTO> getAllReceptions() throws Exception;

    public ReceptionDTO searchReception(String id) throws Exception;

}
