package Male_v2;


import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.util.HashMap;

class Nupud {

    static Ettur ettur10;
    static Ettur ettur11;
    static Ettur ettur12;
    static Ettur ettur13;
    static Ettur ettur14;
    static Ettur ettur15;
    static Ettur ettur16;
    static Ettur ettur17;
    static Ettur ettur18;
    static Ettur ettur19;
    static Ettur ettur20;
    static Ettur ettur21;
    static Ettur ettur22;
    static Ettur ettur23;
    static Ettur ettur24;
    static Ettur ettur25;
    static Ratsu ratsu3;
    static Ratsu ratsu8;
    static Ratsu ratsu27;
    static Ratsu ratsu32;
    static Vanker vanker2;
    static Vanker vanker9;
    static Vanker vanker26;
    static Vanker vanker33;
    static Oda oda4;
    static Oda oda7;
    static Oda oda28;
    static Oda oda31;
    static Lipp lipp5;
    static Lipp lipp29;
    static Kuningas kuningas6;
    static Kuningas kuningas30;



    public static HashMap<Integer, Malend> malendid;





    Nupud(){

        initNupud();

    }



    public static HashMap mapiNupud() {

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

        return nupud3;

    }

    public static HashMap<Integer, Malend> initNupud() {

        ettur10 = new Ettur(10);
        ettur11 = new Ettur(11);
        ettur12 = new Ettur(12);
        ettur13 = new Ettur(13);
        ettur14 = new Ettur(14);
        ettur15 = new Ettur(15);
        ettur16 = new Ettur(16);
        ettur17 = new Ettur(17);
        ettur18 = new Ettur(18);
        ettur19 = new Ettur(19);
        ettur20 = new Ettur(20);
        ettur21 = new Ettur(21);
        ettur22 = new Ettur(22);
        ettur23 = new Ettur(23);
        ettur24 = new Ettur(24);
        ettur25 = new Ettur(25);
        ratsu3 = new Ratsu(3);
        ratsu8 = new Ratsu(8);
        ratsu27 = new Ratsu(27);
        ratsu32 = new Ratsu(32);
        vanker2 = new Vanker(2);
        vanker9 = new Vanker(9);
        vanker26 = new Vanker(26);
        vanker33 = new Vanker(33);
        oda4 = new Oda(4);
        oda7 = new Oda(7);
        oda28 = new Oda(28);
        oda31 = new Oda(31);
        lipp5 = new Lipp(5);
        lipp29 = new Lipp(29);
        kuningas6 = new Kuningas(6);
        kuningas30 = new Kuningas(30);

        malendid = new HashMap<>();

        malendid.put(10, ettur10);
        malendid.put(11, ettur11);
        malendid.put(12, ettur12);
        malendid.put(13, ettur13);
        malendid.put(14, ettur14);
        malendid.put(15, ettur15);
        malendid.put(16, ettur16);
        malendid.put(17, ettur17);
        malendid.put(18, ettur18);
        malendid.put(19, ettur19);
        malendid.put(20, ettur20);
        malendid.put(21, ettur21);
        malendid.put(22, ettur22);
        malendid.put(23, ettur23);
        malendid.put(24, ettur24);
        malendid.put(25, ettur25);
        malendid.put(3, ratsu3);
        malendid.put(8, ratsu8);
        malendid.put(27, ratsu27);
        malendid.put(32, ratsu32);
        malendid.put(2, vanker2);
        malendid.put(9, vanker9);
        malendid.put(26, vanker26);
        malendid.put(33, vanker33);
        malendid.put(4, oda4);
        malendid.put(7, oda7);
        malendid.put(28, oda28);
        malendid.put(31, oda31);
        malendid.put(5, lipp5);
        malendid.put(29, lipp29);
        malendid.put(6, kuningas6);
        malendid.put(30, kuningas30);

        return malendid;

    }


    static class Malend {

        int värv;
        int number;
        int[][] tuli;
        String pilt;

    }

    public static class Ettur extends Malend {

        //konstruktor
        Ettur(int x) {
            number = x;
            pilt = nupupildid[x-2];
            if (number > 9 && number < 18) {
                tuli = new int[][]{{1, -1}, {1, 1}}; //suhteline rida, veerg
                värv = 0;
            } else if (number > 17 && number < 26) {
                värv = 1;
            }
        }

    }

    public static class Ratsu extends Malend {

        //konstruktor
        Ratsu(int x) {
            number = x;
            pilt = nupupildid[x-2];
            if (number == 3 || number == 8) {
                värv = 0;
            } else if (number == 27 || number == 32) {
                värv = 1;
            }
        }

    }

    public static class Vanker extends Malend {

        //konstruktor
        Vanker(int x) {
            number = x;
            pilt = nupupildid[x-2];
            if (number == 2 || number == 9) {
                värv = 0;
            } else if (number == 26 || number == 33) {
                värv = 1;
            }
        }

    }

    public static class Oda extends Malend {

        //konstruktor
        Oda(int x) {
            number = x;
            pilt = nupupildid[x-2];
            if (number == 4 || number == 7) {
                värv = 0;
            } else if (number == 28 || number == 31) {
                värv = 1;
            }
        }

    }

    public static class Lipp extends Malend {

        //konstruktor
        Lipp(int x) {
            number = x;
            pilt = nupupildid[x-2];
            if (number == 5) {
                värv = 0;
            } else if (number == 29) {
                värv = 1;
            }
        }

    }

    public static class Kuningas extends Malend {


        //konstruktor
         Kuningas(int x) {
            number = x;
            pilt = nupupildid[x-2];
            if (number == 6) {
                värv = 0;
            } else if (number == 30) {
                värv = 1;
            }
        }



    }

    static String[] nupupildid = {
            "vanker0.png",
            "ratsu0.png",
            "oda0.png",
            "lipp0.png",
            "kuningas0.png",
            "oda0.png",
            "ratsu0.png",
            "vanker0.png",
            "ettur0.png",
            "ettur0.png",
            "ettur0.png",
            "ettur0.png",
            "ettur0.png",
            "ettur0.png",
            "ettur0.png",
            "ettur0.png",
            "ettur1.png",
            "ettur1.png",
            "ettur1.png",
            "ettur1.png",
            "ettur1.png",
            "ettur1.png",
            "ettur1.png",
            "ettur1.png",
            "vanker1.png",
            "ratsu1.png",
            "oda1.png",
            "lipp1.png",
            "kuningas1.png",
            "oda1.png",
            "ratsu1.png",
            "vanker1.png"

    };

}

