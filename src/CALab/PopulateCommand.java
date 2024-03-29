package CALab;

import mvc.*;
public class PopulateCommand extends Command {


    public PopulateCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() throws Exception {
        Grid grid = (Grid) model;
        grid.repopulate(true);
    }
}
