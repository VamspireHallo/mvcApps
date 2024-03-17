package mvc;

import javax.swing.*;
import java.awt.*;

public class View extends JPanel implements Subscriber {
    protected Model model;

    public View(Model model) {
        this.model = model;
        model.subscribe(this);
    }

    public void setModel(Model model) {
        this.model.unsubscribe(this);
        this.model = model;
        model.subscribe(this);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the view based on the model's data
        // For simplicity, let's just draw a text indicating the unsaved changes
        if (model.getUnsavedChanges()) {
            g.setColor(Color.RED);
            g.drawString("Unsaved Changes", 10, 20);
        }
    }

    @Override
    public void update() {
        // Called when the model notifies of changes
        repaint();
    }
}
