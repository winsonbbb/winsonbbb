/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.Bean;

import java.io.Serializable;

/**
 *
 * @author chiwingkwok
 */
public class Orderbean implements Serializable{
    String OrderID;
    String OrderPrice;
    String OrderStatus;
    String OrderTime;

    public Orderbean() {
    }

    public String getOrderID() {
        return OrderID;
    }

    public String getOrderPrice() {
        return OrderPrice;
    }

    public String getOrderStatus() {
        return OrderStatus;
    }

    public String getOrderTime() {
        return OrderTime;
    }

    public void setOrderID(String OrderID) {
        this.OrderID = OrderID;
    }

    public void setOrderPrice(String OrderPrice) {
        this.OrderPrice = OrderPrice;
    }

    public void setOrderStatus(String OrderStatus) {
        this.OrderStatus = OrderStatus;
    }

    public void setOrderTime(String OrderTime) {
        this.OrderTime = OrderTime;
    }
    
}


