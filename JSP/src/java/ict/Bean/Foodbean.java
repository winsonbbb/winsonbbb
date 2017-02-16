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
public class Foodbean implements Serializable{
    String FoodID;
    String FoodName;
    String FoodDesc;
    String FoodCate;
    Double FoodPrice=0.0;

    public Foodbean() {
    }


    
    public String getFoodID() {
        return FoodID;
    }

    public void setFoodID(String foodid) {
        this.FoodID = foodid;
    }

    public void setFoodName(String foodname) {
        this.FoodName = foodname;
    }

    public void setFoodDesc(String fooddesc) {
        this.FoodDesc = fooddesc;
    }

    public void setFoodCate(String foodcate) {
        this.FoodCate = foodcate;
    }

    public void setFoodPrice(Double foodprice) {
        this.FoodPrice = foodprice;
    }

    public String getFoodName() {
        return FoodName;
    }

    public String getFoodDesc() {
        return FoodDesc;
    }

    public String getFoodCate() {
        return FoodCate;
    }

    public Double getFoodPrice() {
        return FoodPrice;
    }
    
}
