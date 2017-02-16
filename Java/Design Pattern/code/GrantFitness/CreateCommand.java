package GrantFitness;

import GreenFitness.*;
import GoodHealth.*;
import java.util.*;

public class CreateCommand implements Command {

    private int company;
    private String id;
    private String name;
    private String phone;
    private int hours;
    Vector<CustomerControl> controls;

    public CreateCommand(Vector<CustomerControl> controls, String[] data, String type) {
        this.controls = controls;
        this.id = data[0];
        this.name = data[1];
        this.phone = data[2];
        this.hours = Integer.parseInt(data[3]);
        if (type.equals("gf")) {
            company = 0;
        } else {
            company = 1;
        }

    }

    public boolean execute() {
        controls.get(company).createMember(id, name);
        controls.get(company).addPrepaidHours(id, hours);
        controls.get(company).changePhoneNumber(id, phone);
        System.out.println("Created new member record.\n");
        return true;
    }

    public void undo() {
        controls.get(company).removeMember(id);
    }

    public void redo() {
        controls.get(company).createMember(id, name);
        controls.get(company).addPrepaidHours(id, hours);
        controls.get(company).changePhoneNumber(id, phone);
    }

    public String toString() {
        return "New " + id;
    }

}
