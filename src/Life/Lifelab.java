package Life;

import CALab.GridFactory;
import mvc.AppFactory;
import mvc.AppPanel;
import stopLight.StoplightFactory;
import stopLight.StoplightPanel;

import javax.swing.*;

public class Lifelab extends AppPanel
{

    public Lifelab(AppFactory factory) {
        super(factory);
    }
    public static void main(String[] args) {
        GridFactory factory = new LifeFactory();
        AppPanel panel = new StoplightPanel(factory);
        panel.display();
    }
}
