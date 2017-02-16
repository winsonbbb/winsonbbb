package GrantFitness;

public interface Command {

    public abstract boolean execute();

    public abstract void undo();

    public abstract void redo();
}
