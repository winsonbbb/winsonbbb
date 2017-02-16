package GrantFitness;

public class PhoneMemento implements Memento {

    private String phone;
    private Customer customer;

    public PhoneMemento(Customer customer) {
        this.customer = customer;
        this.phone = customer.getPhoneNumber();

    }

    public void restore() {
        customer.setPhoneNumber(phone);

    }

}
