package Life;

import CALab.GridFactory;
import mvc.AppFactory;
import mvc.Command;
import mvc.Model;
import mvc.View;

public class LifeFactory extends GridFactory {
    @Override
    public Model makeModel() {
        return null;
    }

    @Override
    public View makeView(Model model) {
        return null;
    }

    @Override
    public String[] getEditCommands(){ return new String[] {"RUN1", "RUN50","CLEAR","REPOPULATE"}; }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
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
        return "CS 151 LifeLab Vamsee and Yossef 2024";
    }
}
