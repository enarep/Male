package eksamiharjutused;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.Optional;

import static java.lang.Integer.parseInt;


public class FX3 extends Application{

    /**
     * Küsi kasutajalt alguse ja lõpu x-y kordinaadid ning joonista talle joon.
     * Akna võime limiteerida 500x500 piksli peale.
     * Küsi kasutajalt sisendit kuidas soovid, pealselt, et teed seda JavaFXis.
     */

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Joon");
        GridPane grid = new GridPane();
        Scene primaryScene = new Scene(grid, 500, 500);


        VBox box = new VBox();
        box.setSpacing(10);
        box.setAlignment(Pos.CENTER_LEFT);

        VBox box2 = new VBox();


        Label pealkiri = new Label("Joone parameetrid -> xx, yy, xx, yy");

        TextField koord = new TextField();
        koord.setMaxWidth(200);


        Button sisesta = new Button("Sisesta");
        sisesta.setPrefSize(100,30);
        sisesta.setTextFill(Color.BLACK);

        box.getChildren().addAll(pealkiri,koord,sisesta, box2);


        grid.getChildren().addAll(box);
        sisesta.setOnAction(event -> {

            nupuVajutus(koord);
            Line joon = new Line(nupuVajutus(koord)[0], nupuVajutus(koord)[1], nupuVajutus(koord)[2], nupuVajutus(koord)[3]);
            box2.getChildren().add(joon);

        });


        primaryStage.setScene(primaryScene);
        primaryStage.show();

    }

    private double[] nupuVajutus(TextField koord) {

        double[] f = new double[4];
        String x = koord.getText();
        f[0] = (double) parseInt(x.substring(0, 2));
        f[1] = (double) parseInt(x.substring(4, 6));
        f[2] = (double) parseInt(x.substring(8, 10));
        f[3] = (double) parseInt(x.substring(12, 14));

        return f;
    }

}
