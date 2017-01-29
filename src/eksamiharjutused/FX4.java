package eksamiharjutused;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.concurrent.ThreadLocalRandom;

public class FX4 extends Application{

    @Override
    public void start(Stage aStage) throws Exception {

        aStage.setTitle("Koristaja");
        Pane pane = new Pane();
        Label text = new Label("Siin on tekst");
        text.setPrefSize(300, 40);
        text.setAlignment(Pos.CENTER);

        pane.setPrefSize(500, 500);
        Scene aScene = new Scene(pane, 500, 500);

        pane.getChildren().add(text);


        for (int i = 0; i < 500; i++) {

            int x = ThreadLocalRandom.current().nextInt(1, 500);
            int y = ThreadLocalRandom.current().nextInt(1, 500);
            Circle ring = new Circle(20);
            ring.setFill(Color.RED);
            pane.getChildren().add(ring);
            ring.relocate(x, y);

        }

        pane.setOnMouseMoved(event -> {

            try{

                Circle ring = (Circle) event.getTarget();
                ring.setFill(Color.TRANSPARENT);

            }catch (ClassCastException ignored){}


        });

        aStage.setScene(aScene);
        aStage.show();

    }
}
