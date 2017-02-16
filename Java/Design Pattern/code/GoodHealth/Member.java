package GoodHealth;

public class Member {

    private String id;
    String name;
    String phoneNumber;
    int prepaidHours;

    public Member(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getID() {
        return id;
    }

    public int getPrepaidHours() {
        return prepaidHours;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setPhoneNumber(String number) {
        this.phoneNumber = number;
    }

    public void addPrepaidHours(int hours) {
        this.prepaidHours += hours;
    }

    public void usePrepaidHours(int hours) {
        this.prepaidHours -= hours;
    }
}
