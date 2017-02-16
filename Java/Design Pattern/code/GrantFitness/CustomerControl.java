package GrantFitness;

import java.util.Vector;

public interface CustomerControl {

    public abstract void addPrepaidHours(String id, int hours);

    public abstract void changePhoneNumber(String id, String newNumber);

    public abstract Customer createMember(String id, String name);

    public abstract Customer searchMember(String id);

    public abstract void usePrepaidHours(String id, int hours);

    public abstract void removeMember(String id);

    public abstract Vector<Customer> getCustomer();
}
