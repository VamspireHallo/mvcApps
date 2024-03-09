package mvc;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class Model {
    private String fileName;
    private boolean unsavedChanges;
    private PropertyChangeSupport propertyChangeSupport;

    public Model() {
        fileName = null;
        unsavedChanges = false;
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    // Getters and setters for fileName and unsavedChanges

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean getUnsavedChanges() {
        return unsavedChanges;
    }

    public void setUnsavedChanges(boolean unsavedChanges) {
        this.unsavedChanges = unsavedChanges;
    }

    // Method to fire property change event
    protected void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
        propertyChangeSupport.firePropertyChange(propertyName, oldValue, newValue);
    }

    // Method to add property change listener
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    // Method to remove property change listener
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    protected void changed() {
        unsavedChanges = true;
        firePropertyChange("unsavedChanges", false, true);
    }

    // Abstract method for model-specific operations
    public abstract void performOperation();
}
