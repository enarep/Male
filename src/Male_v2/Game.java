package Male_v2;



import javafx.application.Platform;


import static Male_v2.Aken.sisend;


public class Game {


    public static int k2ik(){

        //System.out.println(sisend.getText());
        int move = Integer.parseInt(sisend.getText());
        sisend.clear();
        Platform.runLater(() -> sisend.requestFocus());



        return move;
    }
}
