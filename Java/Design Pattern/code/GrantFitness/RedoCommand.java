package GrantFitness;

import java.util.Stack;

public class RedoCommand implements Command {

    Stack<Command> history;
    Stack<Command> redo;

    public RedoCommand(Stack<Command> history, Stack<Command> redo) {
        this.history = history;
        this.redo = redo;
    }

    public boolean execute() {
        if (redo.size() > 0) {
            Command command = redo.pop();
            history.add(command);
            command.redo();
            System.out.println("redo completed.\n");
        } else {
            System.out.println("No Record in Redo List!\n");
        }
        return true;
    }

    public void undo() {
    }

    public void redo() {
    }

}
