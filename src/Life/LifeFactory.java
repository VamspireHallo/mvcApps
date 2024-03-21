package Life;

import CALab.*;
import mvc.AppFactory;
import mvc.Command;
import mvc.Model;
import mvc.View;

public class LifeFactory extends GridFactory {
    @Override
    public Model makeModel() {
        return new Society();
    }

    @Override
    public View makeView(Model model) {
        return new GridView((Society) model);
    }

    @Override
    public String[] getEditCommands(){ return new String[] {"RUN1", "RUN50","CLEAR","REPOPULATE"}; }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        if (type == "CLEAR")
            return new ClearCommand(model);
        if (type == "REPOPULATE")
            return new PopulateCommand(model);
        if (type == "RUN1")
            return new RunCommand(model, 1);
        if (type == "RUN50")
            return new RunCommand(model, 50);
        return null;
    }
    @Override
    public String getTitle() {
        return "Life Lab";
    }

    @Override
    public String[] getHelp() {
        return new String[] {"Click RUN1 to run the simulation 1 time", "Click RUN50 to run the simulation 50 times", "Click on REPOPULATE to start a new grid","Click on  CLEAR to turn all the cells red"};
    }

    @Override
    public String about() {
        return "CS 151 Life Lab, Group 12, Vamsee, Yossef, and Brynt 2024";
    }
}
