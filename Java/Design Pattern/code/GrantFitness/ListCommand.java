package GrantFitness;

import java.util.Stack;

public class ListCommand implements Command {

    Stack<Command> history;
    Stack<Command> redo;

    public ListCommand(Stack<Command> history, Stack<Command> redo) {
        this.history = history;
        this.redo = redo;
    }

    public boolean execute() {
        System.out.println("Undo List:");
        for (int i = 0; i < history.size(); i++) {
            System.out.println(history.get(i));
        }
        System.out.println("\nRedo List");
        for (int i = 0; i < redo.size(); i++) {
            System.out.println(redo.get(i));
        }
        System.out.println("");
        return true;
    }

    public void undo() {
    }

    public void redo() {
    }

}
