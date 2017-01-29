package eksamiharjutused;

/**
 * Antud on kaks massiivi õhu temperatuuridega. Arvuta mõlema puhul mitu positiivset temperatuuri
 * on massiivis rohkem kui negatiivseid.
 */

public class Algoritmid4 {

    public static void main(String[] args) {

        int[] kraadid1 = {11, 10, 5, 1, 3, -2, -6, 2, -13, -24, -9, 0};
        int[] kraadid2 = {-23, -25, -22, -18, -15, -19, -13};

        System.out.println(meetod(kraadid1) + ", " + meetod(kraadid2));



    }
    static int meetod(int[] kraadid){

        int poscount = 0;
        int negcount = 0;

        for (int i : kraadid){

            if(i > 0){

                poscount++;

            }else if (i < 0){

                negcount++;

            }

        }

        return poscount-negcount;
    }

}
