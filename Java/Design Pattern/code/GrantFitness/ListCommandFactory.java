package GrantFitness;
import java.util.Stack;

public class ListCommandFactory implements CommandFactory {

    Stack<Command> history;
    Stack<Command> redo;

    public ListCommandFactory(Stack<Command> history, Stack<Command> redo) {
        this.history = history;
        this.redo = redo;
    }

    public Command createCommand() {
        return new ListCommand(history, redo);
    }

}
