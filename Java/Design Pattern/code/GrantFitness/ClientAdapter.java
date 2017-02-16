package GrantFitness;

import GreenFitness.*;

public class ClientAdapter implements Customer {

    private Client client;

    public ClientAdapter(Client client) {
        this.client = client;
    }

    public void addPrepaidHours(int hours) {
        client.addHours(hours);
    }

    public String getId() {
        return client.getCid();
    }

    public String getName() {
        return client.getCName();
    }

    public String getPhoneNumber() {
        return client.getContactNumber();
    }

    public int getPrepaidHours() {
        return client.getRemainingHours();
    }

    public void setPhoneNumber(String number) {
        client.setContactNumber(number);
    }

    public void usePrepaidHours(int hours) {
        client.deductHours(hours);
    }

}
