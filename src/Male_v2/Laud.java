package Male_v2;

import javafx.scene.Node;
import javafx.scene.layout.HBox;
import java.util.HashMap;


class Laud {

    static HashMap nupumap = Nupud.mapiNupud();

    Laud(){
        asetaNupud(nupumap);
    }

    //asetab nuppude objektid mängulauale

    private void asetaNupud(HashMap nupud) {

        for (int k = 0; k < 8; k++) {

            Aken.muutuvlaud.add((Node) nupud.get(k), k, 0);

        }
        int k = 0;

        for (int n = 8; n < 16; n++) {

            Aken.muutuvlaud.add((Node) nupud.get(n), k, 1);
            k++;
        }
        k = 0;

        for (int x = 16; x < 24; x++) {

            Aken.muutuvlaud.add((Node) nupud.get(x), k, 6);
            k++;
        }
        k = 0;

        for (int y = 24; y < 32; y++) {

            Aken.muutuvlaud.add((Node) nupud.get(y), k, 7);
            k++;
        }
    }
}
