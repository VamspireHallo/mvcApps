package mvc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Model extends Publisher implements Serializable {
    private boolean unsavedChanges;
    private String fileName;

    public Model() {
        this.unsavedChanges = false;
        this.fileName = null;
    }

    public boolean getUnsavedChanges() {
        return unsavedChanges;
    }

    public void setUnsavedChanges(boolean unsavedChanges) {
        this.unsavedChanges = unsavedChanges;
        this.notifySubscribers();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
        this.notifySubscribers();
    }

    public void changed() {
        unsavedChanges = true;
        this.notifySubscribers();
    }
}
