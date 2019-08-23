/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.custom;

import bo.SuperBO;
import dto.ReceptionDTO;
import java.util.List;

/**
 *
 * @author Bilal
 */
public interface ReceptionBO extends SuperBO{
    
    public boolean addReception(ReceptionDTO rdto) throws Exception;

    public boolean updateReception(ReceptionDTO rdto) throws Exception;

    public boolean fireReception(String id) throws Exception;

    public List<ReceptionDTO> getAllReceptions() throws Exception;

    public ReceptionDTO searchReception(String id) throws Exception;
    
}
