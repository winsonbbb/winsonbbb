package GrantFitness;

import java.util.*;

public class AddHoursCommandFactory implements CommandFactory {

    Vector<CustomerControl> controls;

    public AddHoursCommandFactory(Vector<CustomerControl> controls) {
        this.controls = controls;
    }

    public Command createCommand() {
        Scanner input = new Scanner(System.in);
        String[] data;
        int hours = 0;
        String id;
        boolean check = true;
        do {
            System.out.println("Enter id,hours");
            String info = input.nextLine();
            data = info.split(",");
            id = data[0];
        } while (data.length != 2);

        while (check) {
            try {
                hours = Integer.parseInt(data[1]);
                check = false;
            } catch (Exception e) {
                System.out.println("Hours need to be integer\n"
                        + "Please input hours again:");
                data[1] = input.nextLine();
            }
        }
        return new AddHoursCommand(controls, id, hours);
    }

}
