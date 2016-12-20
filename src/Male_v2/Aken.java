package Male_v2;


import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import static Male_v2.Game.k2ik;


public class Aken {

    Scene aScene;
    Stage aStage;
    Group root;
    Group laud;
    GridPane malelaud;
    static GridPane muutuvlaud;
    TextArea logi;
    static TextField sisend;
    VBox vb;
    Button btn;



    //int[] test = {0, 1};

    Aken(){

        looAken();
        new Nupud();
        new Laud();







    }

    private void looIO() {

        logi = new TextArea();

        logi.setPrefRowCount(4);
        logi.setEditable(false);
        logi.setWrapText(true);
        log("test");

        sisend = new TextField();

        btn = new Button("Sisesta käik");


        Platform.runLater(() -> sisend.requestFocus());

    }

    public void looAken() {

        root = new Group();
        laud = new Group();
        aStage = new Stage();
        aScene = new Scene(root);
        malelaud = new GridPane();
        laud.getChildren().add(malelaud);
        muutuvlaud = new GridPane();
        laud.getChildren().add(muutuvlaud);
        aStage.setTitle("Male");

        looLaud(malelaud, muutuvlaud);
        looIO();

        vb = new VBox();
        vb.getChildren().addAll(laud, logi, sisend, btn);
        vb.setSpacing(10);
        vb.setPadding(new Insets(10, 0, 10, 0));

        root.getChildren().addAll(vb);

        aStage.setScene(aScene);
        aStage.show();

        final Task task;
        task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {


                System.out.println(k2ik()[0]);



                return null;
            }
        };

        btn.setOnAction(event -> new Thread(task).start());





    }




    private void looLaud(GridPane malelaud, GridPane muutuvlaud) {

        int k = 0;
        int[][] laud = new int[8][8];

        //malelaud

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                if (k % 2 == 0) {   //loendab kas on paaris või paaritu et 0 ja 1 lauale vaheldumisi panna

                    laud[i][j] = 1;
                    Rectangle ruut = new Rectangle(60, 60);
                    ruut.setStroke(Color.GRAY);
                    ruut.setFill(Color.GRAY);
                    Text t = new Text("" + (j+1) + (i+1));
                    t.setTextAlignment(TextAlignment.LEFT);
                    malelaud.add(ruut, i, j);
                    malelaud.add(t, i, j);




                }else{

                    Rectangle ruut = new Rectangle(60, 60);
                    ruut.setStroke(Color.IVORY);
                    ruut.setFill(Color.IVORY);
                    Text t = new Text("" + (j+1) + (i+1));
                    t.setTextAlignment(TextAlignment.LEFT);
                    malelaud.add(ruut, i, j);
                    malelaud.add(t, i, j);


                }

                if (j != 7) {
                    k++;             //välja arvatud juhul kui ta on rea lõpus, et read erinevad tuleks
                }
            }
        }

        //muutuvlaud

        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){

                Rectangle ruut = new Rectangle(60, 60);
                ruut.setStroke(Color.TRANSPARENT);
                ruut.setFill(Color.TRANSPARENT);
                muutuvlaud.add(ruut, i, j);


            }
        }


    }

    private void log(String logitekst) {

        logi.appendText(logitekst + "\n");

    }





}
