package eksamiharjutused;

import java.util.HashMap;

/**
 * Created by tmp145 on 25.01.2017.
 */
public class OOP1 {
    /**
     * Loo Chat klass, et käesolev programm saaks normaalselt toimida.
     *
     * On üks reegel: Gitter klassi muuta ei tohi.
     */
    public static void main(String[] args) {

        String toaNimi = "Elutuba";
        Chat chat = new Chat(toaNimi);

        chat.sisestaSonum("Taavi", "Tere, on keegi siin?");
        chat.sisestaSonum("Eva", "Tsau, ilus poiss. Mis otsid?");
        chat.sisestaSonum("Taavi", "Kuule, ega sa ei tea kuidas seda OOP ülesannet lahendada?");
        chat.sisestaSonum("Taavi", "Pean siin nii kasutajanime kui ka sõnumi kuhugi salvestama..");
        chat.sisestaSonum("Eva", "Oh sind totut, võimalusi on ju mitu.");
        chat.sisestaSonum("Eva", "Aga pead ise välja mõtlema");
        chat.sisestaSonum("Eva", "sest õppejõud näeb meie kirjutatut.");
        chat.sisestaSonum("Taavi", "Kurat ta jälle nii raske eksami tegi..");

        chat.prindiKoikSonumidKoosKasutajanimega();

        chat.adminKustutabSonumi("Kurat ta jälle nii raske eksami tegi..");
        chat.sisestaSonum("Krister", "Sul veab, et siin chatis välja viskamise funktsionaalsust ei ole :)");

        chat.prindiKoikSonumidKoosKasutajanimega();
        chat.prindiToaNimi();

    }

    static class Chat{

        private HashMap<Integer, String> sonumid = new HashMap<>();
        private int count = 0;
        private String toanimi;


        Chat(String toanimi){
            this.toanimi = toanimi;
        }

        void sisestaSonum(String kasutaja, String sonum){

            sonumid.put(count, kasutaja);
            count++;
            sonumid.put(count, sonum);
            count++;
        }

        void prindiKoikSonumidKoosKasutajanimega(){

            for (int i = 0; i < sonumid.size(); i += 2){

                System.out.print(sonumid.get(i) + ": ");
                System.out.println(sonumid.get(i + 1));

            }
        }

        void adminKustutabSonumi(String kustutatav){

            for (int i = 1; i < sonumid.size(); i += 2){

                if (sonumid.get(i).equals(kustutatav)){
                    sonumid.remove(i);
                    count--;
                    sonumid.remove(i - 1);
                    count--;
                }
            }
        }

        void prindiToaNimi(){

            System.out.println(toanimi);

        }


    }
}


