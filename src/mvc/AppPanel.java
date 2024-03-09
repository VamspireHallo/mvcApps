package mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AppPanel extends JPanel {

    private AppFactory factory;
    private View view;
    protected Model model;
    private List<Command> editCommands;
    protected ControlPanel controlPanel;

    public AppPanel(AppFactory factory) {
        this.factory = factory;
        this.model = factory.createModel();
        this.view = factory.createView(model);
        this.editCommands = factory.createEditCommands(model);

        // Set layout for the AppPanel
        setLayout(new BorderLayout());

        // Add the view to the center of the AppPanel
        add(view, BorderLayout.CENTER);

        // Create and add the control panel to the south of the AppPanel
        controlPanel = new ControlPanel(editCommands);
        add(controlPanel, BorderLayout.SOUTH);
    }

    public void display() {
        JFrame frame = new JFrame("MVC Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
    }

    // Getter method for the controlPanel
    public ControlPanel getControlPanel() {
        return controlPanel;
    }

    public class ControlPanel extends JPanel {

        public ControlPanel(List<Command> editCommands) {
            // Set layout for the control panel
            setLayout(new FlowLayout());

            // Create buttons for each edit command
            for (Command command : editCommands) {
                JButton button = new JButton(command.getClass().getSimpleName());
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            command.execute();
                        } catch (Exception ex) {
                            // Handle exceptions
                            Utilities.error(ex);
                        }
                    }
                });
                add(button);
            }
        }
    }
}
