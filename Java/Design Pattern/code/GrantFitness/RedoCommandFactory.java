package GrantFitness;

import java.util.Stack;

public class RedoCommandFactory implements CommandFactory {

    Stack<Command> history;
    Stack<Command> redo;

    public RedoCommandFactory(Stack<Command> history, Stack<Command> redo) {
        this.history = history;
        this.redo = redo;
    }

    public Command createCommand() {
        return new RedoCommand(history, redo);
    }

}
