package eksamiharjutused;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Joonista ekraanile hunnik ristkülikuid, suvalistel positsioonidel. Ühe korra kastile klikates
 * muutub ta 2x väiksemaks. Teist korda klikates kaob ta sootuks.
 */
public class FX5 extends Application {

    @Override
    public void start(Stage aStage) throws Exception {

        aStage.setTitle("PixelChaser");
        Pane pane = new Pane();

        pane.setPrefSize(500, 500);
        Scene aScene = new Scene(pane, 500, 500);




        for (int i = 0; i < 10; i++) {

            int x = ThreadLocalRandom.current().nextInt(1, 500);
            int y = ThreadLocalRandom.current().nextInt(1, 500);
            Rectangle ruut = new Rectangle(50, 50);
            ruut.setFill(Color.CHARTREUSE);
            pane.getChildren().add(ruut);
            ruut.relocate(x, y);

        }

        pane.setOnMousePressed(event -> {


            try{
                Rectangle ruut = (Rectangle) event.getTarget();
                if (ruut.getId() != "x") {
                    ruut.setId("x");
                    ruut.setScaleX(0.5);
                    ruut.setScaleY(0.5);
                }else{
                    ruut.setFill(Color.TRANSPARENT);
                }

            }catch (ClassCastException ignored){}


        });

        aStage.setScene(aScene);
        aStage.show();

    }
}
