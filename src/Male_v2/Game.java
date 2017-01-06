package Male_v2;

import javafx.application.Platform;
import java.util.concurrent.ThreadLocalRandom;
import static Male_v2.Aken.sisend;
import static java.lang.Integer.parseInt;


class Game {

    static int k2ik(){

        String mov = sisend.getText();              //võtab textfieldist soovitud käigu stringina

        try {                                       //try block et mittenumbrite sisestamisega tegeleda
            int move = Integer.parseInt(mov);

            if (((int) Math.log10(move) + 1) == 4){         //kontrollib pikkust

                sisend.clear();
                Platform.runLater(() -> sisend.requestFocus());

                return move;                    //kui pikkuse- ja tüübifiltri läbib, siis läheb number edasi
            }

            move = 9999;                            //see näitab et käik pole sobilik
            return move;

        }catch(NumberFormatException nfe){
            System.out.println("Ei ole number");
        }

        return 9999;
    }

    static int testk2ik() {                  //toodab suvalisi neljakohalisi numbreid

        String y = "";
        int r;
        for (int i = 0; i < 4; i++){
            r = ThreadLocalRandom.current().nextInt(1, 9);
            y += r;
        }

        return parseInt(y);
    }
}