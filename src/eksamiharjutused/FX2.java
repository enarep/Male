package eksamiharjutused;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.concurrent.ThreadLocalRandom;



/**
 * Created by tmp145 on 25.01.2017.
 */
public class FX2 extends Application{
    /**
     * Joonista 500x500 ekraanile hunnikuga punaseid ringe.
     * Kui hiir ringile vastu läheb, muutub ring roheliseks.
     * Kordan - ring muudab värvi juba hiire puudutusest, mitte klikist.
     */

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage aStage) throws Exception {

        aStage.setTitle("Unenaofoor");
        Group root = new Group();
        Scene aScene = new Scene(root, 500, 500);
        GridPane pallimeri = new GridPane();

        root.getChildren().add(pallimeri);


        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {

                Circle ring = new Circle(30);
                ring.setStroke(Color.RED);
                ring.setFill(Color.RED);
                pallimeri.add(ring, i, j);
            }
        }

        pallimeri.setOnMouseMoved(event -> {

            try{

                Circle ring = (Circle) event.getTarget();
                ring.setFill(Color.GREEN);

            }catch (ClassCastException ignored){}


        });

        aStage.setScene(aScene);
        aStage.show();

    }
}
