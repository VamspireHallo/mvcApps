package Life;

import CALab.GridFactory;
import mvc.AppFactory;
import mvc.AppPanel;
import stopLight.StoplightPanel;

import javax.swing.*;

public class Lifelab extends AppPanel
{
    private JButton CLEAR;
    private JButton RUN1;
    private JButton RUN50;
    private JButton REPOPULATE;

    public Lifelab(AppFactory factory) {
        super(factory);
        CLEAR = new JButton("CLEAR");
        CLEAR.addActionListener(this);
        controlPanels.add(CLEAR);
        RUN1 = new JButton("RUN1");
        RUN1.addActionListener(this);
        controlPanels.add(RUN1);
        RUN50 = new JButton("RUN50");
        RUN50.addActionListener(this);
        controlPanels.add(RUN50);
        REPOPULATE = new JButton("REPOPULATE");
        REPOPULATE.addActionListener(this);
        controlPanels.add(REPOPULATE);
    }
    public static void main(String[] args) {
        GridFactory factory = new LifeFactory();
        AppPanel panel = new Lifelab(factory);
        panel.display();
    }
}
