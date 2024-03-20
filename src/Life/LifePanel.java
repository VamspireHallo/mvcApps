package Life;

import CALab.GridFactory;
import mvc.AppFactory;
import mvc.AppPanel;

import javax.swing.*;
import java.awt.*;

public class LifePanel extends AppPanel
{
    private JButton CLEAR;
    private JButton RUN1;
    private JButton RUN50;
    private JButton REPOPULATE;

    public LifePanel(AppFactory factory) {
        super(factory);
        controlPanels.setLayout(new GridLayout(2,2,10, 10));


        RUN1 = new JButton("RUN1");
        RUN1.addActionListener(this);
        controlPanels.add(RUN1);
        RUN50 = new JButton("RUN50");
        RUN50.addActionListener(this);
        controlPanels.add(RUN50);
        CLEAR = new JButton("CLEAR");
        CLEAR.addActionListener(this);
        controlPanels.add(CLEAR);
        REPOPULATE = new JButton("REPOPULATE");
        REPOPULATE.addActionListener(this);
        controlPanels.add(REPOPULATE);
    }
    public static void main(String[] args) {
        GridFactory factory = new LifeFactory();
        AppPanel panel = new LifePanel(factory);
        panel.display();
    }
}
