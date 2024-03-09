package stopLight;

import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import mvc.*;

public class StoplightPanel extends AppPanel implements ActionListener {
    private JButton change;

    public StoplightPanel(AppFactory factory) {
        super(factory);
        change = new JButton("Change");
        change.addActionListener(this); // Registering the panel itself as the ActionListener
        controlPanel.add(change);
        setPreferredSize(new Dimension(400, 300));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ((Stoplight) model).change();
    }

    public static void main(String[] args) {
        AppFactory factory = new StoplightFactory();
        AppPanel panel = new StoplightPanel(factory);
        panel.display();
    }
}
