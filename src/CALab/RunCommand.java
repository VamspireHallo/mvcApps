package CALab;

import mvc.*;
public class RunCommand extends Command {
    private final int cycles;
    public RunCommand(Model model, int cycles) {
        super(model);
        this.cycles = cycles;
    }

    @Override
    public void execute() throws Exception {
        if (model instanceof Grid) {
            Grid grid = (Grid) model;
            grid.updateLoop(cycles);
        } else {
            System.out.println("Error: Grid Not Runnable");
        }
    }
}
