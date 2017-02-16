package GrantFitness;
import GoodHealth.*;

public class MemberAdapter implements Customer {

    private Member member;

    public MemberAdapter(Member member) {
        this.member = member;
    }

    public void addPrepaidHours(int hours) {
        member.addPrepaidHours(hours);
    }

    public String getId() {
        return member.getID();
    }

    public String getName() {
        return member.getName();
    }

    public String getPhoneNumber() {
        return member.getPhoneNumber();
    }

    public int getPrepaidHours() {
        return member.getPrepaidHours();
    }

    public void setPhoneNumber(String number) {
        member.setPhoneNumber(number);
    }

    public void usePrepaidHours(int hours) {
        member.usePrepaidHours(hours);
    }

}
