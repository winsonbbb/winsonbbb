package GrantFitness;

import java.util.Scanner;
import java.util.Vector;

public class SpendHoursCommandFactory implements CommandFactory {

    Vector<CustomerControl> controls;

    public SpendHoursCommandFactory(Vector<CustomerControl> controls) {
        this.controls = controls;
    }

    public Command createCommand() {
        Scanner input = new Scanner(System.in);
        String[] data;
        String id;
        int hours = 0;
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
                if (hours < 0) {
                    check = true;
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Hours need to be integer\n"
                        + "Please input hours again:");
                data[1] = input.nextLine();
            }
        }
        return new SpendHoursCommand(controls, id, hours);
    }

}
