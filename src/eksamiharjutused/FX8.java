package eksamiharjutused;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.concurrent.ThreadLocalRandom;
/**
 * Joonista 500x500 ekraanile ring. Kui hiir ringile vastu läheb, leiab ring omale
 * uue koha. Ei pea animeerima ega midagi fäänsit. Lihtsalt ilmub uues kohas ja kõik.
 * Ehk hiirega saab ringi taga ajada. Kordan - ring leiab uue koha juba hiire puudutusest,
 * mitte klikist. Aga alustada võid muidugi klikist.
 */
public class FX8 extends Application {

    @Override
    public void start(Stage aStage) throws Exception {

        aStage.setTitle("Tagaajamine");
        Pane pane = new Pane();

        pane.setPrefSize(500, 500);
        Scene aScene = new Scene(pane, 500, 500);

        int x = ThreadLocalRandom.current().nextInt(1, 500);
        int y = ThreadLocalRandom.current().nextInt(1, 500);
        Circle ring = new Circle(20);
        ring.setFill(Color.CHARTREUSE);
        pane.getChildren().add(ring);
        ring.relocate(x, y);



        pane.setOnMouseMoved(event -> {


            try{
                int z = ThreadLocalRandom.current().nextInt(1, 500);
                int w = ThreadLocalRandom.current().nextInt(1, 500);
                Circle rin = (Circle) event.getTarget();
                rin.relocate(z, w);

            }catch (ClassCastException ignored){}


        });

        aStage.setScene(aScene);
        aStage.show();

    }
}