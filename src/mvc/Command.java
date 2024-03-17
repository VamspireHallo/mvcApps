package mvc;

public abstract class Command {
    protected Model model;

    public Command(Model model) {
        this.model = model;
    }

    // Abstract method for executing the command
    public abstract void execute() throws Exception;
}
