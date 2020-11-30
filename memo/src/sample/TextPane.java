package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TextPane extends AutoSavePane {
    TextArea textArea;

    TextPane(int i) throws FileNotFoundException {
        textArea = new TextArea();
        pane = new Pane();
        pane.getChildren().add(textArea);
        textArea.prefWidthProperty().bind(pane.widthProperty());
        textArea.prefHeightProperty().bind(pane.heightProperty());

        file = new File("userText/text_" + i +".txt");
        setI(i);
        fileScan();
        addFileWrite();
        createNewScene();
    }

    @Override
    protected void addFileWrite() {
        textArea.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {
                try {
                    FileWriter fw = new FileWriter(file);
                    fw.write(newValue);
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public TextArea getTextArea() {
        return textArea;
    }


    @Override
    protected void fileScan() throws FileNotFoundException{
        if (file.exists()) {
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                textArea.setText(textArea.getText() + sc.nextLine() +"\n");
            }
            sc.close();
        }
    }
    @Override
    protected void createNewScene(){
        pane.setOnKeyPressed(new CreateNewSceneHandler());
    }
}