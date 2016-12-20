package Male_v2;



import javafx.application.Platform;


import static Male_v2.Aken.sisend;


public class Game {


    public static int[] k2ik(){

        String koos = sisend.getText();
        int kust = Integer.parseInt(koos.substring(0, 2));
        int kuhu = Integer.parseInt(koos.substring(2, 4));
        int[] move = {kust, kuhu};
        sisend.clear();
        Platform.runLater(() -> sisend.requestFocus());

        return move;
    }
}
