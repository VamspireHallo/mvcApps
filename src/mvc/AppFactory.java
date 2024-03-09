package mvc;

import java.util.List;

public interface AppFactory {
    // Method to create a model instance
    Model createModel();

    // Method to create a view instance
    View createView(Model model);

    // Method to create commands for the Edit menu
    List<Command> createEditCommands(Model model);
}
