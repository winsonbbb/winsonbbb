package GrantFitness;

import java.util.Vector;

public class AddHoursCommand implements Command {

    private String id;
    private int hours;
    Vector<CustomerControl> controls;
    Customer customer;
    Memento m0;

    public AddHoursCommand(Vector<CustomerControl> controls, String id, int hours) {
        this.controls = controls;
        this.id = id;
        this.hours = hours;

    }

    public boolean execute() {
        for (int i = 0; i < controls.size(); i++) {
            customer = controls.get(i).searchMember(id);
            if (customer != null && customer.getId().equals(id)) {
                m0 = new HoursMemento(customer);
                customer.addPrepaidHours(hours);
                System.out.println("Added hours to member.\n");
                return true;
            }

        }
        System.out.println("No such customer.\n");
        return false;

    }

    public void undo() {
        m0.restore();  //restore the record
    }

    public void redo() {
        for (int i = 0; i < controls.size(); i++) {
            for (int j = 0; j < controls.get(i).getCustomer().size(); j++) {
                customer = controls.get(i).getCustomer().get(j);
                if (customer.getId().equals(id)) {
                    m0 = new HoursMemento(customer);
                    customer.addPrepaidHours(hours);
                    return;
                }
            }

        }
    }

    public String toString() {
        return "Add hours " + id + " " + hours;
    }

}
