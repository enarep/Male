package Male_v2;

import javafx.application.Platform;

import java.util.concurrent.ThreadLocalRandom;

import static Male_v2.Aken.sisend;
import static java.lang.Integer.parseInt;


public class Game {

    public static int k2ik(){

        String mov = sisend.getText();

        try {
            int move = Integer.parseInt(mov);

            if (((int) Math.log10(move) + 1) == 4){

                sisend.clear();
                Platform.runLater(() -> sisend.requestFocus());

                return move;
            }
            move = 9999;
            return move;

        }catch(NumberFormatException nfe){
            System.out.println("Ei ole number");
        }

        return 9999;
    }

    public static int testk2ik() {

        String y = "";
        int r;
        for (int i = 0; i < 4; i++){
            r = ThreadLocalRandom.current().nextInt(1, 9);
            y += r;
        }

        return parseInt(y);
    }
}
