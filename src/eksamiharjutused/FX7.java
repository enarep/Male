package eksamiharjutused;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import static java.lang.Integer.parseInt;

/**
 * Küsi kasutajalt alguskordinaadid ja laius-kõrgus ning joonista talle ristkülik.
 * Küsi kasutajalt sisendit kuidas soovid, pealselt, et teed seda JavaFXis.
 */

public class FX7 extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Ristkylik");
        GridPane grid = new GridPane();
        Scene primaryScene = new Scene(grid, 500, 500);

        VBox box = new VBox();
        box.setSpacing(10);
        box.setAlignment(Pos.CENTER_LEFT);

        Pane pane = new Pane();
        pane.setPrefSize(500,500);
        box.getChildren().add(pane);

        Label pealkiri = new Label("Ristkylik --> xxx, yyy, www, hhh");

        TextField koord = new TextField();
        koord.setMaxWidth(200);


        Button sisesta = new Button("Sisesta");
        sisesta.setPrefSize(100,30);
        sisesta.setTextFill(Color.BLACK);

        box.getChildren().addAll(pealkiri,koord,sisesta);


        grid.getChildren().addAll(box);
        sisesta.setOnAction(event -> {

            Rectangle rk = new Rectangle(nupuVajutus(koord)[2], nupuVajutus(koord)[3]);

            rk.relocate(nupuVajutus(koord)[0], nupuVajutus(koord)[1]);
            rk.setFill(Color.BLACK);
            pane.getChildren().add(rk);


        });


        primaryStage.setScene(primaryScene);
        primaryStage.show();

    }

    private double[] nupuVajutus(TextField koord) {

        double[] f = new double[4];
        String x = koord.getText();
        f[0] = (double) parseInt(x.substring(0, 3));
        f[1] = (double) parseInt(x.substring(5, 8));
        f[2] = (double) parseInt(x.substring(10, 13));
        f[3] = (double) parseInt(x.substring(15, 18));

        return f;
    }

}