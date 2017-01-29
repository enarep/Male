package eksamiharjutused;

/**
 * Created by tmp145 on 25.01.2017.
 */

import java.util.ArrayList;

/**
 * Siin failis kasutatakse objekti Kassa, aga Kassa klassi ei eksisteeri. Sinu ülesanne
 * on see luua.
 *
 * Käesolevat klassi ei tohi muuta - mitte ühtegi tähemärki!
 *
 * Jep, sama ülesanne oli ka proovieksamis.
 */

public class OOP5 {

    public static void main(String[] args) {

        String kassapidaja = "Laine";
        Kassa kassa = new Kassa(kassapidaja);

        kassa.lisaToode("Piim");
        kassa.lisaToode("Sai");
        kassa.lisaToode("Lillkapsas");
        kassa.lisaToode("Lamuu jäätis");
        kassa.lisaToode("Kanepiküpsis");
        kassa.eemaldaToode("Piim");
        kassa.eemaldaToode("Sai");
        kassa.lisaToode("Leib");

        kassa.prindiOstutsekk();
        kassa.prindiKassapidajaNimi();
    }

    static class Kassa{

        private String kp;
        ArrayList kassa = new ArrayList();

        Kassa(String kp){
            this.kp = kp;
        }

        void lisaToode (String toode){

            kassa.add(toode);

        }

        void eemaldaToode(String toode){

            kassa.remove(toode);

        }

        void prindiOstutsekk(){

            for (int i = 0; i < kassa.size(); i++){
                System.out.println(kassa.get(i));
            }
        }

        void prindiKassapidajaNimi(){

            System.out.println(kp);

        }

    }


}
