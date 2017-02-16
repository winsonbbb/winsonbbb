package GrantFitness;

import java.util.*;

public class DisplayCommandFactory implements CommandFactory {

    Vector<CustomerControl> controls;

    public DisplayCommandFactory(Vector<CustomerControl> controls) {
        this.controls = controls;
    }

    public Command createCommand() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter id(* to show all)");
        String id = input.nextLine();
        return new DisplayCommand(controls, id);
    }

}
