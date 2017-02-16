package GrantFitness;

import GreenFitness.*;
import java.util.Vector;

public class ClientControlAdapter implements CustomerControl {

    private ClientControl clientControl;

    public ClientControlAdapter(ClientControl clientControl) {
        // TODO - implement ClientControlAdapter.ClientControlAdapter
        this.clientControl = clientControl;
    }

    public void addPrepaidHours(String id, int hours) {
        // TODO - implement ClientControlAdapter.addPrepaidHours
        clientControl.addHours(id, hours);
    }

    public void changePhoneNumber(String id, String newNumber) {
        // TODO - implement ClientControlAdapter.changePhoneNumber
        clientControl.updateContactNumber(id, newNumber);
    }

    /**
     *
     * @param id
     * @param name
     */
    public Customer createMember(String id, String name) {
        // TODO - implement ClientControlAdapter.createMember
        Customer customer = new ClientAdapter(clientControl.createClient(id, name));
        return customer;
    }

    /**
     *
     * @param id
     */
    public Customer searchMember(String id) {
        Customer customer = null;
        if (clientControl.findClient(id) == null) {
            customer = null;
        } else {
            customer = new ClientAdapter(clientControl.findClient(id));
        }

        if (customer == null) {
            return null;
        } else {
            return customer;
        }
    }

    /**
     *
     * @param id
     * @param hours
     */
    public void usePrepaidHours(String id, int hours) {
        // TODO - implement ClientControlAdapter.usePrepaidHours
        clientControl.deductHours(id, hours);
    }

    /**
     *
     * @param id
     */
    public void removeMember(String id) {
        // TODO - implement ClientControlAdapter.removeMember
        clientControl.deleteClient(id);
    }

    public Vector<Customer> getCustomer() {
        Vector<Customer> customer = new Vector();
        for (int i = 0; i < clientControl.getClients().size(); i++) {
            customer.add(new ClientAdapter(clientControl.getClients().get(i)));
        }

        return customer;
    }

    /**
     *
     * @param client
     */
}
