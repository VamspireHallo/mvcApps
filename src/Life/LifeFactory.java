package Life;

import CALab.*;
import mvc.AppFactory;
import mvc.Command;
import mvc.Model;
import mvc.View;

public class LifeFactory extends GridFactory {
    @Override
    public Model makeModel() {
        return new Grid();
    }

    @Override
    public View makeView(Model model) {
        return null;
    }

    @Override
    public String[] getEditCommands(){ return new String[] {"RUN1", "RUN50","CLEAR","REPOPULATE"}; }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        if (type == "CLEAR")
            return new ClearCommand(model);
        if (type == "REPOPULATE")
            return new PopulateCommand(model, true);
        if (type == "RUN1")
            return new RunCommand(model, 1);
        if (type == "RUN50")
            return new RunCommand(model, 50);
        return null;
    }
    @Override
    public String getTitle() {
        return "LifeLab";
    }

    @Override
    public String[] getHelp() {
        return new String[] {"Click on repopulate to start a new grid","Click on  CLEAR to turn all the cells red", "Click RUN1 to run the simulation"};
    }

    @Override
    public String about() {
        return "CS 151 LifeLab Vamsee, Yossef, and Brynt 2024";
    }
}
