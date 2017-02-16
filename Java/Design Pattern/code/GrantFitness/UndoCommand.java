package GrantFitness;

import java.util.Stack;

public class UndoCommand implements Command {

    Stack<Command> history;
    Stack<Command> redo;

    public UndoCommand(Stack<Command> history, Stack<Command> redo) {
        this.history = history;
        this.redo = redo;
    }

    public boolean execute() {
        if (history.size() > 0) {
            Command command = history.pop();
            redo.add(command);
            command.undo();
            System.out.println("undo completed.\n");
        } else {
            System.out.println("No Record in Undo List!\n");
        }
        return true;

    }

    public void undo() {
    }

    public void redo() {
    }

}
