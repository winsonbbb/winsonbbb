package GrantFitness;

import java.util.*;

public class CreateCommandFactory implements CommandFactory {

    Vector<CustomerControl> controls;

    public CreateCommandFactory(Vector<CustomerControl> controls) {
        this.controls = controls;
    }

    public Command createCommand() {
        Scanner input = new Scanner(System.in);
        String type = "";
        String data[];
        boolean check = true;
        do {
            System.out.println("Enter company code(gh/gf)");
            type = input.nextLine();
        } while (!(type.equals("gh") || type.equals("gf")));
        do {
            System.out.println("Enter id,name,phone number,hours");
            String info = input.nextLine();
            data = info.split(",");
        } while (data.length != 4);

        while (check) {
            try {
                int hours = Integer.parseInt(data[3]);
                check = false;
                if (hours < 0) {
                    check = true;
                }
            } catch (Exception e) {
                System.out.println("Hours need to be positive integer\n"
                        + "Please input hours again:");
                data[3] = input.nextLine();
            }
        }

        return new CreateCommand(controls, data, type);
    }

}
