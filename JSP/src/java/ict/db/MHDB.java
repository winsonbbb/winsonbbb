/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.db;

import ict.Bean.Foodbean;
import ict.Bean.MemberBean;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *
 * @author chiwingkwok
 */
public class MHDB {

    private String url = "";
    private String username = "";
    private String password = "";

    public MHDB(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public MHDB() {
    }

    public Connection getConnection() throws SQLException, IOException {
        System.setProperty("jdbc.drivers", "org.apache.derby.jdbc.ClientDriver");
        return DriverManager.getConnection(url, username, password);
    }

    //Create Table
    public void createMember() {
        Connection cnnct = null;
        Statement stmnt = null;

        try {
            cnnct = getConnection();
            stmnt = cnnct.createStatement();
            String sql = "CREATE TABLE Member ("
                    + "mem_id VARCHAR(5) CONSTRAINT PK_MEMBER PRIMARY KEY,"
                    + "mem_pw VARCHAR(8),mem_name VARCHAR(20),mem_type VARCHAR(20),mem_address VARCHAR(50),mem_phone INTEGER,mem_point VARCHAR(10),free_pasta INTEGER)";

            stmnt.execute(sql);

            stmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void createOrderRecord() {
        Connection cnnct = null;
        Statement stmnt = null;

        try {
            cnnct = getConnection();
            stmnt = cnnct.createStatement();
            String sql = "CREATE TABLE OrderRecord ("
                    + "order_id VARCHAR(5) CONSTRAINT PK_OrderRecord PRIMARY KEY, "
                    + "mem_name VARCHAR(20) , mem_phone INTEGER, order_price INTEGER, order_status VARCHAR(10) ,order_time TIME)";
            stmnt.execute(sql);

            stmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void createStore() {
        Connection cnnct = null;
        Statement stmnt = null;

        try {
            cnnct = getConnection();
            stmnt = cnnct.createStatement();
            String sql = "CREATE TABLE Store ("
                    + "store_id VARCHAR(8)  CONSTRAINT PK_Store PRIMARY KEY, "
                    + "store_name VARCHAR(30) )";
            stmnt.execute(sql);

            stmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void createFood() {
        Connection cnnct = null;
        Statement stmnt = null;

        try {
            cnnct = getConnection();
            stmnt = cnnct.createStatement();
            String sql = "CREATE TABLE Food ("
                    + "food_id VARCHAR(8) CONSTRAINT PK_Food PRIMARY KEY, "
                    + "food_name VARCHAR(20), food_desc VARCHAR(100), food_cate VARCHAR(50), food_price VARCHAR(10000) )";
            stmnt.execute(sql);

            stmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //Add data
    public Boolean addfood(String FOOD_ID, String FOOD_NAME, String FOOD_DESC, String FOOD_CATE, Double FOOD_PRICE) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try {
            cnnct = getConnection();
            String preQueryStatment = "INSERT INTO FOOD VALUES(?,?,?,?,?)";
            pStmnt = cnnct.prepareStatement(preQueryStatment);
            pStmnt.setString(1, FOOD_ID);
            pStmnt.setString(2, FOOD_NAME);
            pStmnt.setString(3, FOOD_DESC);
            pStmnt.setString(4, FOOD_CATE);
            pStmnt.setDouble(5, FOOD_PRICE);

            int rowCount = pStmnt.executeUpdate();
            if (rowCount >= 1) {
                isSuccess = true;
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isSuccess;
    }
    
    public Boolean editRecord(Foodbean fb) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;

        try {
            cnnct = getConnection();
            String preQueryStatement = "UPDATE FOOD SET FOOD_ID=?,FOOD_NAME=?,FOOD_DESC=?,FOOD_CATE=?,FOOD_PRICE=? WHERE FOOD_ID = ? ";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, fb.getFoodID());
            pStmnt.setString(2, fb.getFoodName());
            pStmnt.setString(3, fb.getFoodDesc());
            pStmnt.setString(4, fb.getFoodCate());
            pStmnt.setDouble(5, fb.getFoodPrice());
            pStmnt.setString(6, fb.getFoodID());
            
            int rs = pStmnt.executeUpdate();
            if (rs > 0) {
                return true;
            }

            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public Boolean delRecord(String FoodID) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        ArrayList<Foodbean> acb = new ArrayList<Foodbean>();
        try {
            cnnct = getConnection();
            String preQueryStatement = "DELETE FROM FOOD WHERE FOOD_ID = ? ";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, FoodID);
            int rs = pStmnt.executeUpdate();
            if (rs > 0) {
                return true;
            }

            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }
      
     public ArrayList<Foodbean> queryFood() {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        ArrayList<Foodbean> acb = new ArrayList<Foodbean>();
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM FOOD";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            ResultSet rs = pStmnt.executeQuery();
            while (rs.next()) {
                Foodbean cb = new Foodbean();
                cb.setFoodID(rs.getString("FOOD_ID"));
                cb.setFoodName(rs.getString("FOOD_NAME"));
                cb.setFoodDesc(rs.getString("FOOD_DESC"));
                cb.setFoodCate(rs.getString("FOOD_CATE"));
                cb.setFoodPrice(rs.getDouble("FOOD_PRICE"));
                acb.add(cb);
            }

            pStmnt.close();
            cnnct.close();
            return acb;
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
     
    public ArrayList<Foodbean> queryFoodByName(String name) {
        String upName = "%" + name.toString().toUpperCase() + "%";
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        ArrayList<Foodbean> acb = new ArrayList<Foodbean>();
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM FOOD WHERE upper(FOOD_NAME) like ?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, upName);
            ResultSet rs = pStmnt.executeQuery();
            while (rs.next()) {
                Foodbean cb = new Foodbean();
                cb.setFoodID(rs.getString("FOOD_ID"));
                cb.setFoodName(rs.getString("FOOD_NAME"));
                cb.setFoodDesc(rs.getString("FOOD_DESC"));
                cb.setFoodCate(rs.getString("FOOD_CATE"));
                cb.setFoodPrice(rs.getDouble("FOOD_PRICE"));
                acb.add(cb);

            }
            pStmnt.close();
            cnnct.close();
            return acb;
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Foodbean queryFoodByID(String id) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        //ArrayListFoodbean> acb = new ArrayList<Foodbean>();
        Foodbean cb = new Foodbean();
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM FOOD WHERE FOOD_ID = ?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, id);
            ResultSet rs = pStmnt.executeQuery();
            while (rs.next()) {
                //Foodbean cb = new Foodbean();
                cb.setFoodID(rs.getString("FOOD_ID"));
                cb.setFoodName(rs.getString("FOOD_NAME"));
                cb.setFoodDesc(rs.getString("FOOD_DESC"));
                cb.setFoodCate(rs.getString("FOOD_CATE"));
                cb.setFoodPrice(rs.getDouble("FOOD_PRICE"));
                //acb.add(cb);

            }
            pStmnt.close();
            cnnct.close();
            return cb;
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

 /*  public boolean register(String MEM_ID, String MEM_PW, String MEM_NAME, String MEM_TYPE , String MEM_ADDRESS,int MEM_PHONE,String MEM_POINT ,int MEM_PASTA){
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try{
            cnnct = getConnection();
            //String preQueryStatement = "INSERT INTO MEMBER VALUES (?,?,?,?,?,?,?,?)";
            String preQueryStatement = "INSERT INTO MEMBER VALUES (?,?,?,Customer,?,?,5,0)";
            pStmnt =  cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, MEM_ID);
            pStmnt.setString(2, MEM_PW);
            pStmnt.setString(3, MEM_NAME);
           // pStmnt.setString(4, MEM_TYPE);
            pStmnt.setString(5, MEM_ADDRESS);
            pStmnt.setInt(6, MEM_PHONE);
            //pStmnt.setString(7, MEM_POINT);
           // pStmnt.setInt(8, MEM_PASTA);

            int rowCount = pStmnt.executeUpdate();
            if(rowCount ==5){
                isSuccess = true;
            }
            pStmnt.close();
            cnnct.close();
            }
        catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isSuccess;
    }
              */
    public boolean isValidUser(String user, String pwd) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        //PreparedStatement pStmnt2 = null;
        boolean isValid = false;
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM MEMBER WHERE MEM_ID=? and MEM_PW=? ";
            //String preQueryStatement2 = "SELECT * FROM MEMBER WHERE staff_id=? and staff_pw=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            //pStmnt2 = cnnct.prepareStatement(preQueryStatement2);
            pStmnt.setString(1, user);
            pStmnt.setString(2, pwd);

            ResultSet rs = pStmnt.executeQuery();
            if (rs.next()) {
                isValid = true;
            }
            pStmnt.close();
            cnnct.close();   
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isValid;
    }
    
    public boolean isManager(String user, String pwd) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        //PreparedStatement pStmnt2 = null;
        boolean isManager = false;
        
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM MEMBER WHERE MEM_ID=? AND MEM_PW=? AND MEM_TYPE=?";
            //String preQueryStatement2 = "SELECT * FROM MEMBER WHERE staff_id=? and staff_pw=?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            //pStmnt2 = cnnct.prepareStatement(preQueryStatement2);
            pStmnt.setString(1, user);
            pStmnt.setString(2, pwd);
            pStmnt.setString(3, "Manager");
            ResultSet rs = pStmnt.executeQuery();
            if (rs.next()) {
                isManager = true;
            }
            pStmnt.close();
            cnnct.close();   
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isManager;
    }

    public boolean register(String memId, String memPwd, String memName, String memAddress, int memPhone) {
       Connection cnnct = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try{
            cnnct = getConnection();
            //String preQueryStatement = "INSERT INTO MEMBER VALUES (?,?,?,?,?,?,?,?)";
            String preQueryStatement = "INSERT INTO MEMBER VALUES (?,?,?,?,?,?,?,?)";
            pStmnt =  cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, memId);
            pStmnt.setString(2, memPwd);
            pStmnt.setString(3, memName);
            pStmnt.setString(4, "Customer");
            pStmnt.setString(5, memAddress);
            pStmnt.setInt(6, memPhone);
            pStmnt.setInt(7, 5);
            pStmnt.setInt(8, 0);

            int rowCount = pStmnt.executeUpdate();
            if(rowCount ==5){
                isSuccess = true;
            }
            pStmnt.close();
            cnnct.close();
            }
        catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return isSuccess;
    }

   /* public ArrayList<OrderBean> queryOrder() {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;

        OrderBean ob = null;
        try {
            //1. get Connection
            cnnct = getConnection();

            String preQueryStatement = "SELECT * FROM ORDERRECORD ORDER BY ORDER_TIME DESC";

            //2. get the prepare Statement
            pStmnt = cnnct.prepareStatement(preQueryStatement);

            ResultSet rs = null;

            //4. execute the query and assign to the result
            rs = pStmnt.executeQuery();

            ArrayList<OrderBean> list = new ArrayList();

            while (rs.next()) {
                ob = new OrderBean();

                //set the record detail to the customer bean
                ob.setOrderID(rs.getString(1));
                ob.setOrderStatus(rs.getString(2));
                ob.setOrderTime(rs.getString(3));
                ob.setOrderOwnerID(rs.getString(4));
                ob.setOrderPickupStore(rs.getString(5));
                ob.setOrderPickupTime(rs.getString(6));
                list.add(ob);
            }
            return list;
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (pStmnt != null) {
                try {
                    pStmnt.close();
                } catch (SQLException e) {
                }
            }
            if (cnnct != null) {
                try {
                    cnnct.close();
                } catch (SQLException sqlEx) {
                }
            }
        }
        return null;
    }
    
    public OrderBean queryOrderByID(String orderID) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;

        OrderBean ob = null;
        try {
            //1. get Connection
            cnnct = getConnection();

            String preQueryStatement = "SELECT * FROM MEMORDER WHERE orderID=?";

            //2. get the prepare Statement
            pStmnt = cnnct.prepareStatement(preQueryStatement);

            //3.update the placehoder with id
            pStmnt.setString(1, orderID);

            ResultSet rs = null;

            //4. execute the query and assign to the result
            rs = pStmnt.executeQuery();

            if (rs.next()) {
                ob = new OrderBean();

                //set the record detail to the member bean
                ob.setOrderID(rs.getString(1));
                ob.setOrderStatus(rs.getString(2));
                ob.setOrderTime(rs.getString(3));
                ob.setOrderOwnerID(rs.getString(4));
                ob.setOrderPickupStore(rs.getString(5));
                ob.setOrderPickupTime(rs.getString(6));
            }
            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return ob;
    }*/
     public MemberBean queryCustByID(String id) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;
        //ArrayListFoodbean> acb = new ArrayList<Foodbean>();
        MemberBean cb = new MemberBean();
        try {
            cnnct = getConnection();
            String preQueryStatement = "SELECT * FROM MEMBER WHERE MEM_ID = ?";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, id);
            ResultSet rs = pStmnt.executeQuery();
            while (rs.next()) {
                //Foodbean cb = new Foodbean();
                cb.setMem_id(rs.getString("MEM_ID"));
                cb.setMem_pw(rs.getString("MEM_PW"));
                cb.setMem_name(rs.getString("MEM_NAME"));
                cb.setMem_phone(rs.getString("MEM_PHONE"));
                cb.setMem_point(rs.getInt("MEM_POINT"));
                cb.setFree_pasta(rs.getInt("FREE_PASTA"));
                //acb.add(cb);

            }
            pStmnt.close();
            cnnct.close();
            return cb;
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
     
     public Boolean addPoints(String id,int points) {
        Connection cnnct = null;
        PreparedStatement pStmnt = null;

        try {
            cnnct = getConnection();
            String preQueryStatement = "UPDATE MEMBER SET MEM_POINT=MEM_POINT+? WHERE MEM_ID = ? ";
            pStmnt = cnnct.prepareStatement(preQueryStatement);
            pStmnt.setInt(1, points);
            pStmnt.setString(2, id);
            int rs = pStmnt.executeUpdate();
            if (rs > 0) {
                return true;
            }

            pStmnt.close();
            cnnct.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}

