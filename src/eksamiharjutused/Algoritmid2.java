package eksamiharjutused;




/**
 * Antud on int[] massiiv. Korruta kõik seitsmed kahega ja leia arvude keskmine.
 */
public class Algoritmid2 {

    public static void main(String[] args) {

        int[] naide = {7, 4, 324, 65, 4, 78, 7, 45, 4};
        int sum = 0;
        int avg;

        for (int i : naide){

            if (i == 7){

                i = i*8;

            }
            sum += i;
        }

        avg = sum/naide.length;

        System.out.println(avg);

    }




}
