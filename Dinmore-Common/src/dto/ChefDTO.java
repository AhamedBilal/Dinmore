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
public class ChefDTO extends SuperDTO{

    private String cid;
    private String password;

    public ChefDTO() {
    }

    public ChefDTO(String cid, String password) {
        this.cid = cid;
        this.password = password;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
