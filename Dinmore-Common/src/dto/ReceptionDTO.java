/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Bilal
 */

public class ReceptionDTO extends SuperDTO {
    
    private String rid;
    private String password;

    public ReceptionDTO(String rid, String password) {
        this.rid = rid;
        this.password = password;
    }

    public ReceptionDTO() {
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
