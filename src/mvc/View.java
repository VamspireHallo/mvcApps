package mvc;

import javax.swing.*;
import java.awt.*;

public class View extends JPanel implements Subscriber {
    protected Model model;

    public View(Model model) {
        this.model = model;
        model.subscribe(this);
        setBackground(Color.LIGHT_GRAY);
    }

    public void setModel(Model model) {
        this.model.unsubscribe(this);
        this.model = model;
        model.subscribe(this);
        repaint();
    }

    @Override
    public void update() {
        // Called when the model notifies of changes
        repaint();
    }
}
