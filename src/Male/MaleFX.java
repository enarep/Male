package Male;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.util.HashMap;


public class MaleFX extends Application {


    public static void main(String args[]) {
        launch(args);
    }


    @Override
    public void start(Stage aStage) throws Exception {
        aStage.setTitle("Male");

        Group root = new Group();
        Scene aScene = new Scene(root);
        GridPane malelaud = new GridPane();

        root.getChildren().add(malelaud);


        looLaud(malelaud);
        asetaNupud(malelaud);


        aStage.setScene(aScene);
        aStage.show();

    }


    private void looLaud(GridPane malelaud) {

        // loob mustade ja valgete ruutudega laua

        int k = 0;
        int[][] laud = new int[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                if (k % 2 == 0) {   //loendab kas on paaris või paaritu et 0 ja 1 lauale vaheldumisi panna

                    laud[i][j] = 1;
                    Rectangle ruut = new Rectangle(60, 60);
                    ruut.setStroke(Color.GRAY);
                    ruut.setFill(Color.GRAY);
                    malelaud.add(ruut, i, j);


                } else {

                    Rectangle ruut = new Rectangle(60, 60);
                    ruut.setStroke(Color.IVORY);
                    ruut.setFill(Color.IVORY);
                    malelaud.add(ruut, i, j);

                }

                if (j != 7) {
                    k++;             //välja arvatud juhul kui ta on rea lõpus, et read erinevad tuleks
                }
            }
        }


    }

    private void asetaNupud(GridPane malelaud) {

        String[] nupupildid = {
                "ettur0.png",
                "ettur1.png",
                "ratsu0.png",
                "ratsu1.png",
                "vanker0.png",
                "vanker1.png",
                "oda0.png",
                "oda1.png",
                "lipp0.png",
                "lipp1.png",
                "kuningas0.png",
                "kuningas1.png"
        };

        HashMap<Integer, Image> nupud = new HashMap<>();
        HashMap<Integer, ImageView> nupud2 = new HashMap<>();
        HashMap<Integer, HBox> nupud3 = new HashMap<>();

        int j = 0;

        for (int i = 0; i < nupupildid.length; i++) {
            Image imageBuffer = new Image(nupupildid[i]);
            nupud.put(j, imageBuffer);
            ImageView imageViewBuffer = new ImageView(nupud.get(j));
            nupud2.put(j, imageViewBuffer);
            nupud2.get(j).setImage(nupud.get(j));
            HBox hb = new HBox();
            nupud3.put(j, hb);
            nupud3.get(j).setAlignment(Pos.CENTER);
            nupud3.get(j).getChildren().add(nupud2.get(j));
            j++;
        }


        for (int k = 0; k < 8; k++) {
            malelaud.add(nupud3.get(k), k, 1);
        }


    }

}