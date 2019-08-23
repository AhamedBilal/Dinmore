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

@Entity(name = "Orders")
public class Order {

    @Id
    private String orderID;
    private int status;
    private String rid;
    private String cid;
    private String name;
    private int qty;
    private String duration;
    private String orderDate;
    private String tel;

    public Order() {
    }

    public Order(String orderID, int status, String rid, String cid, String name, int qty, String duration, String orderDate, String tel) {
        this.orderID = orderID;
        this.status = status;
        this.rid = rid;
        this.cid = cid;
        this.name = name;
        this.qty = qty;
        this.duration = duration;
        this.orderDate = orderDate;
        this.tel = tel;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
