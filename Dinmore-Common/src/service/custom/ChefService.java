/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.custom;

import dto.ChefDTO;
import java.util.List;
import service.SuperService;

/**
 *
 * @author Bilal
 */
public interface ChefService extends SuperService {

    public boolean addChef(ChefDTO cdto) throws Exception;

    public boolean updateChef(ChefDTO cdto) throws Exception;

    public boolean fireChef(String id) throws Exception;

    public List<ChefDTO> getAllChefs() throws Exception;

    public ChefDTO searchChef(String id) throws Exception;

}
