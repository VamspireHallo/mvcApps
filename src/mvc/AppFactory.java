package mvc;

import java.util.List;

public interface AppFactory {
    // Method to create a model instance
    Model makeModel();

    // Method to create a view instance
    View makeView(Model model);

    // Method to create commands for the Edit menu
    String[] getEditCommands();
}
