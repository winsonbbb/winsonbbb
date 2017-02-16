import GoodHealth.MemberCare;
import GreenFitness.ClientControl;
import GrantFitness.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Vector<CustomerControl> controls = new Vector();
        controls.add(new ClientControlAdapter(new ClientControl()));
        controls.add(new MemberControlAdapter(new MemberCare()));
        Stack<Command> history = new Stack<Command>();
        Stack<Command> redo = new Stack<Command>();
        CommandFactory[] cf = new CommandFactory[0];
        String[] choose = {"n", "d", "a", "s", "c", "u", "r", "l", "q"};
        int option = 0;
        try {
            cf = new CommandFactory[]{
                new CreateCommandFactory(controls),
                new DisplayCommandFactory(controls),
                new AddHoursCommandFactory(controls),
                new SpendHoursCommandFactory(controls),
                new ChangePhoneCommandFactory(controls),
                new UndoCommandFactory(history, redo),
                new RedoCommandFactory(history, redo),
                new ListCommandFactory(history, redo),
                new ExitCommandFactory()
            };
        } catch (Exception ex) {

        }
        try {
            while (true) {
                System.out.println("GrantFitness Control System");
                System.out.println("Please enter command:[n|d|a|s|c|u|r|l|q]");
                System.out.println("n = create member, d = display member details, "
                        + "a = add hours, s = spend hours,\n"
                        + "c = change phone number, u = undo, r = redo, l = list undo/redo, "
                        + "q = quit system");
                System.out.print("Enter command:\n");
                String line = input.nextLine();
                for (int i = 0; i < choose.length; i++) {
                    if (line.equals(choose[i])) {

                        option = i;
                        break;
                    } else {
                        option = -1;
                    }
                }
                try {
                    Command c = cf[option].createCommand();
                    boolean check = c.execute();
                    if (check && !(option == 1 || option >= 5)) {
                        history.push(c);
                    }

                } catch (Exception ex) {
                    System.out.println("Invalid Option...\nPlease choose again!!");
                }
            }
        } catch (Exception e) {
            System.out.println("*** " + e.getMessage());
        }

    }

}
