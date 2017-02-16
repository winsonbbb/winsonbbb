package GrantFitness;

import java.util.Stack;

public class UndoCommandFactory implements CommandFactory {

    Stack<Command> history;
    Stack<Command> redo;

    public UndoCommandFactory(Stack<Command> history, Stack<Command> redo) {
        this.history = history;
        this.redo = redo;
    }

    public Command createCommand() {
        return new UndoCommand(history, redo);
    }

}
