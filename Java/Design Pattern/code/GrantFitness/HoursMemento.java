package GrantFitness;

public class HoursMemento implements Memento {

    private int hours;
    private Customer customer;

    public HoursMemento(Customer customer) {
        this.customer = customer;
        this.hours = customer.getPrepaidHours();

    }

    public void restore() {
        int count = customer.getPrepaidHours() - hours;
        if (count > 0) {
            customer.usePrepaidHours(count);
        } else if (count < 0) {
            customer.addPrepaidHours(count * -1);
        }

    }

}
