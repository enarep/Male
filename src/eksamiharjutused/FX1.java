package eksamiharjutused;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by tmp145 on 25.01.2017.
 */
public class FX1 extends Application{

    /**
     * Tee JavaFXiga detektiivi mäng, kus kasutaja saab nähtamatuid ringe otsida.
     * 1. Ekraanil (näiteks 500x500) on suvalistes kohtades 3 ringi, mida näha ei ole.
     * 2. Hiirega ringile vastu minnes tuleb ring nähtavale.
     */


    @Override
    public void start(Stage aStage) throws Exception {

        aStage.setTitle("Detektiiv");
        Group root = new Group();
        Scene aScene = new Scene(root);
        GridPane pallimeri = new GridPane();

        root.getChildren().add(pallimeri);

        int[] ringid = new int[6];
        int m = 0;

        for (int k = 0; k < 3; k++){

            int i = ThreadLocalRandom.current().nextInt(1, 20);
            int j = ThreadLocalRandom.current().nextInt(1, 20);
            Circle ring = new Circle(30);
            ring.setStroke(Color.TRANSPARENT);
            ring.setFill(Color.TRANSPARENT);

            pallimeri.add(ring, i, j);
            ringid[k+m] = GridPane.getColumnIndex(ring);
            m++;
            ringid[k+m] = GridPane.getRowIndex(ring);

        }



        pallimeri.setOnMousePressed(event -> {

            try {
                Circle ring = (Circle) event.getTarget();

                int x = GridPane.getColumnIndex(ring);
                int y = GridPane.getRowIndex(ring);

                if ((x == ringid[0] && y == ringid[1]) || (x == ringid[2] && y == ringid[3]) || (x == ringid[4] && y == ringid[5])){


                    ring.setFill(Color.BLACK);
                    System.out.println("jee");

                }

            }catch (ClassCastException ignored){}

        });





        aStage.setScene(aScene);
        aStage.show();


    }



}
