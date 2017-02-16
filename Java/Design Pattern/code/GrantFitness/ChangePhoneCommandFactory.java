package GrantFitness;

import java.util.Scanner;
import java.util.Vector;

public class ChangePhoneCommandFactory implements CommandFactory {

    Vector<CustomerControl> controls;

    public ChangePhoneCommandFactory(Vector<CustomerControl> controls) {
        this.controls = controls;
    }

    public Command createCommand() {
        Scanner input = new Scanner(System.in);
        String data[];
        String id;
        String phone;
        do {
            System.out.println("Enter id,new phone number");
            String info = input.nextLine();
            data = info.split(",");
            id = data[0];
            phone = data[1];
        } while (data.length != 2);
        return new ChangePhoneCommand(controls, id, phone);
    }
}
