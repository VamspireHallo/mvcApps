package CALab;

import mvc.*;
public class PopulateCommand extends Command {
    private boolean random = false;

    public PopulateCommand(Model model, boolean random) {
        super(model);
        this.random = random;
    }

    @Override
    public void execute() throws Exception {
        if (model instanceof Grid) {
            Grid grid = (Grid) model;
            grid.repopulate(random);
        }
        else
        {
            System.out.println("Error: Cannon Print Grid");
        }
    }
}
