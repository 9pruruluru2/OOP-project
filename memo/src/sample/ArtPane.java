package sample;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ArtPane extends AutoSavePane {
    private ImageView imageView;

    public ArtPane(int i) throws FileNotFoundException {
        imageView = new ImageView();

        pane = new Pane();
        pane.getChildren().add(imageView);
        imageView.fitWidthProperty().bind(pane.widthProperty());
        imageView.fitHeightProperty().bind(pane.heightProperty());

        file = new File("userArt/art_" + i +".png");
        setI(i);
        fileScan();
        addFileWrite();
        createNewScene();
    }

    @Override
    protected void addFileWrite() {

        pane.setOnMouseDragged(event -> {
            if((event.getButton().toString().equals("PRIMARY"))){
                Circle circle = new Circle(event.getX(),event.getY(),5);
                pane.getChildren().add(circle);
            }
            else if((event.getButton().toString().equals("SECONDARY"))){
                Circle circle = new Circle(event.getX(),event.getY(),10);
                circle.setFill(Color.WHITE);
                pane.getChildren().add(circle);
            }

        });
        pane.setOnMouseReleased(event -> {
            saveImage();
            imageView.setImage(new Image(file.toURI().toString()));
            pane.getChildren().remove(1, pane.getChildren().size());});
    }

    @Override
    protected void fileScan() {
        if (file.exists()) {
            imageView.setImage(new Image(file.toURI().toString()));
        }else{
            saveImage();
            imageView.setImage(new Image(file.toURI().toString()));
        }
    }

    @Override
    protected void createNewScene(){
        imageView.setOnKeyPressed(new CreateNewSceneHandler());
    }

    protected void saveImage(){
        WritableImage image = pane.snapshot(new SnapshotParameters(),null);
        File imageFile = file;
        try{
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png",  imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}