package eksamiharjutused;

public class OOP2 {


    /**
     * Loo see Pastaka objekt, mida kirjanik soovib siin kasutada.
     *
     * Reeglid:
     * 1. Käesolevat faili ei tohi muuta
     * 2. Kui pastakas kirjutab siis tuleb tekst konsooli - kuni tinti jätkub.
     * 3. Iga täht kulutab ühe ühiku.
     */

    public static void main(String[] args) {
        int tindiKogus = 60;

        Pastakas pastakas = new Pastakas(tindiKogus);

        pastakas.kirjuta("Elu oleks palju lihtsam, kui meil oleks selle lähtekood.");

        pastakas.prindiPaljuTintiAlles();

        pastakas.kirjuta("Õiged progejad ei kommenteeri oma koodi. Kui seda oli raske kirjutada, siis peab olema seda ka raske lugeda!");

    }

    static class Pastakas{

        private int tindikogus;

        Pastakas(int tindiKogus){

            this.tindikogus = tindiKogus;

        }

        void kirjuta(String s){

            for (int i = 0; i < s.length(); i++){

                if(tindikogus > 0) {
                    System.out.print(s.charAt(i));
                    tindikogus--;
                }

            }
            System.out.println();

        }

        void prindiPaljuTintiAlles(){

            System.out.println(tindikogus);

        }

    }

}
