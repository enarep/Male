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
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import static java.lang.Integer.parseInt;

/**
 * Küsi kasutajalt x, y kordinaadid ja raadius ning joonista talle ring.
 * Küsi kasutajalt sisendit kuidas soovid, pealselt, et teed seda JavaFXis.
 */
public class FX6 extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Ring");
        GridPane grid = new GridPane();
        Scene primaryScene = new Scene(grid, 500, 500);

        VBox box = new VBox();
        box.setSpacing(10);
        box.setAlignment(Pos.CENTER_LEFT);

        Pane pane = new Pane();
        pane.setPrefSize(500,500);
        box.getChildren().add(pane);

        Label pealkiri = new Label("Ringi raadius, koordinaadid --> xxx, yyy, rrr");

        TextField koord = new TextField();
        koord.setMaxWidth(200);


        Button sisesta = new Button("Sisesta");
        sisesta.setPrefSize(100,30);
        sisesta.setTextFill(Color.BLACK);

        box.getChildren().addAll(pealkiri,koord,sisesta);


        grid.getChildren().addAll(box);
        sisesta.setOnAction(event -> {

            nupuVajutus(koord);
            Circle ring = new Circle(nupuVajutus(koord)[0], nupuVajutus(koord)[1], nupuVajutus(koord)[2]);
            pane.getChildren().add(ring);

        });


        primaryStage.setScene(primaryScene);
        primaryStage.show();

    }

    private double[] nupuVajutus(TextField koord) {

        double[] f = new double[3];
        String x = koord.getText();
        f[0] = (double) parseInt(x.substring(0, 3));
        f[1] = (double) parseInt(x.substring(5, 8));
        f[2] = (double) parseInt(x.substring(10, 12));

        return f;
    }

}