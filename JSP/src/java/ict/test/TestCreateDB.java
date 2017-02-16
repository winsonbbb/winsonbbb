package ict.test;

import ict.db.MHDB;


public class TestCreateDB {
    public static void main (String[] arg){
        
        String url = "jdbc:derby://localhost/MoreHill_DB";
        String username = "APP";
        String password = "APP";
        MHDB mhDB = new MHDB(url,username,password);
        //mhDB.createMember();
        //mhDB.createOrderRecord();
        //mhDB.createStore();
        //mhDB.createFood();
        //System.out.print(mhDB.addfood("1", "1", "1", "1",0.0));
        //System.out.print(mhDB.register("admin", "admin", "admin", "Manager", "MHill", 12345678, "0", 0));
    }
    
}