/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.test;

import ict.db.MHDB;

/**
 *
 * @author Tak
 */
public class TestRegister {
    public static void main(String[] args){
        String url = "jdbc:derby://localhost/MoreHill_DB";
        String username = "APP";
        String password = "APP";
        MHDB mhDb = new MHDB(url, username, password);
        
        String mem_id = "1001";
        String mem_pw = "1001";
        String mem_name = "Peter";
        String mem_address = "TY";
        String mem_phone = "55555555";
        
         System.out.print(mhDb.addfood("1", "1", "1", "1",0.0));
        //mhDb.register(mem_id, mem_pw, mem_name, mem_address, mem_phone);
    }
}
