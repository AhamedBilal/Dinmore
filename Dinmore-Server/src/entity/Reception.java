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
public class Reception {

    @Id
    private String rid;
    private String password;

    public Reception() {
    }

    public Reception(String rid, String password) {
        this.rid = rid;
        this.password = password;
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
