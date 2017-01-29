package eksamiharjutused;

/**
 * Antud on massiiv. Mitu sõne on massiivis keskmisest pikemad?
 */
public class Algoritmid3 {


    public static void main(String[] args) {

        String[] naide = {"kaalikas", "joonas", "maakera", "homeros", "mandel"}; // vastus on 3
        int count = 0;
        int sum = 0;
        int avg;

        for (String i : naide){

            sum += i.length();

        }
        avg = sum/naide.length;

        for (String j : naide){

            if(j.length() > avg){
                count++;
            }
        }
        System.out.println(count);
    }


}
