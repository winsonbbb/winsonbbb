package GrantFitness;

import java.util.Vector;

public class SpendHoursCommand implements Command {

    private String id;
    private int hours;
    Vector<CustomerControl> controls;
    Customer customer;
    Memento m0;

    public SpendHoursCommand(Vector<CustomerControl> controls, String id, int hours) {
        this.controls = controls;
        this.id = id;
        this.hours = hours;

    }

    public boolean execute() {
        //loop for search member
        for (int i = 0; i < controls.size(); i++) { 
            customer = controls.get(i).searchMember(id);
            if (customer != null && customer.getId().equals(id)) {
                if (customer.getPrepaidHours() < hours) {
                    System.out.println("Invalid number of hours"
                            + "(member's hours <hours to be spent\n");
                } else {
                    //if have member use hours
                    m0 = new HoursMemento(customer);
                    customer.usePrepaidHours(hours);
                    System.out.println("Deducted hours on member.\n");
                }
                return true;
            }

        }

        System.out.println("No such customer.\n");
        return false;

    }

    public void undo() {
        m0.restore();
    }

    public void redo() {
        for (int i = 0; i < controls.size(); i++) {
            for (int j = 0; j < controls.get(i).getCustomer().size(); j++) {
                customer = controls.get(i).getCustomer().get(j);
                if (customer.getId().equals(id)) {
                    if (customer.getPrepaidHours() < hours) {
                        System.out.println("Invalid number of hours"
                                + "(member's hours <hours to be spent>)\n");
                    } else {
                        m0 = new HoursMemento(customer);
                        customer.usePrepaidHours(hours);
                    }
                    return;
                }

            }

        }
    }

    public String toString() {
        return "Spend hours " + id + " " + hours;
    }
}
