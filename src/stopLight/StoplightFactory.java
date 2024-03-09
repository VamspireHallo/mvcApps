package stopLight;

import java.util.*;

import mvc.*;

public class StoplightFactory implements AppFactory {

    public Model makeModel() { 
        return new Stoplight(); 
    }

    public View makeView(Model m) {
        return new StoplightView((Stoplight) m);
    }

    public String[] getEditCommands() { 
        return new String[] {"Change"}; 
    }

    public Command makeEditCommand(Model model, String type, Object source) {
        if (type.equals("Change")) {
            return new ChangeCommand(model);
        }
        return null;
    }

    public String getTitle() { 
        return "Stop Light Simulator"; 
    }

    public String[] getHelp() {
        return new String[] {"Click Change to cycle through colors"};
    }

    public String about() {
        return "Stoplight Simulator version 1.0. Copyright 2020 by Cyberdellic Designs";
    }

    public Model createModel() {
        return makeModel();
    }

	public View createView(Model model) {
		return makeView(model);
	}

	public List<Command> createEditCommands(Model model) {
		 List<Command> editCommands = new ArrayList<>();
	     editCommands.add(makeEditCommand(model, "Change", null)); 
	     return editCommands;
	}
}
