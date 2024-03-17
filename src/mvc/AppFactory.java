package mvc;

import java.util.List;

public interface AppFactory {
    // Method to create a model instance
    public Model makeModel();

    // Create and return a new instance of the view, given the model
    public View makeView(Model model);

    // Get the edit commands available in the application
    public String[] getEditCommands();

    // Create and return a command object based on the command type and source
    public Command makeEditCommand(Model model, String type, Object source);

    // Get the title of the application
    public String getTitle();

    // Get the help information for the application
    public String[] getHelp();

    // Get information about the application
    public String about();
}
