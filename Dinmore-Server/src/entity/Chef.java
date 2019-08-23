/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.Entity;
import javax.persistence.Id;




/**
 *
 * @author Bilal
 */
@Entity
public class Chef {

    @Id
    private String cid;
    private String password;

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

    public Chef() {
    }

    public Chef(String cid, String password) {
        this.cid = cid;
        this.password = password;
    }

}
