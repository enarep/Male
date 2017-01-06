package Male_v2;



import javafx.scene.layout.HBox;

import java.util.HashMap;



public class Laud {


    static HashMap<Integer, HBox> nupumap = Nupud.mapiNupud();


    Laud(){

        asetaNupud(nupumap);

    }

    public void asetaNupud(HashMap<Integer, HBox> nupud) {


        for (int k = 0; k < 8; k++) {

            Aken.muutuvlaud.add(nupud.get(k), k, 0);

        }

        int k = 0;
        for (int n = 8; n < 16; n++) {

            Aken.muutuvlaud.add(nupud.get(n), k, 1);
            k++;
        }

        k = 0;
        for (int x = 16; x < 24; x++) {

            Aken.muutuvlaud.add(nupud.get(x), k, 6);
            k++;
        }

        k = 0;
        for (int y = 24; y < 32; y++) {

            Aken.muutuvlaud.add(nupud.get(y), k, 7);
            k++;
        }



    }

}
