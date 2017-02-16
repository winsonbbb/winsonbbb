package GoodHealth;

import java.io.*;
import java.util.*;

public class MemberCare {

    private Vector<Member> members = new Vector(); //vector for save member

    public void addPrepaidHours(String id, int hours) {
        Member member = searchMember(id);
        if (member != null) {
            member.addPrepaidHours(hours);
        }

    }

    public void changePhoneNumber(String id, String newNumber) {
        Member member = searchMember(id);
        if (member != null) {
            member.setPhoneNumber(newNumber);
        }

    }

    public Member createMember(String id, String name) {
        Member member = new Member(id, name);
        members.add(member);
        return member;
    }

    public Member searchMember(String id) {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getID().equals(id)) {
                return members.get(i);
            }
        }
        return null;
    }

    public void usePrepaidHours(String id, int hours) {
        Member member = searchMember(id);
        if (member != null) {
            member.usePrepaidHours(hours);
        }
    }

    public void removeMember(String id) {
        Member member = searchMember(id);
        if (member != null) {
            members.remove(member);
        }

    }

    public Vector<Member> getMembers() {
        return members;
    }

}
