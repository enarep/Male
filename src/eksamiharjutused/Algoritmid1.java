package eksamiharjutused;


import java.util.Arrays;

/**
 * Antud on int[] massiiv. Eemalda kõik nr 3 väärtused ja leia millist numbrit esineb kõige siis rohkem?
 * Mitte siis number, mis on kolmandal indeksil, vaid nr kolm ise.
 */

public class Algoritmid1 {

    public static void main(String[] args) {  //t;;tab ainult ühekohaliste positiivsete numbritega


        int[] naide = {2, 2, 2, 1, 5, 3, 3, 6, 3, 7, 7, 7, 7, 2, 2, 5, 3, 3, 9, 8, 5, 5, 3, 1, 5, 5, 5}; // vastus on 7
        int nr = 3;
        int k = 0;
        int c = 0;
        int max = 0;
        int temp1;
        int temp2 = 0;
        char pop = 0;

        for (int j : naide){
            if (j == nr){
                naide[k] = 0;
                c++;
            }
            k++;
        }

        Arrays.sort(naide);
        int[] uus = Arrays.copyOfRange(naide, c, naide.length);

        StringBuilder sb = new StringBuilder(uus.length);

        for (int i : uus){
            sb.append(i);
        }

        String s = sb.toString();

        for (int g = 0; g < s.length(); g++){

            temp1 = s.lastIndexOf(s.charAt(g)) - s.indexOf(s.charAt(g));

            if (temp1 > temp2){
                max = temp1;
                temp2 = temp1;
                pop = s.charAt(g);
            }

        }


        System.out.println("Nr " + pop + " esineb " + (max+1) + " korda");

    }

}
