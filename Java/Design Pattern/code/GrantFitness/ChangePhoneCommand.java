package GrantFitness;

import java.util.Vector;

public class ChangePhoneCommand implements Command {

    private String id;
    private String phone;
    Vector<CustomerControl> controls;
    Customer customer;
    Memento m0;

    public ChangePhoneCommand(Vector<CustomerControl> controls, String id, String phone) {
        this.controls = controls;
        this.id = id;
        this.phone = phone;

    }

    public boolean execute() {
        for (int i = 0; i < controls.size(); i++) {
            customer = controls.get(i).searchMember(id);
            if (customer != null && customer.getId().equals(id)) {
                m0 = new PhoneMemento(customer);
                customer.setPhoneNumber(phone);
                System.out.println("Updated member's phone number.\n");
                return true;
            }

        }

        System.out.println("No such customer.\n");
        return false;

    }

    public void undo() {
        m0.restore(); //restore the record
    }

    public String toString() {
        return "Change phone number " + id + " " + phone;
    }

    @Override
    public void redo() {
        for (int i = 0; i < controls.size(); i++) {
            for (int j = 0; j < controls.get(i).getCustomer().size(); j++) {
                customer = controls.get(i).getCustomer().get(j);
                if (customer.getId().equals(id)) {
                    m0 = new PhoneMemento(customer);
                    customer.setPhoneNumber(phone);
                    return;
                }

            }

        }
    }
}
