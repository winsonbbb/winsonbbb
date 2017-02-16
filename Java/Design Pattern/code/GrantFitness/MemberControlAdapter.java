package GrantFitness;

import GoodHealth.*;
import java.util.*;

public class MemberControlAdapter implements CustomerControl {

    private MemberCare memberCare;

    public MemberControlAdapter(MemberCare memberCare) {
        this.memberCare = memberCare;
    }

    public void addPrepaidHours(String id, int hours) {
        memberCare.addPrepaidHours(id, hours);
    }

    public void changePhoneNumber(String id, String newNumber) {
        memberCare.changePhoneNumber(id, newNumber);
    }

    public Customer createMember(String id, String name) {
        Customer customer = new MemberAdapter(memberCare.createMember(id, name));
        return customer;
    }

    public Customer searchMember(String id) {
        Customer customer;
        if (memberCare.searchMember(id) == null) {
            customer = null;
        } else {
            customer = new MemberAdapter(memberCare.searchMember(id));
        }

        if (customer == null) {
            return null;
        } else {
            return customer;
        }
    }

    public void usePrepaidHours(String id, int hours) {
        memberCare.usePrepaidHours(id, hours);
    }

    public void removeMember(String id) {
        memberCare.removeMember(id);
    }

    public Vector<Customer> getCustomer() {
        Vector<Customer> customer = new Vector();
        for (int i = 0; i < memberCare.getMembers().size(); i++) {
            customer.add(new MemberAdapter(memberCare.getMembers().get(i)));
        }

        return customer;
    }

}
