package GrantFitness;

public class ExitCommand implements Command {

    public boolean execute() {
        System.out.println("\n\nLeaving System...");
        System.exit(0);
        return true;
    }

    public void undo() {
    }

    public void redo() {
    }
}
