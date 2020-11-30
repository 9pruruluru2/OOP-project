package sample;

import javafx.scene.layout.Pane;

import java.io.File;

abstract class AutoSavePane extends Pane {
    protected int i;
    protected Pane pane;
    protected File file;

    protected AutoSavePane(){}

    protected abstract void addFileWrite();
    protected abstract void fileScan() throws Exception;
    protected abstract void createNewScene();

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
    public Pane getPane(){
        return pane;
    }
}