package mvc;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private boolean unsavedChanges;
    private String fileName;
    private List<Subscriber> subscribers;

    public Model() {
        this.unsavedChanges = false;
        this.fileName = null;
        this.subscribers = new ArrayList<>();
    }

    public boolean getUnsavedChanges() {
        return unsavedChanges;
    }

    public void setUnsavedChanges(boolean unsavedChanges) {
        this.unsavedChanges = unsavedChanges;
        notifySubscribers();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
        notifySubscribers();
    }

    public void changed() {
        unsavedChanges = true;
        notifySubscribers();
    }

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    private void notifySubscribers() {
        for (Subscriber subscriber : subscribers) {
            subscriber.update();
        }
    }
}
