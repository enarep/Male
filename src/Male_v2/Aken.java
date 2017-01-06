package Male_v2;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import static Male_v2.Game.k2ik;
import static Male_v2.Game.testk2ik;
import static Male_v2.Laud.nupumap;
import static Male_v2.Nupud.initNupud;


class Aken {

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
    Button testbtn;
    boolean firstMove = true;
    int kelleKord = 0;
    int turnCounter = 1;
    int[][] lauaseis;
    int recCount = 0;
    int vkLiikunud = 0;
    int vv1Liikunud = 0;
    int vv2Liikunud = 0;
    int mkLiikunud = 0;
    int mv1Liikunud = 0;
    int mv2Liikunud = 0;
    String welcome = "Käimiseks kirjuta allolevasse kasti " +
            "soovitav manööver neljakohalise numbrina, kus esimesed kaks " +
            "tähistavad algus- ja viimased kaks lõpuruutu \nValgete kord";

    Aken(){

        looAken();
        new Nupud();
        new Laud();

    }

    private void male(int x){

        int akt2;
        int akt1;
        int kaik;
        int[] kaik2 = new int[2];
        int aktiivneNupp;
        int v6etavNupp;
        int kuhu1;
        int kuhu2;
        int varv;
        int varv2;


        int[][] lauaseisAjutine;
        String nupp = "";


        // loob mustade ja valgete ruutudega laua

        if(firstMove) {

            // loob kahemõõtmelise massiivi nuppude asukohtade jaoks

            lauaseis = new int[][]{{2, 3, 4, 5, 6, 7, 8, 9}, {10, 11, 12, 13, 14, 15, 16, 17},
                    {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0}, {18, 19, 20, 21, 22, 23, 24, 25}, {26, 27, 28, 29, 30, 31, 32, 33}};

            System.out.println("Lauaseis: ");
            System.out.println("------------------------------");

            //prindib selle konsooli

            for (int[] t : lauaseis) {
                for (int s : t) {
                    System.out.print(s + "\t");
                }
                System.out.println();
            }

            System.out.println("------------------------------");
            System.out.println();

        }

        firstMove = false;

        if (x == 0) {
            kaik = k2ik();
            if (kaik == 9999){

                System.out.println("Valesti sisestatud käik");
                log("\n" + "Valesti sisestatud käik");

                sisend.clear();
                Platform.runLater(() -> sisend.requestFocus());

                return;
            }

        } else {

            recCount++;
            System.out.println("Kordus: " + recCount);

            kaik = testk2ik();
        }

        // käik lõhutakse ära ja lisatakse massiivi

        kaik2[0] = kaik / 100;
        kaik2[1] = (kaik - kaik2[0] * 100);

        // prindib välja käigu

        System.out.println("Sisestatud käik: ");
        log("\n" + "Sisestatud käik: ");
        prindiKaik(kaik2);

        //valib aktiivse nupu esimese numbri järgi
        
        akt2 = kaik2[0] % 10;
        akt1 = (kaik2[0] - akt2) / 10;
        aktiivneNupp = lauaseis[akt1 - 1][akt2 - 1];
        
        
        //käiguKontroll
        
        if (aktiivneNupp == 0) {
            System.out.println("Seal pole nuppu");
            log("Seal pole nuppu");
            
            return;
        }
        
        varv = initNupud().get(aktiivneNupp).varv;

        if (varv != kelleKord) {
            System.out.println("Vale värvi nupp");
            log("Vale värvi nupp");

            return;
        }


        kuhu2 = kaik2[1] % 10;
        kuhu1 = (kaik2[1] - kuhu2) / 10;
        v6etavNupp = lauaseis[kuhu1 - 1][kuhu2 - 1];

        if (v6etavNupp != 0) {                              //varv2 on siis sihtmärgi värv
            varv2 = initNupud().get(v6etavNupp).varv;
        } else {
            varv2 = Math.abs(varv - 1);                      //kui on tühi ruut siis on lihtsalt vastandvärv
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


        if (varv == 0) {

            System.out.println("Tahad käia nupuga: " + aktiivneNupp + " (Valge " + nupp.substring(0, nupp.length() - 5)
                    + "), võetav nupp: " + v6etavNupp);

        } else {

            System.out.println("Tahad käia nupuga: " + aktiivneNupp + " (Must " + nupp.substring(0, nupp.length() - 5)
                    + "), võetav nupp: " + v6etavNupp);

        }

        //käigukontroll

        if (!käiguKontroll(kaik2, varv, varv2, lauaseis[kuhu1 - 1][kuhu2 - 1],
                nupp, kuhu1, kuhu2, akt1, akt2, lauaseis, vkLiikunud, vv1Liikunud,
                vv2Liikunud, mkLiikunud, mv1Liikunud, mv2Liikunud)) {

            System.out.println("Nii ei saa");
            log("Nii ei saa");

            return;                                     //läheb uuele ringile

        } else if (varv == 0 && mustTuleTabel(lauaseis)                 //kontrollib tuld
                [otsiNupuAsukoht(6, lauaseis)[0]][otsiNupuAsukoht(6, lauaseis)[1]] == 1) {

            lauaseisAjutine = lauaseis;
            lauaseisAjutine[akt1 - 1][akt2 - 1] = 0;               //ajutiselt käib et testida kas tuli on kadunud
            lauaseisAjutine[kuhu1 - 1][kuhu2 - 1] = aktiivneNupp;

            if (mustTuleTabel(lauaseisAjutine)[otsiNupuAsukoht(6, lauaseisAjutine)[0]]
                    [otsiNupuAsukoht(6, lauaseisAjutine)[1]] == 1) {
                System.out.println("Kuningas tules");
                log("Kuningas tules");

                return;
            }

            System.out.println("Varjasid tule, hea töö");

        } else if (varv == 1 && valgeTuleTabel(lauaseis)
                [otsiNupuAsukoht(30, lauaseis)[0]][otsiNupuAsukoht(30, lauaseis)[1]] == 1) {

            lauaseisAjutine = lauaseis;
            lauaseisAjutine[akt1 - 1][akt2 - 1] = 0;
            lauaseisAjutine[kuhu1 - 1][kuhu2 - 1] = aktiivneNupp;

            if (valgeTuleTabel(lauaseisAjutine)[otsiNupuAsukoht(30, lauaseisAjutine)[0]]
                    [otsiNupuAsukoht(30, lauaseisAjutine)[1]] == 1) {
                System.out.println("Kuningas tules");
                log("Kuningas tules");

                return;
            }

            System.out.println("Varjasid tule, hea töö");

        } else {

            //kui peale käiku jääb kuningas tulle

            if (varv == 0 && mustTuleTabel(lauaseis)[otsiNupuAsukoht(6, lauaseis)[0]]
                    [otsiNupuAsukoht(6, lauaseis)[1]] == 0) {

                lauaseisAjutine = lauaseis;
                lauaseisAjutine[akt1 - 1][akt2 - 1] = 0;               //ajutiselt käib et testida kas tuli on kadunud
                lauaseisAjutine[kuhu1 - 1][kuhu2 - 1] = aktiivneNupp;

                if (mustTuleTabel(lauaseisAjutine)[otsiNupuAsukoht(6, lauaseisAjutine)[0]]
                        [otsiNupuAsukoht(6, lauaseisAjutine)[1]] == 1) {
                    System.out.println("Kuningas jääb tulle");
                    log("Kuningas jääb tulle");

                    return;
                }

            } else if (varv == 1 && valgeTuleTabel(lauaseis)[otsiNupuAsukoht(30, lauaseis)[0]]
                    [otsiNupuAsukoht(30, lauaseis)[1]] == 0) {

                lauaseisAjutine = lauaseis;
                lauaseisAjutine[akt1 - 1][akt2 - 1] = 0;               //ajutiselt käib et testida kas tuli on kadunud
                lauaseisAjutine[kuhu1 - 1][kuhu2 - 1] = aktiivneNupp;

                if (valgeTuleTabel(lauaseisAjutine)[otsiNupuAsukoht(30, lauaseisAjutine)[0]]
                        [otsiNupuAsukoht(30, lauaseisAjutine)[1]] == 1) {
                    System.out.println("Kuningas jääb tulle");
                    log("Kuningas jääb tulle");

                    return;
                }
            }
        }

        //käimine

        lauaseis[akt1 - 1][akt2 - 1] = 0;                       //muudab lauaseisu massiivi
        lauaseis[kuhu1 - 1][kuhu2 - 1] = aktiivneNupp;

        if (aktiivneNupp == 6 && kaik == 1512){             //need on vangerduste jaoks, vankri käimine
            lauaseis[kuhu1 - 1][kuhu2] = 2;
            lauaseis[kuhu1 - 1][kuhu2 - 2] = 0;
        }

        if (aktiivneNupp == 6 && kaik == 1517){
            lauaseis[kuhu1 - 1][kuhu2 - 2] = 9;
            lauaseis[kuhu1 - 1][kuhu2] = 0;
        }

        if (aktiivneNupp == 30 && kaik == 8582){
            lauaseis[kuhu1 - 1][kuhu2] = 26;
            lauaseis[kuhu1 - 1][kuhu2 - 2] = 0;
        }

        if (aktiivneNupp == 30 && kaik == 8587){
            lauaseis[kuhu1 - 1][kuhu2 - 2] = 33;
            lauaseis[kuhu1 - 1][kuhu2] = 0;
        }

        if (aktiivneNupp == 6){
            vkLiikunud = 1;
        }

        if (aktiivneNupp == 2){
            vv1Liikunud = 1;
        }

        if (aktiivneNupp == 9){
            vv2Liikunud = 1;
        }

        if (aktiivneNupp == 30){
            mkLiikunud = 1;
        }

        if (aktiivneNupp == 26){
            mv1Liikunud = 1;
        }

        if (aktiivneNupp == 33){
            mv2Liikunud = 1;
        }

        System.out.println();
        System.out.println("Uus lauaseis: ");
        System.out.println("-----------------------------");

        for (int[] t : lauaseis) {
            for (int s : t) {
                System.out.print(s + "\t");
            }
            System.out.println();
        }

        System.out.println("----------------------------");
        System.out.println();

        //kordamööda käimise jaoks

        if (kelleKord == 0) {
            kelleKord = 1;

        } else {
            kelleKord = 0;
            turnCounter++;
        }

        liigutaFX(aktiivneNupp, kuhu2, kuhu1, v6etavNupp);

        log("Käidud!");

        System.out.println();
        System.out.println(turnCounter + ". ring");

        if (kelleKord == 0) {
            System.out.println("Valgete kord");
            log("\n" + "Valgete kord");
        } else {
            System.out.println("Mustade kord");
            log("\n" + "Mustade kord");
        }
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

    private void looAken() {

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
        vb.getChildren().addAll(laud, logi, sisend, btn, testbtn);
        vb.setSpacing(10);
        vb.setPadding(new Insets(10, 0, 10, 0));
        root.getChildren().addAll(vb);

        aStage.setScene(aScene);
        aStage.show();

        btn.setOnAction(event -> male(0));
        testbtn.setOnAction(event -> {
            while(recCount < 10000){
                male(1);
            }
        });

    }

    private void looIO() {

        logi = new TextArea();
        logi.setPrefRowCount(4);
        logi.setEditable(false);
        logi.setWrapText(true);
        logi.textProperty().addListener((observable, oldValue, newValue) -> logi.setScrollTop(Double.MAX_VALUE));
        log(welcome);

        sisend = new TextField();

        btn = new Button("Sisesta käik");
        testbtn = new Button("test");

        Platform.runLater(() -> sisend.requestFocus());

    }

    private void log(String logitekst) {

        logi.appendText(logitekst);

    }

    private static boolean onLaual(int rida, int veerg){

        return !(rida < 0 || veerg < 0 || rida > 7 || veerg > 7);
    }

    private void liigutaFX(int aktiivneNupp, int kuhu2, int kuhu1, int v6etavNupp) {

        if(aktiivneNupp == 6 && kuhu1 == 1 && kuhu2 == 2){              //valge vasakule vangerdus
            Aken.muutuvlaud.getChildren().remove(nupumap.get(0));
            Aken.muutuvlaud.add(nupumap.get(0), kuhu2, kuhu1-1);
        }

        if(aktiivneNupp == 6 && kuhu1 == 1 && kuhu2 == 7){              //valge paremale vangerdus
            Aken.muutuvlaud.getChildren().remove(nupumap.get(7));
            Aken.muutuvlaud.add(nupumap.get(7), kuhu2-2, kuhu1-1);
        }

        if(aktiivneNupp == 30 && kuhu1 == 8 && kuhu2 == 2){              //musta vasakule vangerdus
            Aken.muutuvlaud.getChildren().remove(nupumap.get(24));
            Aken.muutuvlaud.add(nupumap.get(24), kuhu2, kuhu1-1);
        }

        if(aktiivneNupp == 30 && kuhu1 == 8 && kuhu2 == 7){              //musta paremale vangerdus
            Aken.muutuvlaud.getChildren().remove(nupumap.get(31));
            Aken.muutuvlaud.add(nupumap.get(31), kuhu2-2, kuhu1-1);
        }

        if(v6etavNupp != 0){
            Aken.muutuvlaud.getChildren().remove(nupumap.get(v6etavNupp-2));
        }

        Aken.muutuvlaud.getChildren().remove(nupumap.get(aktiivneNupp-2));            //eemalda laualt
        Aken.muutuvlaud.add(nupumap.get(aktiivneNupp-2), kuhu2-1, kuhu1-1);  //pane lauale tagasi

    }

    private void prindiKaik(int[] kaik2){

        for (int c = 0; c < kaik2.length; c++) {

            System.out.print(kaik2[c]);
            log(Integer.toString(kaik2[c]));

            if (c == 0) {
                System.out.print(" --> ");
                log(" --> ");
            } else {
                System.out.println();
                log("\n");
            }
        }

        System.out.println();
    }

    private int[] otsiNupuAsukoht(int nupp, int[][] lauaseis){

        int[] x = new int[2];
        int[] y = {0, 0};
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                if(lauaseis[i][j] == nupp){

                    x[0] = i;
                    x[1] = j;
                    return x;

                }
            }
        }
        return y;
    }

    private static int[][] mustTuleTabel(int[][] lauaseis) {


        int kasTuli;
        int odasum = 0;
        int vankersum = 0;
        int[][] tuli = new int[8][8];

        for (int rida = 0; rida < lauaseis.length; rida++) {
            for (int veerg = 0; veerg < lauaseis[rida].length; veerg++) {

                //etturite TULI

                kasTuli = 0;
                try {
                    if (veerg == 0 && rida > 0) {
                        if (lauaseis[rida + 1][veerg + 1] > 17 && lauaseis[rida + 1][veerg + 1] < 26) {

                            kasTuli = 1;

                        }

                    } else if (veerg == 7 && rida > 0) {
                        if (lauaseis[rida+1][veerg-1] > 17 && lauaseis[rida+1][veerg-1] < 26){

                            kasTuli = 1;

                        }

                    } else if ((lauaseis[rida+1][veerg-1] > 17 && lauaseis[rida+1][veerg-1] < 26) || (lauaseis[rida+1][veerg+1] > 17 && lauaseis[rida+1][veerg+1] < 26)) {

                        kasTuli = 1;

                    } else {

                        kasTuli = 0;

                    }
                } catch (Exception ignored){}


                //ratsude TULI

                try {
                    if (onLaual(rida+1, veerg+2)&&(lauaseis[rida+1][veerg+2] == 27 || lauaseis[rida+1][veerg+2] == 32)) {
                        kasTuli = 1;
                    } else if (onLaual(rida-1, veerg+2)&&(lauaseis[rida-1][veerg+2] == 27 || lauaseis[rida-1][veerg+2] == 32)) {
                        kasTuli = 1;
                    } else if (onLaual(rida+1, veerg-2)&&(lauaseis[rida+1][veerg-2] == 27 || lauaseis[rida+1][veerg-2] == 32)) {
                        kasTuli = 1;
                    } else if (onLaual(rida-1, veerg-2)&&(lauaseis[rida-1][veerg-2] == 27 || lauaseis[rida-1][veerg-2] == 32)) {
                        kasTuli = 1;
                    } else if (onLaual(rida+2, veerg+1)&&(lauaseis[rida+2][veerg+1] == 27 || lauaseis[rida+2][veerg+1] == 32)) {
                        kasTuli = 1;
                    } else if (onLaual(rida-2, veerg+1)&&(lauaseis[rida-2][veerg+1] == 27 || lauaseis[rida-2][veerg+1] == 32)) {
                        kasTuli = 1;
                    } else if (onLaual(rida+2, veerg-1)&&(lauaseis[rida+2][veerg-1] == 27 || lauaseis[rida+2][veerg-1] == 32)) {
                        kasTuli = 1;
                    } else if (onLaual(rida-2, veerg-1)&&(lauaseis[rida-2][veerg-1] == 27 || lauaseis[rida-2][veerg-1] == 32))  {
                        kasTuli = 1;
                    }
                } catch (Exception ignored) {}


                //vankrite TULI (+ lipp)

                //kontrollib mööda sama veergu ülespoole
                try {
                    int k = rida - 1;

                    while (k != -1) {

                        vankersum += lauaseis[k][veerg];

                        if (lauaseis[k][veerg] != 0) {

                            if (vankersum == 26 || vankersum == 33 || vankersum == 29) {
                                kasTuli = 1;
                            }
                            break;
                        }

                        k--;
                    }
                } catch (Exception ignored) {}
                vankersum = 0;

                //kontrollib mööda sama veergu allapoole
                try {
                    int k = rida + 1;

                    while (k != 8) {

                        vankersum += lauaseis[k][veerg];

                        if (lauaseis[k][veerg] != 0) {

                            if (vankersum == 26 || vankersum == 33 || vankersum == 29) {
                                kasTuli = 1;
                            }
                            break;
                        }

                        k++;
                    }
                } catch (Exception ignored) {}
                vankersum = 0;

                //kontrollib mööda sama rida vasakule
                try {
                    int k = veerg - 1;

                    while (k != -1) {

                        vankersum += lauaseis[rida][k];

                        if (lauaseis[rida][k] != 0) {

                            if (vankersum == 26 || vankersum == 33 || vankersum == 29) {
                                kasTuli = 1;
                            }
                            break;
                        }

                        k--;
                    }
                } catch (Exception ignored) {}
                vankersum = 0;

                //kontrollib mööda sama rida paremale
                try {
                    int k = veerg + 1;

                    while (k != 8) {

                        vankersum += lauaseis[rida][k];

                        if (lauaseis[rida][k] != 0) {

                            if (vankersum == 26 || vankersum == 33 || vankersum == 29) {
                                kasTuli = 1;
                            }
                            break;

                        }

                        k++;
                    }
                } catch (Exception ignored) {}
                vankersum = 0;


                //odade tuli (+lipp)

                //kontrollib vasakule yles
                try {
                    int k = veerg - 1;
                    int m = rida - 1;

                    while (k != 0 || m != 0) {

                        odasum += lauaseis[m][k];

                        if (lauaseis[m][k] != 0) {

                            if (odasum == 28 || odasum == 31 || odasum == 29) {
                                kasTuli = 1;
                            }
                            break;
                        }

                        k--;
                        m--;
                    }
                } catch (Exception ignored) {}
                odasum = 0;

                //kontrollib paremale yles
                try {
                    int k = veerg + 1;
                    int m = rida - 1;

                    while (k != 8 || m != 0) {

                        odasum += lauaseis[m][k];

                        if (lauaseis[m][k] != 0) {

                            if (odasum == 28 || odasum == 31 || odasum == 29) {
                                kasTuli = 1;
                            }
                            break;
                        }

                        k++;
                        m--;
                    }
                } catch (Exception ignored) {}
                odasum = 0;

                //kontrollib vasakule alla
                try {
                    int k = veerg - 1;
                    int m = rida + 1;

                    while (k != 0 || m != 8) {

                        odasum += lauaseis[m][k];

                        if (lauaseis[m][k] != 0) {

                            if (odasum == 28 || odasum == 31 || odasum == 29) {
                                kasTuli = 1;
                            }
                            break;
                        }

                        k--;
                        m++;
                    }
                } catch (Exception ignored) {}
                odasum = 0;

                //kontrollib paremale alla
                try {
                    int k = veerg + 1;
                    int m = rida + 1;

                    while (k != 8 || m != 8) {

                        odasum += lauaseis[m][k];

                        if (lauaseis[m][k] != 0) {

                            if (odasum == 28 || odasum == 31 || odasum == 29) {
                                kasTuli = 1;
                            }
                            break;
                        }

                        k++;
                        m++;
                    }
                } catch (Exception ignored) {}
                odasum = 0;


                //kuninga tuli

                try {
                    if (onLaual(rida+1, veerg-1)&&(lauaseis[rida+1][veerg-1] == 30)) {
                        kasTuli = 1;
                    } else if (onLaual(rida+1, veerg)&&(lauaseis[rida+1][veerg] == 30)) {
                        kasTuli = 1;
                    } else if (onLaual(rida+1, veerg+1)&&(lauaseis[rida+1][veerg+1] == 30)) {
                        kasTuli = 1;
                    } else if (onLaual(rida, veerg-1)&&(lauaseis[rida][veerg-1] == 30)) {
                        kasTuli = 1;
                    } else if (onLaual(rida, veerg+1)&&(lauaseis[rida][veerg+1] == 30)) {
                        kasTuli = 1;
                    } else if (onLaual(rida-1, veerg-1)&&(lauaseis[rida-1][veerg-1] == 30)) {
                        kasTuli = 1;
                    } else if (onLaual(rida-1, veerg)&&(lauaseis[rida-1][veerg] == 30)) {
                        kasTuli = 1;
                    } else if (onLaual(rida-1, veerg+1)&&(lauaseis[rida-1][veerg+1] == 30)) {
                        kasTuli = 1;
                    }
                }
                catch (Exception ignored) {}

                tuli[rida][veerg] = kasTuli;
            }
        }
        return tuli;
    }

    private static int[][] valgeTuleTabel(int[][] lauaseis) {


        int kasTuli;
        int vankersum = 0;
        int odasum = 0;
        int[][] tuli = new int[8][8];

        for (int rida = 0; rida < lauaseis.length; rida++) {
            for (int veerg = 0; veerg < lauaseis[rida].length; veerg++) {

                //etturite TULI

                kasTuli = 0;
                try {
                    if (veerg == 0 && rida > 0) {

                        if (lauaseis[rida - 1][veerg + 1] > 9 && lauaseis[rida - 1][veerg + 1] < 18) {

                            kasTuli = 1;

                        }
                    } else if (veerg == 7 && rida > 0) {
                        if (lauaseis[rida-1][veerg-1] > 9 && lauaseis[rida-1][veerg-1] < 18){

                            kasTuli = 1;

                        }
                    } else if ((lauaseis[rida-1][veerg-1] > 9 && lauaseis[rida-1][veerg-1] < 18) || (lauaseis[rida-1][veerg+1] > 9 && lauaseis[rida-1][veerg+1] < 18)) {

                        kasTuli = 1;

                    } else {

                        kasTuli = 0;

                    }
                }

                catch (Exception ignored){}


                //ratsude TULI

                try {
                    if (onLaual(rida+1, veerg+2)&&(lauaseis[rida+1][veerg+2] == 3 || lauaseis[rida+1][veerg+2] == 8)) {
                        kasTuli = 1;
                        //System.out.println("rida: " + rida + ", veerg: " + veerg);
                    } else if (onLaual(rida-1, veerg+2)&&(lauaseis[rida-1][veerg+2] == 3 || lauaseis[rida-1][veerg+2] == 8)) {
                        kasTuli = 1;
                    } else if (onLaual(rida+1, veerg-2)&&(lauaseis[rida+1][veerg-2] == 3 || lauaseis[rida+1][veerg-2] == 8)) {
                        kasTuli = 1;
                    } else if (onLaual(rida-1, veerg-2)&&(lauaseis[rida-1][veerg-2] == 3 || lauaseis[rida-1][veerg-2] == 8)) {
                        kasTuli = 1;
                    } else if (onLaual(rida+2, veerg+1)&&(lauaseis[rida+2][veerg+1] == 3 || lauaseis[rida+2][veerg+1] == 8)) {
                        kasTuli = 1;
                    } else if (onLaual(rida-2, veerg+1)&&(lauaseis[rida-2][veerg+1] == 3 || lauaseis[rida-2][veerg+1] == 8)) {
                        kasTuli = 1;
                    } else if (onLaual(rida+2, veerg-1)&&(lauaseis[rida+2][veerg-1] == 3 || lauaseis[rida+2][veerg-1] == 8)) {
                        kasTuli = 1;
                    } else if (onLaual(rida-2, veerg-1)&&(lauaseis[rida-2][veerg-1] == 3 || lauaseis[rida-2][veerg-1] == 8)) {
                        kasTuli = 1;
                    }
                } catch (Exception ignored) {}


                //vankrite TULI (+ lipp)

                //kontrollib mööda sama veergu ülespoole
                try {
                    int k = rida - 1;

                    while (k != -1) {

                        vankersum += lauaseis[k][veerg];
                        if (lauaseis[k][veerg] != 0) {

                            if (vankersum == 2 || vankersum == 9 || vankersum == 5) {
                                kasTuli = 1;
                            }
                            break;
                        }

                        k--;
                    }
                } catch (Exception ignored) {}
                vankersum = 0;

                //kontrollib mööda sama veergu allapoole
                try {
                    int k = rida + 1;

                    while (k != 8) {

                        vankersum += lauaseis[k][veerg];

                        if (lauaseis[k][veerg] != 0) {

                            if (vankersum == 2 || vankersum == 9 || vankersum == 5) {
                                kasTuli = 1;
                            }
                            break;
                        }

                        k++;
                    }
                } catch (Exception ignored) {}
                vankersum = 0;

                //kontrollib mööda sama rida vasakule
                try {
                    int k = veerg - 1;

                    while (k != -1) {

                        vankersum += lauaseis[rida][k];

                        if (lauaseis[rida][k] != 0) {

                            if (vankersum == 2 || vankersum == 9 || vankersum == 5) {
                                kasTuli = 1;
                            }
                            break;
                        }

                        k--;
                    }
                } catch (Exception ignored) {}
                vankersum = 0;

                //kontrollib mööda sama rida paremale
                try {
                    int k = veerg + 1;

                    while (k != 8) {

                        vankersum += lauaseis[rida][k];

                        if (lauaseis[rida][k] != 0) {

                            if (vankersum == 2 || vankersum == 9 || vankersum == 5) {
                                kasTuli = 1;
                            }
                            break;
                        }

                        k++;
                    }
                } catch (Exception ignored) {}
                vankersum = 0;


                //odade tuli (+lipp)

                //kontrollib vasakule yles
                try {
                    int k = veerg - 1;
                    int m = rida - 1;

                    while (k != 0 || m != 0) {

                        odasum += lauaseis[m][k];

                        if (lauaseis[m][k] != 0) {

                            if (odasum == 4 || odasum == 7 || odasum == 5) {
                                kasTuli = 1;
                            }
                            break;
                        }

                        k--;
                        m--;
                    }
                } catch (Exception ignored) {}
                odasum = 0;

                //kontrollib paremale yles
                try {
                    int k = veerg + 1;
                    int m = rida - 1;

                    while (k != 8 || m != 0) {

                        odasum += lauaseis[m][k];

                        if (lauaseis[m][k] != 0) {

                            if (odasum == 4 || odasum == 7 || odasum == 5) {
                                kasTuli = 1;
                            }
                            break;
                        }

                        k++;
                        m--;
                    }
                } catch (Exception ignored) {}
                odasum = 0;

                //kontrollib vasakule alla
                try {
                    int k = veerg - 1;
                    int m = rida + 1;

                    while (k != 0 || m != 8) {

                        odasum += lauaseis[m][k];

                        if (lauaseis[m][k] != 0) {

                            if (odasum == 4 || odasum == 7 || odasum == 5) {
                                kasTuli = 1;
                            }
                            break;
                        }

                        k--;
                        m++;
                    }
                } catch (Exception ignored) {}
                odasum = 0;

                //kontrollib paremale alla
                try {
                    int k = veerg + 1;
                    int m = rida + 1;

                    while (k != 8 || m != 8) {

                        odasum += lauaseis[m][k];

                        if (lauaseis[m][k] != 0) {

                            if (odasum == 4 || odasum == 7 || odasum == 5) {
                                kasTuli = 1;
                            }
                            break;
                        }

                        k++;
                        m++;
                    }
                } catch (Exception ignored) {}
                odasum = 0;


                //kuninga tuli

                try {
                    if (onLaual(rida+1, veerg-1)&&(lauaseis[rida+1][veerg-1] == 6)) {
                        kasTuli = 1;
                    } else if (onLaual(rida+1, veerg)&&(lauaseis[rida+1][veerg] == 6)) {
                        kasTuli = 1;
                    } else if (onLaual(rida+1, veerg+1)&&(lauaseis[rida+1][veerg+1] == 6)) {
                        kasTuli = 1;
                    } else if (onLaual(rida, veerg-1)&&(lauaseis[rida][veerg-1] == 6)) {
                        kasTuli = 1;
                    } else if (onLaual(rida, veerg+1)&&(lauaseis[rida][veerg+1] == 6)) {
                        kasTuli = 1;
                    } else if (onLaual(rida-1, veerg-1)&&(lauaseis[rida-1][veerg-1] == 6)) {
                        kasTuli = 1;
                    } else if (onLaual(rida-1, veerg)&&(lauaseis[rida-1][veerg] == 6)) {
                        kasTuli = 1;
                    } else if (onLaual(rida-1, veerg+1)&&(lauaseis[rida-1][veerg+1] == 6)) {
                        kasTuli = 1;
                    }
                } catch (Exception ignored) {}

                tuli[rida][veerg] = kasTuli;
            }
        }
        return tuli;
    }

    private static boolean käiguKontroll(int[] kaik2, int varv, int varv2, int kasTühiRuut,
                                         String nupp, int kuhu1, int kuhu2, int akt1, int akt2,
                                         int[][] lauaseis, int vkLiikunud, int vv1Liikunud, int vv2Liikunud,
                                         int mkLiikunud, int mv1Liikunud, int mv2Liikunud) {
        //KÄIGUKONTROLL

        try {                                        //et testimisega outofbounds erroreid ei tuleks

            if (nupp.equals("etturKlass")) {

                if (varv == 0) {

                    if ((kaik2[0] - kaik2[0] % 10) / 10 == 2) {   //ettur saab käia 2 sammu kui on algpositsioonil
                        if (kaik2[1] - kaik2[0] == 20) {
                            return true;
                        }
                    }

                    if (kaik2[1] - kaik2[0] == 10 && kasTühiRuut == 0) {  //arvutab koordinaatide järgi kas käik on võimalik
                        return true;
                    } else if ((kaik2[1] - kaik2[0] == 9 && kasTühiRuut != 0) || (kaik2[1] - kaik2[0] == 11 && kasTühiRuut != 0)) {
                        return true;
                    } else {
                        return false;
                    }

                } else {
                    //ehk siis mustad
                    if ((kaik2[0] - kaik2[0] % 10) / 10 == 7) {
                        if (kaik2[0] - kaik2[1] == 20) {
                            return true;
                        }
                    }

                    if (kaik2[0] - kaik2[1] == 10) {
                        return true;
                    } else if ((kaik2[0] - kaik2[1] == 9 && kasTühiRuut != 0) || (kaik2[0] - kaik2[1] == 11 && kasTühiRuut != 0)) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }

            if (nupp.equals("ratsuKlass")) {

                if ((Math.abs(kaik2[1] - kaik2[0]) == 8 || Math.abs(kaik2[1] - kaik2[0]) == 12 || Math.abs(kaik2[1] - kaik2[0]) == 19 || Math.abs(kaik2[1] - kaik2[0]) == 21) && ((varv == 0 && kasTühiRuut != 3 && kasTühiRuut != 8) || (varv == 1 && kasTühiRuut != 27 && kasTühiRuut != 32)) && varv != varv2) {  //arvutab koordinaatide järgi kas kaik on võimalik

                    return true;

                } else {
                    System.out.println();
                    return false;
                }

            }

            if (nupp.equals("vankerKlass")) {

                if (akt2 == kuhu2) {

                    //vertikaalne liikumine
                    System.out.println(Math.abs(kaik2[1] - kaik2[0]) % 10);
                    if (akt1 > kuhu1) {

                        for (int i = akt1 - 1; i > kuhu1; i--) {

                            if (lauaseis[i - 1][kuhu2 - 1] != 0) {
                                System.out.println("siin on nupp: " + lauaseis[i - 1][kuhu2 - 1]);
                                return false;
                            }
                        }

                    } else if (akt1 < kuhu1) {  // akt1<kuhu1

                        for (int i = akt1 + 1; i < kuhu1; i++) {   // see korda teha

                            if (lauaseis[i - 1][kuhu2 - 1] != 0) {
                                System.out.println("siin on nupp: " + lauaseis[i - 1][kuhu2 - 1]);
                                return false;
                            }
                        }
                    }

                    if (varv != varv2) {
                        return true;
                    }


                } else if (akt1 == kuhu1) {  //horisontaalne liikumine

                    if (akt2 > kuhu2) {

                        for (int i = akt2 - 1; i > kuhu2; i--) {

                            if (lauaseis[kuhu1 - 1][i - 1] != 0) {
                                System.out.println("siin on nupp: " + lauaseis[kuhu1 - 1][i - 1]);
                                return false;
                            }
                        }

                    } else {  // akt1<kuhu1

                        for (int i = akt2 + 1; i < kuhu2; i++) {

                            if (lauaseis[kuhu1 - 1][i - 1] != 0) {
                                System.out.println("siin on nupp: " + lauaseis[kuhu1 - 1][i - 1]);
                                return false;
                            }
                        }
                    }

                    if (varv != varv2) {
                        return true;
                    }
                }
            }

            if (nupp.equals("odaKlass")) {

                //käib diagonaalis

                if (Math.abs(kaik2[1] - kaik2[0]) % 9 == 0 || Math.abs(kaik2[1] - kaik2[0]) % 11 == 0) {

                    if (akt1 < kuhu1 && akt2 < kuhu2) {  //alla paremale

                        int j = akt2 + 1;
                        for (int i = akt1 + 1; i < kuhu1; i++) {

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

                            if (lauaseis[i - 1][j - 1] != 0) {
                                System.out.println("siin on nupp: " + lauaseis[i - 1][j - 1]);
                                return false;
                            }
                            j--;
                        }
                    }

                    if (varv != varv2) {
                        return true;
                    }
                }
            }

            if (nupp.equals("lippKlass")) {

                if (Math.abs(kaik2[1] - kaik2[0]) % 9 == 0 || Math.abs(kaik2[1] - kaik2[0]) % 11 == 0) {

                    if (akt1 < kuhu1 && akt2 < kuhu2) {  //alla paremale

                        int j = akt2 + 1;
                        for (int i = akt1 + 1; i < kuhu1; i++) {

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

                            if (lauaseis[i - 1][j - 1] != 0) {
                                System.out.println("siin on nupp: " + lauaseis[i - 1][j - 1]);
                                return false;
                            }
                            j--;
                        }
                    }

                    if (varv != varv2) {
                        return true;
                    }

                } else if (akt1 == kuhu1 || akt2 == kuhu2) {

                    if (akt2 == kuhu2) {

                        //vertikaalne liikumine
                        System.out.println(Math.abs(kaik2[1] - kaik2[0]) % 10);
                        if (akt1 > kuhu1) {

                            for (int i = akt1 - 1; i > kuhu1; i--) {

                                if (lauaseis[i - 1][kuhu2 - 1] != 0) {
                                    System.out.println("siin on nupp: " + lauaseis[i - 1][kuhu2 - 1]);
                                    return false;
                                }
                            }

                        } else if (akt1 < kuhu1) {  // akt1<kuhu1

                            for (int i = akt1 + 1; i < kuhu1; i++) {

                                if (lauaseis[i - 1][kuhu2 - 1] != 0) {
                                    System.out.println("siin on nupp: " + lauaseis[i - 1][kuhu2 - 1]);
                                    return false;
                                }
                            }
                        }

                        if (varv != varv2) {
                            return true;
                        }


                    } else if (akt1 == kuhu1) {  //horisontaalne liikumine

                        if (akt2 > kuhu2) {

                            for (int i = akt2 - 1; i > kuhu2; i--) {

                                if (lauaseis[kuhu1 - 1][i - 1] != 0) {
                                    System.out.println("siin on nupp: " + lauaseis[kuhu1 - 1][i - 1]);
                                    return false;
                                }
                            }


                        } else {  // akt1<kuhu1

                            for (int i = akt2 + 1; i < kuhu2; i++) {

                                if (lauaseis[kuhu1 - 1][i - 1] != 0) {
                                    System.out.println("siin on nupp: " + lauaseis[kuhu1 - 1][i - 1]);
                                    return false;
                                }
                            }
                        }

                        if (varv != varv2) {
                            return true;
                        }
                    }
                }
            }



            if (nupp.equals("kuningasKlass")) {

                // vangerdus
                if (varv == 0) {
                    if (akt1 == 1 && akt2 == 5 && kuhu1 == 1 && kuhu2 == 2) {  //kui astub oma vankrite k6rvale
                        if(vkLiikunud == 0 && vv1Liikunud == 0){
                            if((mustTuleTabel(lauaseis)[0][1] != 1) &&
                                    (mustTuleTabel(lauaseis)[0][2] != 1) &&
                                    (mustTuleTabel(lauaseis)[0][3] != 1)){

                                System.out.println("Vangerdus");
                                return true;

                            }
                        }
                    }else if (akt1 == 1 && akt2 == 5 && kuhu1 == 1 && kuhu2 == 7){
                        if(vkLiikunud == 0 && vv2Liikunud == 0){
                            if((mustTuleTabel(lauaseis)[0][5] != 1) &&
                                    (mustTuleTabel(lauaseis)[0][6] != 1)){

                                System.out.println("Vangerdus");
                                return true;

                            }
                        }
                    }
                }

                if (varv == 1) {
                    if (akt1 == 8 && akt2 == 5 && kuhu1 == 8 && kuhu2 == 2) {
                        if(mkLiikunud == 0 && mv1Liikunud == 0){
                            if((valgeTuleTabel(lauaseis)[7][1] != 1) &&
                                    (valgeTuleTabel(lauaseis)[7][2] != 1) &&
                                    (valgeTuleTabel(lauaseis)[7][3] != 1)){

                                System.out.println("Vangerdus");
                                return true;

                            }
                        }
                    } else if (akt1 == 8 && akt2 == 5 && kuhu1 == 8 && kuhu2 == 7){
                        if(mkLiikunud == 0 && mv2Liikunud == 0){
                            if((valgeTuleTabel(lauaseis)[7][5] != 1) &&
                                    (valgeTuleTabel(lauaseis)[7][6] != 1)){

                                System.out.println("Vangerdus");
                                return true;

                            }
                        }
                    }
                }

                if ((varv == 0 && mustTuleTabel(lauaseis)[kuhu1 - 1][kuhu2 - 1] != 1) ||
                        (varv == 1 && valgeTuleTabel(lauaseis)[kuhu1 - 1][kuhu2 - 1] != 1)) {
                    if (akt1 - kuhu1 == 0) {                  // ehk on samal real
                        if (Math.abs(akt2 - kuhu2) == 1) {   // 1 samm mõlemas suunas
                            if (varv != varv2) {             // ei ole oma nupp
                                return true;                   // siis sobib
                            }
                        }
                    }

                    if (akt1 - kuhu1 == -1) {                 //tahab astuda suurema numbriga reale
                        if (Math.abs(akt2 - kuhu2) == 1 || Math.abs(akt2 - kuhu2) == 0) {
                            if (varv != varv2) {
                                return true;
                            }
                        }
                    }

                    if (akt1 - kuhu1 == 1) {                 //tahab astuda väiksema numbriga reale
                        if (Math.abs(akt2 - kuhu2) == 1 || Math.abs(akt2 - kuhu2) == 0) {
                            if (varv != varv2) {
                                return true;
                            }
                        }
                    }
                }
                System.out.println("Nii ei saa");
            }
        } catch (Exception ignored) {}

        return false;
    }
}
