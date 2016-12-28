package Male_v2;


import javafx.application.Platform;
import javafx.concurrent.Service;
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

import java.util.HashMap;
import java.util.Scanner;

import static Male_v2.Game.k2ik;
import static Male_v2.Laud.nupumap;
import static Male_v2.Nupud.ettur10;
import static Male_v2.Nupud.initNupud;
import static Male_v2.Nupud.malendid;


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
    String welcome = "Käimiseks kirjuta allolevasse kasti " +
            "soovitav manööver neljakohalise numbrina, kus esimesed kaks " +
            "tähistavad algus- ja viimased kaks lõpuruutu.";

    boolean firstMove = true;
    int kelleKord = 0;
    int turnCounter = 1;
    int[][] lauaseis;




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
        log(welcome);

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

        btn.setOnAction(event -> male());





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

        logi.appendText(">" + logitekst + "\n");

    }

    public void male(){

        // LAUA LOOMINE

        // loob mustade ja valgete ruutudega laua

        if(firstMove) {
            int k = 0;
            int[][] laud = new int[8][8];

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {

                    if (k % 2 == 0) {   //loendab kas on paaris või paaritu et 0 ja 1 lauale vaheldumisi panna
                        laud[i][j] = 1;
                    }

                    if (j != 7) {
                        k++;             //välja arvatud juhul kui ta on rea lõpus, et read erinevad tuleks
                    }
                }
            }


            // LAUA PRINTIMINE


            for (int rida = 0; rida < laud.length; rida++) {
                for (int veerg = 0; veerg < laud[rida].length; veerg++) {
                    System.out.print(laud[rida][veerg] + "\t");
                }
                System.out.println();
            }

            System.out.println();

            // MÄNGULAUD


            // loob kahemõõtmelise massiivi nuppude asukohtade jaoks
            lauaseis = new int[][]{{2, 3, 4, 5, 6, 7, 8, 9}, {10, 11, 12, 13, 14, 15, 16, 17}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {18, 19, 20, 21, 22, 23, 24, 25}, {26, 27, 28, 29, 30, 31, 32, 33}};

            for (int rida2 = 0; rida2 < lauaseis.length; rida2++) {
                for (int veerg2 = 0; veerg2 < lauaseis[rida2].length; veerg2++) {
                    System.out.print(lauaseis[rida2][veerg2] + "\t");
                }
                System.out.println();
            }

            //MÄNGU KÄIK


            int x = 0;

        }


        firstMove = false;


        while (true) {

            System.out.println(turnCounter + ". ring");
            if (kelleKord == 0) {
                System.out.println("Valgete kord");
                mustTuleTabel(lauaseis);

            } else {
                System.out.println("Mustade kord");
                valgeTuleTabel(lauaseis);

            }

            // klaviatuuriga sisestatakse käik


            // while tsükli sees talle ei meeldinud nende muutujate deklareerimine
            int akt2;
            int akt1;
            Scanner sisend = new Scanner(System.in);
            int käik;
            int[] käik2 = new int[2];
            int aktiivneNupp;
            int v6etavNupp;
            int kuhu1;
            int kuhu2;
            int värv;
            int värv2;
            String nupp = "";

            sisemineWhile:
            while (true) {



                //System.out.print("Sisesta soovitud käik: ");

                käik = k2ik();



                // käik lõhutakse ära ja lisatakse massiivi
                käik2[0] = käik / 100;
                käik2[1] = (käik - käik2[0] * 100);

                // prindib välja käigu (hiljem ümber tõlgitud koordinaatidega ilmselt)
                for (int c = 0; c < käik2.length; c++) {
                    System.out.print(käik2[c]);
                    if (c == 0) {
                        System.out.print(" --> ");
                    } else {
                        System.out.println();
                    }
                }

                //valib aktiivse nupu esimese numbri järgi
                akt2 = käik2[0] % 10;
                akt1 = (käik2[0] - akt2) / 10;
                aktiivneNupp = lauaseis[akt1 - 1][akt2 - 1];

                System.out.println("Tahad käia nupuga " + aktiivneNupp);

                String logisse1 = "Tahad teostada järgnevat manöövrit: ";
                String logisse2 = "";
                String logisse = logisse1 + käik2;
                log(logisse);
                log("");

                if(aktiivneNupp == 0){
                    System.out.println("Nii ei saa");
                    log("Nii ei saa");
                    return;
                }
                //käiguKontroll
                // v'rvi kontroll

                värv = initNupud().get(aktiivneNupp).värv;  //värvi ei saanud miskipärast otse käiguKontrolli meetodi seest kätte

                if (värv != kelleKord) {
                    System.out.println("Proovi ikka oma nupuga");
                    log("Proovi ikka oma nupuga");
                    return;
                }


                //System.out.println("Värv: " + värv);

                kuhu2 = käik2[1] % 10;
                kuhu1 = (käik2[1] - kuhu2) / 10;

                v6etavNupp = lauaseis[kuhu1 - 1][kuhu2 - 1];


                System.out.println("võetavnupp on: " + v6etavNupp);
                if (v6etavNupp != 0) {                              //värv2 on siis sihtmärgi värv
                    värv2 = initNupud().get(v6etavNupp).värv;
                } else {
                    värv2 = Math.abs(värv - 1);                        //kui on tühi ruut siis on lihtsalt vastandvärv
                }

                //otsib välja mis tüüpi nupp on


                if (aktiivneNupp > 9 && aktiivneNupp < 26) {
                    nupp = "etturKlass";

                } else if (aktiivneNupp == 3 || aktiivneNupp == 8 || aktiivneNupp == 27 || aktiivneNupp == 32) {
                    nupp = "ratsuKlass";

                } else if (aktiivneNupp == 2 || aktiivneNupp == 9 || aktiivneNupp == 26 || aktiivneNupp == 33) {
                    nupp = "vankerKlass";

                } else if (aktiivneNupp == 4 || aktiivneNupp == 7 || aktiivneNupp == 28 || aktiivneNupp == 31) {
                    nupp = "odaKlass";

                } else if (aktiivneNupp == 5 || aktiivneNupp == 29) {
                    nupp = "lippKlass";

                } else if (aktiivneNupp == 6 || aktiivneNupp == 30) {
                    nupp = "kuningasKlass";
                }


                System.out.println("Nupp: " + nupp);



                if (käiguKontroll(aktiivneNupp, käik2, initNupud(), värv, värv2, lauaseis[kuhu1 - 1][kuhu2 - 1], nupp, kuhu1, kuhu2, akt1, akt2, lauaseis) == false) {
                    System.out.println("Nii ei saa");  //läheb uuele ringile
                    log("Nii ei saa");
                    return;
                } else {
                    break sisemineWhile;  //murrab välja ja liigub edasi
                }



            }

            //käimine
            lauaseis[akt1 - 1][akt2 - 1] = 0;
            lauaseis[kuhu1 - 1][kuhu2 - 1] = aktiivneNupp;


            for (int rida3 = 0; rida3 < lauaseis.length; rida3++) {
                for (int veerg3 = 0; veerg3 < lauaseis[rida3].length; veerg3++) {
                    System.out.print(lauaseis[rida3][veerg3] + "\t");
                }
                System.out.println();
            }

            //kordamööda käimise jaoks

            if (kelleKord == 0) {
                kelleKord = 1;

            } else {
                kelleKord = 0;
                turnCounter++;

            }

            liigutaFX(aktiivneNupp, kuhu2, kuhu1, v6etavNupp);

            return;

        }

    }

    public static void mustTuleTabel(int[][] lauaseis) {


        int kasTuli;
        int odasum = 0;
        int vankersum = 0;

        for (int rida = 0; rida < lauaseis.length; rida++) {
            for (int veerg = 0; veerg < lauaseis[rida].length; veerg++) {


                //etturite TULI

                kasTuli = 0;
                try
                {
                    if (veerg == 0 && rida > 0)
                    {

                        if (lauaseis[rida + 1][veerg + 1] > 17 && lauaseis[rida + 1][veerg + 1] < 26) {


                            kasTuli = 1;
                            //System.out.println("TULI");

                        }


                    }

                    else if (veerg == 7 && rida > 0)
                    {
                        if (lauaseis[rida+1][veerg-1] > 17 && lauaseis[rida+1][veerg-1] < 26){


                            kasTuli = 1;
                            //System.out.println("TULI");


                        }
                    }




                    //System.out.println("RIDA: " + rida + ", VEERG: " + veerg + ", TULD ANNAB: " + lauaseis[rida-1][veerg-1] + " või " + lauaseis[rida-1][veerg+1]);
                    else if ((lauaseis[rida+1][veerg-1] > 17 && lauaseis[rida+1][veerg-1] < 26) || (lauaseis[rida+1][veerg+1] > 17 && lauaseis[rida+1][veerg+1] < 26))
                    {

                        kasTuli = 1;

                        //System.out.println("b");

                    }

                    else
                    {

                        kasTuli = 0;
                        //System.out.println("OK");

                    }

                }

                catch (Exception e){}


                //ratsude TULI

                try
                {
                    if (onLaual(rida+1, veerg+2)&&(lauaseis[rida+1][veerg+2] == 27 || lauaseis[rida+1][veerg+2] == 32))
                    {
                        kasTuli = 1;
                        //System.out.println("rida: " + rida + ", veerg: " + veerg);
                    }
                    else if (onLaual(rida-1, veerg+2)&&(lauaseis[rida-1][veerg+2] == 27 || lauaseis[rida-1][veerg+2] == 32))
                    {
                        kasTuli = 1;
                    }
                    else if (onLaual(rida+1, veerg-2)&&(lauaseis[rida+1][veerg-2] == 27 || lauaseis[rida+1][veerg-2] == 32))
                    {
                        kasTuli = 1;
                    }
                    else if (onLaual(rida-1, veerg-2)&&(lauaseis[rida-1][veerg-2] == 27 || lauaseis[rida-1][veerg-2] == 32))
                    {
                        kasTuli = 1;
                    }
                    else if (onLaual(rida+2, veerg+1)&&(lauaseis[rida+2][veerg+1] == 27 || lauaseis[rida+2][veerg+1] == 32))
                    {
                        kasTuli = 1;
                        //System.out.print("c");
                    }
                    else if (onLaual(rida-2, veerg+1)&&(lauaseis[rida-2][veerg+1] == 27 || lauaseis[rida-2][veerg+1] == 32))
                    {
                        kasTuli = 1;
                    }
                    else if (onLaual(rida+2, veerg-1)&&(lauaseis[rida+2][veerg-1] == 27 || lauaseis[rida+2][veerg-1] == 32))
                    {
                        kasTuli = 1;
                    }
                    else if (onLaual(rida-2, veerg-1)&&(lauaseis[rida-2][veerg-1] == 27 || lauaseis[rida-2][veerg-1] == 32))
                    {
                        kasTuli = 1;
                    }
                }
                catch (Exception e) {}


                //vankrite TULI (+ lipp)

                //kontrollib mööda sama veergu ülespoole
                try {
                    int k = rida - 1;
                    while (k != -1) {
                        //System.out.println("k = " + k);
                        vankersum += lauaseis[k][veerg];
                        //System.out.println("lauaseis[k][veerg] = " + lauaseis[k][veerg]);

                        //System.out.println("vankersum = " + vankersum);
                        if (lauaseis[k][veerg] != 0) {

                            if (vankersum == 26 || vankersum == 33 || vankersum == 29) {
                                kasTuli = 1;

                            }
                        }
                        //System.out.println("Kontrollin: rida_" + k + " veerg_" + veerg + " Ise olen ruut_" + rida + veerg
                        //+ " kasblokitud? " + blokitud);
                        k--;
                    }
                } catch (Exception e) {}
                vankersum = 0;

                //kontrollib mööda sama veergu allapoole
                try {
                    int k = rida + 1;
                    while (k != 8) {
                        //System.out.println("k = " + k);
                        vankersum += lauaseis[k][veerg];
                        //System.out.println("lauaseis[k][veerg] = " + lauaseis[k][veerg]);

                        //System.out.println("vankersum = " + vankersum);
                        if (lauaseis[k][veerg] != 0) {

                            if (vankersum == 26 || vankersum == 33 || vankersum == 29) {
                                kasTuli = 1;

                            }
                        }
                        //System.out.println("Kontrollin: rida_" + k + " veerg_" + veerg + " Ise olen ruut_" + rida + veerg
                        //+ " kasblokitud? " + blokitud);
                        k++;
                    }
                } catch (Exception e) {}
                vankersum = 0;

                //kontrollib mööda sama rida vasakule
                try {
                    int k = veerg - 1;
                    while (k != -1) {
                        //System.out.println("k = " + k);
                        vankersum += lauaseis[rida][k];
                        //System.out.println("lauaseis[k][veerg] = " + lauaseis[k][veerg]);

                        //System.out.println("vankersum = " + vankersum);
                        if (lauaseis[rida][k] != 0) {

                            if (vankersum == 26 || vankersum == 33 || vankersum == 29) {
                                kasTuli = 1;

                            }
                        }
                        //System.out.println("Kontrollin: rida_" + k + " veerg_" + veerg + " Ise olen ruut_" + rida + veerg
                        //+ " kasblokitud? " + blokitud);
                        k--;
                    }
                } catch (Exception e) {}
                vankersum = 0;

                //kontrollib mööda sama rida paremale
                try {
                    int k = veerg + 1;
                    while (k != 8) {
                        //System.out.println("k = " + k);
                        vankersum += lauaseis[rida][k];
                        //System.out.println("lauaseis[k][veerg] = " + lauaseis[k][veerg]);

                        //System.out.println("vankersum = " + vankersum);
                        if (lauaseis[rida][k] != 0) {

                            if (vankersum == 26 || vankersum == 33 || vankersum == 29) {
                                kasTuli = 1;

                            }
                        }
                        //System.out.println("Kontrollin: rida_" + k + " veerg_" + veerg + " Ise olen ruut_" + rida + veerg
                        //+ " kasblokitud? " + blokitud);
                        k++;
                    }
                } catch (Exception e) {}
                vankersum = 0;


                //odade tuli (+lipp)

                //kontrollib vasakule yles
                try {
                    int k = veerg - 1;
                    int m = rida - 1;
                    while (k != 0 || m != 0) {
                        //System.out.println("k = " + k);
                        odasum += lauaseis[m][k];
                        //System.out.println("lauaseis[k][veerg] = " + lauaseis[k][veerg]);

                        //System.out.println("odasum = " + odasum);
                        if (lauaseis[m][k] != 0) {

                            if (odasum == 28 || odasum == 31 || odasum == 29) {
                                kasTuli = 1;

                            }
                        }
                        //System.out.println("Kontrollin: rida_" + k + " veerg_" + veerg + " Ise olen ruut_" + rida + veerg
                        //+ " kasblokitud? " + blokitud);
                        k--;
                        m--;
                    }
                } catch (Exception e) {}
                odasum = 0;

                //kontrollib paremale yles
                try {
                    int k = veerg + 1;
                    int m = rida - 1;
                    while (k != 8 || m != 0) {
                        //System.out.println("k = " + k);
                        odasum += lauaseis[m][k];
                        //System.out.println("lauaseis[k][veerg] = " + lauaseis[k][veerg]);

                        //System.out.println("odasum = " + odasum);
                        if (lauaseis[m][k] != 0) {

                            if (odasum == 28 || odasum == 31 || odasum == 29) {
                                kasTuli = 1;

                            }
                        }
                        //System.out.println("Kontrollin: rida_" + k + " veerg_" + veerg + " Ise olen ruut_" + rida + veerg
                        //+ " kasblokitud? " + blokitud);
                        k++;
                        m--;
                    }
                } catch (Exception e) {}
                odasum = 0;

                //kontrollib vasakule alla
                try {
                    int k = veerg - 1;
                    int m = rida + 1;
                    while (k != 0 || m != 8) {
                        //System.out.println("k = " + k);
                        odasum += lauaseis[m][k];
                        //System.out.println("lauaseis[k][veerg] = " + lauaseis[k][veerg]);

                        //System.out.println("odasum = " + odasum);
                        if (lauaseis[m][k] != 0) {

                            if (odasum == 28 || odasum == 31 || odasum == 29) {
                                kasTuli = 1;

                            }
                        }
                        //System.out.println("Kontrollin: rida_" + k + " veerg_" + veerg + " Ise olen ruut_" + rida + veerg
                        //+ " kasblokitud? " + blokitud);
                        k--;
                        m++;
                    }
                } catch (Exception e) {}
                odasum = 0;

                //kontrollib paremale alla
                try {
                    int k = veerg + 1;
                    int m = rida + 1;
                    while (k != 8 || m != 8) {
                        //System.out.println("k = " + k);
                        odasum += lauaseis[m][k];
                        //System.out.println("lauaseis[k][veerg] = " + lauaseis[k][veerg]);

                        //System.out.println("odasum = " + odasum);
                        if (lauaseis[m][k] != 0) {

                            if (odasum == 28 || odasum == 31 || odasum == 29) {
                                kasTuli = 1;

                            }
                        }
                        //System.out.println("Kontrollin: rida_" + k + " veerg_" + veerg + " Ise olen ruut_" + rida + veerg
                        //+ " kasblokitud? " + blokitud);
                        k++;
                        m++;
                    }
                } catch (Exception e) {}
                odasum = 0;


                //kuninga tuli

                try
                {
                    if (onLaual(rida+1, veerg-1)&&(lauaseis[rida+1][veerg-1] == 29))
                    {
                        kasTuli = 1;
                    }
                    else if (onLaual(rida+1, veerg)&&(lauaseis[rida+1][veerg] == 29))
                    {
                        kasTuli = 1;
                    }
                    else if (onLaual(rida+1, veerg+1)&&(lauaseis[rida+1][veerg+1] == 29))
                    {
                        kasTuli = 1;
                    }
                    else if (onLaual(rida, veerg-1)&&(lauaseis[rida][veerg-1] == 29))
                    {
                        kasTuli = 1;
                    }
                    else if (onLaual(rida, veerg+1)&&(lauaseis[rida][veerg+1] == 29))
                    {
                        kasTuli = 1;
                        //System.out.print("c");
                    }
                    else if (onLaual(rida-1, veerg-1)&&(lauaseis[rida-1][veerg-1] == 29))
                    {
                        kasTuli = 1;
                    }
                    else if (onLaual(rida-1, veerg)&&(lauaseis[rida-1][veerg] == 29))
                    {
                        kasTuli = 1;
                    }
                    else if (onLaual(rida-1, veerg+1)&&(lauaseis[rida-1][veerg+1] == 29))
                    {
                        kasTuli = 1;
                    }
                }
                catch (Exception e) {}



                System.out.print(kasTuli + "\t");
            }
            System.out.println();
        }



    }

    public static void valgeTuleTabel(int[][] lauaseis) {


        int kasTuli;
        int vankersum = 0;
        int odasum = 0;

        for (int rida = 0; rida < lauaseis.length; rida++) {
            for (int veerg = 0; veerg < lauaseis[rida].length; veerg++) {


                //etturite TULI

                kasTuli = 0;
                try
                {
                    if (veerg == 0 && rida > 0)
                    {

                        if (lauaseis[rida - 1][veerg + 1] > 9 && lauaseis[rida - 1][veerg + 1] < 18) {


                            kasTuli = 1;
                            //System.out.println("TULI");

                        }


                    }

                    else if (veerg == 7 && rida > 0)
                    {
                        if (lauaseis[rida-1][veerg-1] > 9 && lauaseis[rida-1][veerg-1] < 18){


                            kasTuli = 1;
                            //System.out.println("TULI");


                        }
                    }




                    //System.out.println("RIDA: " + rida + ", VEERG: " + veerg + ", TULD ANNAB: " + lauaseis[rida-1][veerg-1] + " või " + lauaseis[rida-1][veerg+1]);
                    else if ((lauaseis[rida-1][veerg-1] > 9 && lauaseis[rida-1][veerg-1] < 18) || (lauaseis[rida-1][veerg+1] > 9 && lauaseis[rida-1][veerg+1] < 18))
                    {

                        kasTuli = 1;

                        //System.out.println("b");

                    }

                    else
                    {

                        kasTuli = 0;
                        //System.out.println("OK");

                    }

                }

                catch (Exception e){}

                //System.out.println("test");

                //ratsude TULI

                try
                {
                    if (onLaual(rida+1, veerg+2)&&(lauaseis[rida+1][veerg+2] == 3 || lauaseis[rida+1][veerg+2] == 8))
                    {
                        kasTuli = 1;
                        //System.out.println("rida: " + rida + ", veerg: " + veerg);
                    }
                    else if (onLaual(rida-1, veerg+2)&&(lauaseis[rida-1][veerg+2] == 3 || lauaseis[rida-1][veerg+2] == 8))
                    {
                        kasTuli = 1;
                    }
                    else if (onLaual(rida+1, veerg-2)&&(lauaseis[rida+1][veerg-2] == 3 || lauaseis[rida+1][veerg-2] == 8))
                    {
                        kasTuli = 1;
                    }
                    else if (onLaual(rida-1, veerg-2)&&(lauaseis[rida-1][veerg-2] == 3 || lauaseis[rida-1][veerg-2] == 8))
                    {
                        kasTuli = 1;
                    }
                    else if (onLaual(rida+2, veerg+1)&&(lauaseis[rida+2][veerg+1] == 3 || lauaseis[rida+2][veerg+1] == 8))
                    {
                        kasTuli = 1;
                        //System.out.print("c");
                    }
                    else if (onLaual(rida-2, veerg+1)&&(lauaseis[rida-2][veerg+1] == 3 || lauaseis[rida-2][veerg+1] == 8))
                    {
                        kasTuli = 1;
                    }
                    else if (onLaual(rida+2, veerg-1)&&(lauaseis[rida+2][veerg-1] == 3 || lauaseis[rida+2][veerg-1] == 8))
                    {
                        kasTuli = 1;
                    }
                    else if (onLaual(rida-2, veerg-1)&&(lauaseis[rida-2][veerg-1] == 3 || lauaseis[rida-2][veerg-1] == 8))
                    {
                        kasTuli = 1;
                    }
                }
                catch (Exception e) {}

                //vankrite TULI (+ lipp)

                //kontrollib mööda sama veergu ülespoole
                try {
                    int k = rida - 1;
                    while (k != -1) {
                        //System.out.println("k = " + k);
                        vankersum += lauaseis[k][veerg];
                        //System.out.println("lauaseis[k][veerg] = " + lauaseis[k][veerg]);

                        //System.out.println("vankersum = " + vankersum);
                        if (lauaseis[k][veerg] != 0) {

                            if (vankersum == 2 || vankersum == 9 || vankersum == 5) {
                                kasTuli = 1;

                            }
                        }
                        //System.out.println("Kontrollin: rida_" + k + " veerg_" + veerg + " Ise olen ruut_" + rida + veerg
                        //+ " kasblokitud? " + blokitud);
                        k--;
                    }
                } catch (Exception e) {}
                vankersum = 0;

                //kontrollib mööda sama veergu allapoole
                try {
                    int k = rida + 1;
                    while (k != 8) {
                        //System.out.println("k = " + k);
                        vankersum += lauaseis[k][veerg];
                        //System.out.println("lauaseis[k][veerg] = " + lauaseis[k][veerg]);

                        //System.out.println("vankersum = " + vankersum);
                        if (lauaseis[k][veerg] != 0) {

                            if (vankersum == 2 || vankersum == 9 || vankersum == 5) {
                                kasTuli = 1;

                            }
                        }
                        //System.out.println("Kontrollin: rida_" + k + " veerg_" + veerg + " Ise olen ruut_" + rida + veerg
                        //+ " kasblokitud? " + blokitud);
                        k++;
                    }
                } catch (Exception e) {}
                vankersum = 0;

                //kontrollib mööda sama rida vasakule
                try {
                    int k = veerg - 1;
                    while (k != -1) {
                        //System.out.println("k = " + k);
                        vankersum += lauaseis[rida][k];
                        //System.out.println("lauaseis[k][veerg] = " + lauaseis[k][veerg]);

                        //System.out.println("vankersum = " + vankersum);
                        if (lauaseis[rida][k] != 0) {

                            if (vankersum == 2 || vankersum == 9 || vankersum == 5) {
                                kasTuli = 1;

                            }
                        }
                        //System.out.println("Kontrollin: rida_" + k + " veerg_" + veerg + " Ise olen ruut_" + rida + veerg
                        //+ " kasblokitud? " + blokitud);
                        k--;
                    }
                } catch (Exception e) {}
                vankersum = 0;

                //kontrollib mööda sama rida paremale
                try {
                    int k = veerg + 1;
                    while (k != 8) {
                        //System.out.println("k = " + k);
                        vankersum += lauaseis[rida][k];
                        //System.out.println("lauaseis[k][veerg] = " + lauaseis[k][veerg]);

                        //System.out.println("vankersum = " + vankersum);
                        if (lauaseis[rida][k] != 0) {

                            if (vankersum == 2 || vankersum == 9 || vankersum == 5) {
                                kasTuli = 1;

                            }
                        }
                        //System.out.println("Kontrollin: rida_" + k + " veerg_" + veerg + " Ise olen ruut_" + rida + veerg
                        //+ " kasblokitud? " + blokitud);
                        k++;
                    }
                } catch (Exception e) {}
                vankersum = 0;


                //odade tuli (+lipp)

                //kontrollib vasakule yles
                try {
                    int k = veerg - 1;
                    int m = rida - 1;
                    while (k != 0 || m != 0) {
                        //System.out.println("k = " + k);
                        odasum += lauaseis[m][k];
                        //System.out.println("lauaseis[k][veerg] = " + lauaseis[k][veerg]);

                        //System.out.println("odasum = " + odasum);
                        if (lauaseis[m][k] != 0) {

                            if (odasum == 4 || odasum == 7 || odasum == 5) {
                                kasTuli = 1;

                            }
                        }
                        //System.out.println("Kontrollin: rida_" + k + " veerg_" + veerg + " Ise olen ruut_" + rida + veerg
                        //+ " kasblokitud? " + blokitud);
                        k--;
                        m--;
                    }
                } catch (Exception e) {}
                odasum = 0;

                //kontrollib paremale yles
                try {
                    int k = veerg + 1;
                    int m = rida - 1;
                    while (k != 8 || m != 0) {
                        //System.out.println("k = " + k);
                        odasum += lauaseis[m][k];
                        //System.out.println("lauaseis[k][veerg] = " + lauaseis[k][veerg]);

                        //System.out.println("odasum = " + odasum);
                        if (lauaseis[m][k] != 0) {

                            if (odasum == 4 || odasum == 7 || odasum == 5) {
                                kasTuli = 1;

                            }
                        }
                        //System.out.println("Kontrollin: rida_" + k + " veerg_" + veerg + " Ise olen ruut_" + rida + veerg
                        //+ " kasblokitud? " + blokitud);
                        k++;
                        m--;
                    }
                } catch (Exception e) {}
                odasum = 0;

                //kontrollib vasakule alla
                try {
                    int k = veerg - 1;
                    int m = rida + 1;
                    while (k != 0 || m != 8) {
                        //System.out.println("k = " + k);
                        odasum += lauaseis[m][k];
                        //System.out.println("lauaseis[k][veerg] = " + lauaseis[k][veerg]);

                        //System.out.println("odasum = " + odasum);
                        if (lauaseis[m][k] != 0) {

                            if (odasum == 4 || odasum == 7 || odasum == 5) {
                                kasTuli = 1;

                            }
                        }
                        //System.out.println("Kontrollin: rida_" + k + " veerg_" + veerg + " Ise olen ruut_" + rida + veerg
                        //+ " kasblokitud? " + blokitud);
                        k--;
                        m++;
                    }
                } catch (Exception e) {}
                odasum = 0;

                //kontrollib paremale alla
                try {
                    int k = veerg + 1;
                    int m = rida + 1;
                    while (k != 8 || m != 8) {
                        //System.out.println("k = " + k);
                        odasum += lauaseis[m][k];
                        //System.out.println("lauaseis[k][veerg] = " + lauaseis[k][veerg]);

                        //System.out.println("odasum = " + odasum);
                        if (lauaseis[m][k] != 0) {

                            if (odasum == 4 || odasum == 7 || odasum == 5) {
                                kasTuli = 1;

                            }
                        }
                        //System.out.println("Kontrollin: rida_" + k + " veerg_" + veerg + " Ise olen ruut_" + rida + veerg
                        //+ " kasblokitud? " + blokitud);
                        k++;
                        m++;
                    }
                } catch (Exception e) {}
                odasum = 0;


                //kuninga tuli

                try
                {
                    if (onLaual(rida+1, veerg-1)&&(lauaseis[rida+1][veerg-1] == 6))
                    {
                        kasTuli = 1;
                    }
                    else if (onLaual(rida+1, veerg)&&(lauaseis[rida+1][veerg] == 6))
                    {
                        kasTuli = 1;
                    }
                    else if (onLaual(rida+1, veerg+1)&&(lauaseis[rida+1][veerg+1] == 6))
                    {
                        kasTuli = 1;
                    }
                    else if (onLaual(rida, veerg-1)&&(lauaseis[rida][veerg-1] == 6))
                    {
                        kasTuli = 1;
                    }
                    else if (onLaual(rida, veerg+1)&&(lauaseis[rida][veerg+1] == 6))
                    {
                        kasTuli = 1;
                        //System.out.print("c");
                    }
                    else if (onLaual(rida-1, veerg-1)&&(lauaseis[rida-1][veerg-1] == 6))
                    {
                        kasTuli = 1;
                    }
                    else if (onLaual(rida-1, veerg)&&(lauaseis[rida-1][veerg] == 6))
                    {
                        kasTuli = 1;
                    }
                    else if (onLaual(rida-1, veerg+1)&&(lauaseis[rida-1][veerg+1] == 6))
                    {
                        kasTuli = 1;
                    }
                }
                catch (Exception e) {}

                System.out.print(kasTuli + "\t");
            }
            System.out.println();
        }



    }

    public static boolean onLaual(int rida, int veerg){

        if (rida < 0 || veerg < 0 || rida > 7 || veerg > 7)
        {
            return false;
        }
        return true;
    }


    private void liigutaFX(int aktiivneNupp, int kuhu2, int kuhu1, int v6etavNupp) {


        System.out.println("aktiivne: " + aktiivneNupp);
        System.out.println("kuhu2: " + kuhu2);
        System.out.println("kuhu1: " + kuhu1);
        System.out.println("nupumapis: " + nupumap.get(aktiivneNupp));

        //log("aktiivne nupp: " + String.valueOf(aktiivneNupp));

        if(v6etavNupp != 0){
            Aken.muutuvlaud.getChildren().remove(nupumap.get(v6etavNupp-2));
        }
        Aken.muutuvlaud.getChildren().remove(nupumap.get(aktiivneNupp-2));            //eemalda laualt
        Aken.muutuvlaud.add(nupumap.get(aktiivneNupp-2), kuhu2-1, kuhu1-1);  //pane lauale tagasi

    }






    public static boolean käiguKontroll(int aktiivneNupp, int[] käik2, HashMap malendid, int värv, int värv2, int kasTühiRuut, String nupp, int kuhu1, int kuhu2, int akt1, int akt2, int[][] lauaseis) {
        //KÄIGUKONTROLL

        if (nupp.equals("etturKlass")) {

            if (värv == 0) {

                if ((käik2[0] - käik2[0] % 10) / 10 == 2) {   //ettur saab käia 2 sammu kui on algpositsioonil
                    if (käik2[1] - käik2[0] == 20) {
                        return true;
                    }
                }

                if (käik2[1] - käik2[0] == 10 && kasTühiRuut == 0) {  //arvutab koordinaatide järgi kas käik on võimalik
                    return true;
                } else if ((käik2[1] - käik2[0] == 9 && kasTühiRuut != 0) || (käik2[1] - käik2[0] == 11 && kasTühiRuut != 0)) {
                    return true;
                } else {
                    return false;
                }

            } else {
                //ehk siis mustad
                if ((käik2[0] - käik2[0] % 10) / 10 == 7) {
                    if (käik2[0] - käik2[1] == 20) {
                        return true;
                    }
                }

                if (käik2[0] - käik2[1] == 10) {
                    return true;
                } else if ((käik2[0] - käik2[1] == 9 && kasTühiRuut != 0) || (käik2[0] - käik2[1] == 11 && kasTühiRuut != 0)) {
                    return true;
                } else {
                    return false;
                }
            }

        }

        if (nupp.equals("ratsuKlass")) {

            if ((Math.abs(käik2[1] - käik2[0]) == 8 || Math.abs(käik2[1] - käik2[0]) == 12 || Math.abs(käik2[1] - käik2[0]) == 19 || Math.abs(käik2[1] - käik2[0]) == 21) && ((värv == 0 && kasTühiRuut != 3 && kasTühiRuut != 8) || (värv == 1 && kasTühiRuut != 27 && kasTühiRuut != 32)) && värv != värv2) {  //arvutab koordinaatide järgi kas käik on võimalik

                return true;

            } else {

                System.out.println();
                return false;
            }

        }

            /*- käib ainult horisontaalis ja vertikaalis
              - kedagi ei tohialguse ja lõpu vahel olla
              - samasse kohta ei tohi astuda
              - oma nuppe ei saa võtta (ja kuningat)
              */
        if (nupp.equals("vankerKlass")) {

            if (akt2 == kuhu2) {

                //vertikaalne liikumine
                System.out.println(Math.abs(käik2[1] - käik2[0]) % 10);
                if (akt1 > kuhu1) {

                    for (int i = akt1 - 1; i > kuhu1; i--) {
                        System.out.println("Proovin: " + i);
                        if (lauaseis[i - 1][kuhu2 - 1] != 0) {
                            System.out.println("siin on nupp: " + lauaseis[i - 1][kuhu2 - 1]);
                            return false;
                        }
                    }


                } else if (akt1 < kuhu1) {  // akt1<kuhu1

                    for (int i = akt1 + 1; i < kuhu1; i++) {   // see korda teha
                        System.out.println("Proovin: " + i);
                        if (lauaseis[i - 1][kuhu2 - 1] != 0) {
                            System.out.println("siin on nupp: " + lauaseis[i - 1][kuhu2 - 1]);
                            return false;
                        }
                    }


                }

                if (värv != värv2) {
                    return true;
                }


            } else if (akt1 == kuhu1) {  //horisontaalne liikumine

                if (akt2 > kuhu2) {

                    for (int i = akt2 - 1; i > kuhu2; i--) {
                        System.out.println("Proovin: " + i);
                        if (lauaseis[kuhu1 - 1][i - 1] != 0) {
                            System.out.println("siin on nupp: " + lauaseis[kuhu1 - 1][i - 1]);
                            return false;
                        }
                    }


                } else {  // akt1<kuhu1

                    for (int i = akt2 + 1; i < kuhu2; i++) {
                        System.out.println("Proovin: " + i);
                        if (lauaseis[kuhu1 - 1][i - 1] != 0) {
                            System.out.println("siin on nupp: " + lauaseis[kuhu1 - 1][i - 1]);
                            return false;
                        }
                    }

                }

                if (värv != värv2) {
                    return true;
                }

            }

        }

        if (nupp.equals("odaKlass")) {

            //käib diagonaalis

            if (Math.abs(käik2[1] - käik2[0]) % 9 == 0 || Math.abs(käik2[1] - käik2[0]) % 11 == 0) {

                System.out.println("AKT1: " + akt1);
                System.out.println("AKT2: " + akt2);
                System.out.println("KUHU1: " + kuhu1);
                System.out.println("KUHU2: " + kuhu2);


                if (akt1 < kuhu1 && akt2 < kuhu2) {  //alla paremale

                    int j = akt2 + 1;
                    for (int i = akt1 + 1; i < kuhu1; i++) {
                        System.out.println("Proovin i: " + i);
                        System.out.println("Proovin j: " + j);
                        if (lauaseis[i - 1][j - 1] != 0) {
                            System.out.println("siin on nupp: " + lauaseis[i - 1][j - 1]);
                            return false;
                        }
                        j++;
                    }
                }

                if (akt1 > kuhu1 && akt2 < kuhu2) {  //üles paremale

                    int j = akt2 + 1;
                    for (int i = akt1 - 1; i > kuhu1; i--) {
                        System.out.println("Proovin i: " + i);
                        System.out.println("Proovin j: " + j);
                        if (lauaseis[i - 1][j - 1] != 0) {
                            System.out.println("siin on nupp: " + lauaseis[i - 1][j - 1]);
                            return false;
                        }
                        j++;
                    }
                }

                if (akt1 > kuhu1 && akt2 > kuhu2) {  //üles vasakule

                    int j = akt2 - 1;
                    for (int i = akt1 - 1; i > kuhu1; i--) {
                        System.out.println("Proovin i: " + i);
                        System.out.println("Proovin j: " + j);
                        if (lauaseis[i - 1][j - 1] != 0) {
                            System.out.println("siin on nupp: " + lauaseis[i - 1][j - 1]);
                            return false;

                        }
                        j--;
                    }
                }

                if (akt1 < kuhu1 && akt2 > kuhu2) {  //alla vasakule

                    int j = akt2 - 1;
                    for (int i = akt1 + 1; i < kuhu1; i++) {
                        System.out.println("Proovin i: " + i);
                        System.out.println("Proovin j: " + j);
                        if (lauaseis[i - 1][j - 1] != 0) {
                            System.out.println("siin on nupp: " + lauaseis[i - 1][j - 1]);
                            return false;
                        }
                        j--;
                    }
                }

                if (värv != värv2) {
                    return true;
                }



            }
        }

        if (nupp.equals("lippKlass")) {

            if (Math.abs(käik2[1] - käik2[0]) % 9 == 0 || Math.abs(käik2[1] - käik2[0]) % 11 == 0) {

                if (akt1 < kuhu1 && akt2 < kuhu2) {  //alla paremale

                    int j = akt2 + 1;
                    for (int i = akt1 + 1; i < kuhu1; i++) {
                        System.out.println("Proovin i: " + i);
                        System.out.println("Proovin j: " + j);
                        if (lauaseis[i - 1][j - 1] != 0) {
                            System.out.println("siin on nupp: " + lauaseis[i - 1][j - 1]);
                            return false;
                        }
                        j++;
                    }
                }

                if (akt1 > kuhu1 && akt2 < kuhu2) {  //üles paremale

                    int j = akt2 + 1;
                    for (int i = akt1 - 1; i > kuhu1; i--) {
                        System.out.println("Proovin i: " + i);
                        System.out.println("Proovin j: " + j);
                        if (lauaseis[i - 1][j - 1] != 0) {
                            System.out.println("siin on nupp: " + lauaseis[i - 1][j - 1]);
                            return false;
                        }
                        j++;
                    }
                }

                if (akt1 > kuhu1 && akt2 > kuhu2) {  //üles vasakule

                    int j = akt2 - 1;
                    for (int i = akt1 - 1; i > kuhu1; i--) {
                        System.out.println("Proovin i: " + i);
                        System.out.println("Proovin j: " + j);
                        if (lauaseis[i - 1][j - 1] != 0) {
                            System.out.println("siin on nupp: " + lauaseis[i - 1][j - 1]);
                            return false;
                        }
                        j--;
                    }
                }

                if (akt1 < kuhu1 && akt2 > kuhu2) {  //alla vasakule

                    int j = akt2 - 1;
                    for (int i = akt1 + 1; i < kuhu1; i++) {
                        System.out.println("Proovin i: " + i);
                        System.out.println("Proovin j: " + j);
                        if (lauaseis[i - 1][j - 1] != 0) {
                            System.out.println("siin on nupp: " + lauaseis[i - 1][j - 1]);
                            return false;
                        }
                        j--;
                    }
                }

                if (värv != värv2) {
                    return true;
                }

            } else if (akt1 == kuhu1 || akt2 == kuhu2) {

                if (akt2 == kuhu2) {

                    //vertikaalne liikumine
                    System.out.println(Math.abs(käik2[1] - käik2[0]) % 10);
                    if (akt1 > kuhu1) {

                        for (int i = akt1 - 1; i > kuhu1; i--) {
                            System.out.println("Proovin: " + i);
                            if (lauaseis[i - 1][kuhu2 - 1] != 0) {
                                System.out.println("siin on nupp: " + lauaseis[i - 1][kuhu2 - 1]);
                                return false;
                            }
                        }


                    } else if (akt1 < kuhu1) {  // akt1<kuhu1

                        for (int i = akt1 + 1; i < kuhu1; i++) {   // see korda teha
                            System.out.println("Proovin: " + i);
                            if (lauaseis[i - 1][kuhu2 - 1] != 0) {
                                System.out.println("siin on nupp: " + lauaseis[i - 1][kuhu2 - 1]);
                                return false;
                            }
                        }


                    }

                    if (värv != värv2) {
                        return true;
                    }


                } else if (akt1 == kuhu1) {  //horisontaalne liikumine

                    if (akt2 > kuhu2) {

                        for (int i = akt2 - 1; i > kuhu2; i--) {
                            System.out.println("Proovin: " + i);
                            if (lauaseis[kuhu1 - 1][i - 1] != 0) {
                                System.out.println("siin on nupp: " + lauaseis[kuhu1 - 1][i - 1]);
                                return false;
                            }
                        }


                    } else {  // akt1<kuhu1

                        for (int i = akt2 + 1; i < kuhu2; i++) {
                            System.out.println("Proovin: " + i);
                            if (lauaseis[kuhu1 - 1][i - 1] != 0) {
                                System.out.println("siin on nupp: " + lauaseis[kuhu1 - 1][i - 1]);
                                return false;
                            }
                        }

                    }

                    if (värv != värv2) {
                        return true;
                    }

                }
            }
        }

        if (nupp.equals("kuningasKlass")) {

            if (akt1 - kuhu1 == 0) {                  // ehk on samal real
                if (Math.abs(akt2 - kuhu2) == 1) {   // 1 samm mõlemas suunas
                    if (värv != värv2) {             // ei ole oma nupp
                        return true;                   // siis sobib
                    }
                }
            }

            if (akt1 - kuhu1 == -1) {                 //tahab astuda suurema numbriga reale
                if (Math.abs(akt2 - kuhu2) == 1 || Math.abs(akt2 - kuhu2) == 0) {
                    if (värv != värv2) {
                        return true;
                    }
                }
            }

            if (akt1 - kuhu1 == 1) {                 //tahab astuda väiksema numbriga reale
                if (Math.abs(akt2 - kuhu2) == 1 || Math.abs(akt2 - kuhu2) == 0) {
                    if (värv != värv2) {
                        return true;
                    }
                }
            }
        }

        return false;
    }


}
