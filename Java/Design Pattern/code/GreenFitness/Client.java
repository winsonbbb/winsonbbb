package GreenFitness;

public class Client {

    private String cid;
    String cname;
    String contactNumber;
    int remainingHours;

    public Client(String id, String name) {
        this.cid = id;
        this.cname = name;
    }

    public String getCid() {
        return cid;
    }

    public int getRemainingHours() {
        return remainingHours;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getCName() {
        return cname;
    }

    public void setContactNumber(String number) {
        this.contactNumber = number;
    }

    public void addHours(int hours) {
        this.remainingHours += hours;
    }

    public void deductHours(int hours) {
        this.remainingHours -= hours;
    }
}
