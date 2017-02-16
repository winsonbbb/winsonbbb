package GrantFitness;

public interface Customer {

    public abstract String getId();

    public abstract String getName();

    public abstract String getPhoneNumber();

    public abstract int getPrepaidHours();

    public abstract void setPhoneNumber(String number);

    public abstract void usePrepaidHours(int hours);

    public abstract void addPrepaidHours(int hours);
}
