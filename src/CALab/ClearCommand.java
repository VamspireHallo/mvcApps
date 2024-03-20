package CALab;

import mvc.*;
public class ClearCommand extends Command {

    public ClearCommand(Model model) {
        super(model);
    }
    @Override
    public void execute() throws Exception {
        Grid grid = (Grid) model;
        grid.repopulate(false);
        grid.observe();
    }
}
