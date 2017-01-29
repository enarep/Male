package eksamiharjutused;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by tmp145 on 25.01.2017.
 */
public class OOP6 {

    /**
     * Raamatukogus on Sõnaraamat. Õigemini siis on, kui sa selle klassi kirjutad.
     *
     * Raamatukogu klassi ei tohi muuta.
     */

    public static void main(String[] args) {

        String raamatuKeel = "Eesti";
        Sonaraamat raamat = new Sonaraamat(raamatuKeel);
        raamat.sisestaSona("puaas");
        raamat.sisestaSona("uubuma");
        raamat.sisestaSona("uudikristamine");
        raamat.sisestaSona("suaree");
        raamat.sisestaSona("sarkasm");
        raamat.sisestaSona("iroonia");

        String[] vaste = raamat.otsiEsimeseTaheJargi("u");
        System.out.println(Arrays.toString(vaste));

        String[] vaste2 = raamat.otsiEsimeseTaheJargi("s");
        System.out.println(Arrays.toString(vaste2));

        raamat.eemaldaSona(vaste2[0]);

        raamat.misKeelesRaamatOn();

    }

    static class Sonaraamat{

        private String keel;
        ArrayList raamat = new ArrayList();
        ArrayList vaste = new ArrayList();

        Sonaraamat(String keel){
            this.keel = keel;
        }

        void sisestaSona (String sona){

            raamat.add(sona);

        }

        String[] otsiEsimeseTaheJargi(String taht){

            char s = taht.charAt(0);
            for(int i = 0; i < raamat.size(); i++){

                if (((String) raamat.get(i)).charAt(0) == s ){

                    vaste.add(raamat.get(i));

                }
            }

            String[] str = new String[vaste.size()];
            for (int j = 0; j < vaste.size(); j++){

                str[j] = (String) vaste.get(j);

            }
            vaste.clear();
            return str;
        }

        void eemaldaSona(String s){

            raamat.remove(s);

        }

        void misKeelesRaamatOn(){

            System.out.println(keel);

        }

    }


}
