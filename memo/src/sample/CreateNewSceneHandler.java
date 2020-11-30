package sample;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class CreateNewSceneHandler implements EventHandler<KeyEvent> {
    private static int textCount=0;
    private static int artCount=-1;

    public void newArt(int i){
        try {
            Parent newPane= new ArtPane(i);
            Stage newStage = new Stage();
            newStage.setTitle("art_"+i+".png");

            Scene scene = new Scene(((ArtPane)newPane).getPane(), 450, 200);

            scene.setOnKeyPressed(new CreateNewSceneHandler());

            newStage.setScene(scene);
            newStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void newText(int i){
        try {
            Parent newPane= new TextPane(i);
            Stage newStage = new Stage();
            newStage.setTitle("text_"+i+".txt");

            Scene scene = new Scene(((TextPane)newPane).getPane(), 450, 200);

            scene.setOnKeyPressed(new CreateNewSceneHandler());

            newStage.setScene(scene);
            newStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void handle(KeyEvent event) {
        if(event.isControlDown() && event.getCode()== KeyCode.valueOf("N")&&!event.isAltDown()){
            newText(++textCount);
            if(textCount==9)textCount=-1;
        }
        else if(event.isControlDown() && event.getCode()== KeyCode.valueOf("N")&&event.isAltDown()){
            newArt(++artCount);
            if(artCount==9)artCount=-1;
        }
        if(event.isControlDown() && event.getCode()==KeyCode.DIGIT0&&!event.isAltDown()){ newText(0); }
        if(event.isControlDown() && event.getCode()==KeyCode.DIGIT1&&!event.isAltDown()){ newText(1); }
        if(event.isControlDown() && event.getCode()==KeyCode.DIGIT2&&!event.isAltDown()){ newText(2); }
        if(event.isControlDown() && event.getCode()==KeyCode.DIGIT3&&!event.isAltDown()){ newText(3); }
        if(event.isControlDown() && event.getCode()==KeyCode.DIGIT4&&!event.isAltDown()){ newText(4); }
        if(event.isControlDown() && event.getCode()==KeyCode.DIGIT5&&!event.isAltDown()){ newText(5); }
        if(event.isControlDown() && event.getCode()==KeyCode.DIGIT6&&!event.isAltDown()){ newText(6); }
        if(event.isControlDown() && event.getCode()==KeyCode.DIGIT7&&!event.isAltDown()){ newText(7); }
        if(event.isControlDown() && event.getCode()==KeyCode.DIGIT8&&!event.isAltDown()){ newText(8); }
        if(event.isControlDown() && event.getCode()==KeyCode.DIGIT9&&!event.isAltDown()){ newText(9); }

        if(event.isControlDown() && event.getCode()==KeyCode.DIGIT0&&event.isAltDown()){ newArt(0); }
        if(event.isControlDown() && event.getCode()==KeyCode.DIGIT1&&event.isAltDown()){ newArt(1); }
        if(event.isControlDown() && event.getCode()==KeyCode.DIGIT2&&event.isAltDown()){ newArt(2); }
        if(event.isControlDown() && event.getCode()==KeyCode.DIGIT3&&event.isAltDown()){ newArt(3); }
        if(event.isControlDown() && event.getCode()==KeyCode.DIGIT4&&event.isAltDown()){ newArt(4); }
        if(event.isControlDown() && event.getCode()==KeyCode.DIGIT5&&event.isAltDown()){ newArt(5); }
        if(event.isControlDown() && event.getCode()==KeyCode.DIGIT6&&event.isAltDown()){ newArt(6); }
        if(event.isControlDown() && event.getCode()==KeyCode.DIGIT7&&event.isAltDown()){ newArt(7); }
        if(event.isControlDown() && event.getCode()==KeyCode.DIGIT8&&event.isAltDown()){ newArt(8); }
        if(event.isControlDown() && event.getCode()==KeyCode.DIGIT9&&event.isAltDown()){ newArt(9); }
    }
}