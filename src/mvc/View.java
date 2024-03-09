package mvc;

import javax.swing.*;
import java.awt.*;

public class View extends JPanel {

    protected Model model;

    public View(Model model) {
        this.model = model;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the view based on the model's data
        // This method is called automatically whenever the panel needs to be repainted

        // Example drawing code:
        g.setColor(Color.RED);
        g.fillRect(50, 50, 100, 100); // Draw a red rectangle at (50, 50) with width 100 and height 100
    }
}
