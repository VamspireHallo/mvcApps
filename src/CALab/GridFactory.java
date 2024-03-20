package CALab;

import mvc.*;

import java.util.Random;

public abstract class GridFactory implements AppFactory {

    @Override
    public abstract Model makeModel();

    @Override
    public abstract View makeView(Model model);

    @Override
    public String[] getEditCommands() {
        return new String[0];
    }

    @Override
    public abstract Command makeEditCommand(Model model, String type, Object source);

    @Override
    public abstract String getTitle();

    @Override
    public abstract String[] getHelp();

    @Override
    public abstract String about();
}
