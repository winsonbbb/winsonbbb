package GrantFitness;

import java.util.Vector;

public class DisplayCommand implements Command {

    Vector<CustomerControl> controls;
    String id;

    public DisplayCommand(Vector<CustomerControl> controls, String id) {
        this.controls = controls;
        this.id = id;
    }

    public boolean execute() {
        System.out.println("\nMember information");
        if (id.equals("*")) { //* case
            System.out.println("ID\tName\tPhone Number\tHours");
            for (int i = 0; i < controls.size(); i++) {
                for (int j = 0; j < controls.get(i).getCustomer().size(); j++) {
                    Customer customer = controls.get(i).getCustomer().get(j);
                    System.out.println(customer.getId() + "\t" + customer.getName() + "\t" + customer.getPhoneNumber() + "\t\t" + customer.getPrepaidHours());
                }
            }
            System.out.println("");
        } else {
            for (int i = 0; i < controls.size(); i++) {
                Customer customer = controls.get(i).searchMember(id);
                if (customer != null && customer.getId().equals(id)) {
                    System.out.println("ID:" + customer.getId());
                    System.out.println("Name:" + customer.getName());
                    System.out.println("Phone Number:" + customer.getPhoneNumber());
                    System.out.println("Hours:" + customer.getPrepaidHours());
                    System.out.println("");
                    return true;

                }

            }
            System.out.println("No such customer.\n");

        }
        return true;
    }

    public void undo() {

    }

    public void redo() {
    }

}
