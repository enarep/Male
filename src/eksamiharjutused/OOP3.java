package eksamiharjutused;

/**
 * Created by tmp145 on 25.01.2017.
 */
public class OOP3 {

    public static void main(String[] args) {
        int kollilElusid;

        int elusid = 35;
        Zelda zelda = new Zelda(elusid);

        kollilElusid = 25;
        zelda.kaklusKolliga(kollilElusid);

        zelda.prindiMituEluAlles();

        kollilElusid = 57;
        zelda.kaklusKolliga(kollilElusid);

        zelda.prindiKasOnElus();

    }

    static class Zelda{

        private int elud;

        Zelda(int elud){
            this.elud = elud;
        }

        void kaklusKolliga(int kollielud){

            elud = elud - kollielud;

        }

        void prindiMituEluAlles(){

            System.out.println(elud);

        }

        void prindiKasOnElus(){

            if(elud > 0){

                System.out.println("Elus");

            } else {

                System.out.println("Surnud");

            }

        }

    }
}
