/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.Bean;

/**
 *
 * @author Tak
 */
public class MemberBean {
    
    private String mem_id;
    private String mem_pw;
    private String mem_name;
    private String mem_type;
    private String mem_address;
    private String mem_phone;
    private int mem_point;
    private int free_pasta;

    public MemberBean() {
    }

    public String getMem_id() {
        return mem_id;
    }

    public String getMem_pw() {
        return mem_pw;
    }

    public String getMem_name() {
        return mem_name;
    }

    public String getMem_type() {
        return mem_type;
    }

    public void setMem_id(String mem_id) {
        this.mem_id = mem_id;
    }

    public void setMem_pw(String mem_pw) {
        this.mem_pw = mem_pw;
    }

    public void setMem_name(String mem_name) {
        this.mem_name = mem_name;
    }

    public void setMem_type(String mem_type) {
        this.mem_type = mem_type;
    }

    public void setMem_address(String mem_address) {
        this.mem_address = mem_address;
    }

    public void setMem_phone(String mem_phone) {
        this.mem_phone = mem_phone;
    }

    public void setMem_point(int mem_point) {
        this.mem_point = mem_point;
    }

    public void setFree_pasta(int free_pasta) {
        this.free_pasta = free_pasta;
    }

    public String getMem_address() {
        return mem_address;
    }

    public String getMem_phone() {
        return mem_phone;
    }

    public int getMem_point() {
        return mem_point;
    }

    public int getFree_pasta() {
        return free_pasta;
    }
    
    
    

}
