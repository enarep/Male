

import java.util.*;


public class Main {
    public static void main(String args[]){

        // LAUA LOOMINE

        // loob mustade ja valgete ruutudega laua

        int k = 0;
        int[][] laud = new int[8][8];

        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){

                if (k % 2 == 0) {   //loendab kas on paaris või paaritu et 0 ja 1 lauale vaheldumisi panna
                    laud[i][j] = 1;
                }

                if (j != 7) {
                    k++;             //välja arvatud juhul kui ta on rea lõpus, et read erinevad tuleks
                }
            }
        }


        // LAUA PRINTIMINE


        for(int rida = 0; rida < laud.length; rida++){
            for(int veerg = 0; veerg < laud[rida].length; veerg++){
                System.out.print(laud[rida][veerg]+"\t");
            }
            System.out.println();
        }

        System.out.println();

        // MÄNGULAUD



        // loob kahemõõtmelise massiivi nuppude asukohtade jaoks
        int[][] lauaseis = new int[][]{{2, 3, 4, 5, 6, 7, 8, 9}, {10, 11, 12, 13, 14, 15, 16, 17}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {18, 19, 20, 21, 22, 23, 24, 25}, {26, 27, 28, 29, 30, 31, 32, 33}};

        for(int rida2 = 0; rida2 < lauaseis.length; rida2++){
            for(int veerg2 = 0; veerg2 < lauaseis[rida2].length; veerg2++){
                System.out.print(lauaseis[rida2][veerg2]+"\t");
            }
            System.out.println();
        }

        //malendite objektid
        Ettur ettur10 = new Ettur(10);
        Ettur ettur11 = new Ettur(11);
        Ettur ettur12 = new Ettur(12);
        Ettur ettur13 = new Ettur(13);
        Ettur ettur14 = new Ettur(14);
        Ettur ettur15 = new Ettur(15);
        Ettur ettur16 = new Ettur(16);
        Ettur ettur17 = new Ettur(17);
        Ettur ettur18 = new Ettur(18);
        Ettur ettur19 = new Ettur(19);
        Ettur ettur20 = new Ettur(20);
        Ettur ettur21 = new Ettur(21);
        Ettur ettur22 = new Ettur(22);
        Ettur ettur23 = new Ettur(23);
        Ettur ettur24 = new Ettur(24);
        Ettur ettur25 = new Ettur(25);
        Ratsu ratsu3 = new Ratsu(3);
        Ratsu ratsu8 = new Ratsu(8);
        Ratsu ratsu27 = new Ratsu(27);
        Ratsu ratsu32 = new Ratsu(32);
        Vanker vanker2 = new Vanker(2);
        Vanker vanker9 = new Vanker(9);
        Vanker vanker26 = new Vanker(26);
        Vanker vanker33 = new Vanker(33);

        //HashMap<Integer, Ettur> etturid = new HashMap<Integer, Ettur>();

        HashMap<Integer, Malend> malendid = new HashMap<Integer, Malend>();

        malendid.put(10, ettur10);
        malendid.put(11, ettur11);
        malendid.put(12, ettur12);
        malendid.put(13, ettur13);
        malendid.put(14, ettur14);
        malendid.put(15, ettur15);
        malendid.put(16, ettur16);
        malendid.put(17, ettur17);
        malendid.put(18, ettur18);
        malendid.put(19, ettur19);
        malendid.put(20, ettur20);
        malendid.put(21, ettur21);
        malendid.put(22, ettur22);
        malendid.put(23, ettur23);
        malendid.put(24, ettur24);
        malendid.put(25, ettur25);
        malendid.put(3, ratsu3);
        malendid.put(8, ratsu8);
        malendid.put(27, ratsu27);
        malendid.put(32, ratsu32);
        malendid.put(2, vanker2);
        malendid.put(9, vanker9);
        malendid.put(26, vanker26);
        malendid.put(33, vanker33);


        //MÄNGU KÄIK

        int kelleKord = 0;
        int turnCounter = 1;



        while(true){

            System.out.println(turnCounter + ". ring");
            if (kelleKord == 0){
                System.out.println("Valgete kord");
            }else{
                System.out.println("Mustade kord");
            }

            // klaviatuuriga sisestatakse käik


            // while tsükli sees talle ei meeldinud nende muutujate deklareerimine
            int akt2;
            int akt1;
            Scanner sisend = new Scanner(System.in);
            int käik;
            int[] käik2 = new int[2];
            int aktiivneNupp;
            int v6etavNupp;
            int kuhu1;
            int kuhu2;
            int värv;
            int värv2;
            String nupp = "";

            sisemineWhile:
            while(true){

                System.out.print("Sisesta soovitud käik: ");
                käik = sisend.nextInt();

                // käik lõhutakse ära ja lisatakse massiivi
                käik2[0] = käik / 100;
                käik2[1] = (käik - käik2[0] * 100);

                // prindib välja käigu (hiljem ümber tõlgitud koordinaatidega ilmselt)
                for (int c = 0; c < käik2.length; c++){
                    System.out.print(käik2[c]);
                    if (c == 0){System.out.print(" --> ");}else{System.out.println();}
                }

                //valib aktiivse nupu esimese numbri järgi
                akt2 = käik2[0] % 10;
                akt1 = (käik2[0] - akt2) / 10;
                aktiivneNupp = lauaseis[akt1-1][akt2-1];

                System.out.println("Tahad käia nupuga " + aktiivneNupp);


                //käiguKontroll

                värv = malendid.get(aktiivneNupp).värv;  //värvi ei saanud miskipärast otse käiguKontrolli meetodi seest kätte

                if (värv != kelleKord){
                    System.out.println("Proovi ikka oma nupuga");
                    continue;
                }


                System.out.println("Värv: " + värv);

                kuhu2 = käik2[1] % 10;
                kuhu1 = (käik2[1] - kuhu2) / 10;

                v6etavNupp = lauaseis[kuhu1-1][kuhu2-1];

                if (v6etavNupp != 0){                              //värv2 on siis sihtmärgi värv
                    värv2 = malendid.get(v6etavNupp).värv;
                }else{
                    värv2 = Math.abs(värv - 1);						//kui on tühi ruut siis on lihtsalt vastandvärv
                }
                //otsib välja mis tüüpi nupp on


                if (aktiivneNupp > 9 && aktiivneNupp < 26){
                    nupp = "etturKlass";

                }else if (aktiivneNupp == 3 || aktiivneNupp == 8 || aktiivneNupp == 27 || aktiivneNupp == 32) {
                    nupp = "ratsuKlass";

                }else if (aktiivneNupp  == 2 || aktiivneNupp == 9 || aktiivneNupp == 26 || aktiivneNupp == 33) {
                    nupp = "vankerKlass";
                }


                System.out.println(nupp);
                System.out.println(v6etavNupp);


                if (käiguKontroll(aktiivneNupp, käik2, malendid, värv, värv2, lauaseis[kuhu1-1][kuhu2-1], nupp, kuhu1, kuhu2, akt1, akt2, lauaseis) == 0){
                    System.out.println("Nii ei saa");  //läheb uuele ringile
                }else{
                    break sisemineWhile;  //murrab välja ja liigub edasi
                }



            }

            //käimine
            lauaseis[akt1-1][akt2-1] = 0;
            lauaseis[kuhu1-1][kuhu2-1] = aktiivneNupp;


            for(int rida3 = 0; rida3 < lauaseis.length; rida3++){
                for(int veerg3 = 0; veerg3 < lauaseis[rida3].length; veerg3++){
                    System.out.print(lauaseis[rida3][veerg3]+"\t");
                }
                System.out.println();
            }

            //kordamööda käimise jaoks

            if (kelleKord == 0){
                kelleKord = 1;

            }else{
                kelleKord = 0;
                turnCounter++;

            }

        }



    }

    public static class Malend{

        public int värv;
        public int number;

    }

    public static class Ettur extends Malend{

        //konstruktor
        public Ettur(int x){
            number = x;
            if (number > 9 && number < 18){
                värv = 0;
            }else if (number > 17 && number < 26){
                värv = 1;
            }
        }

    }

    public static class Ratsu extends Malend{

        //konstruktor
        public Ratsu(int x){
            number = x;
            if (number == 3 || number == 8){
                värv = 0;
            }else if (number == 27 || number == 32){
                värv = 1;
            }
        }

    }

    public static class Vanker extends Malend{

        //konstruktor
        public Vanker(int x){
            number = x;
            if (number == 2 || number == 9){
                värv = 0;
            }else if (number == 26 || number == 33){
                värv = 1;
            }
        }

    }


    // 0 - ei saa käia, 1 - tühi käik, 2 - võtmine
    public static int käiguKontroll(int aktiivneNupp, int[] käik2, HashMap malendid, int värv, int värv2, int kasTühiRuut, String nupp, int kuhu1, int kuhu2, int akt1, int akt2, int[][] lauaseis){
        //KÄIGUKONTROLL

        if (nupp == "etturKlass"){

            if (värv == 0){

                if ((käik2[0] - käik2[0] % 10)/10 == 2){   //ettur saab käia 2 sammu kui on algpositsioonil
                    if (käik2[1] - käik2[0] == 20){
                        return 1;
                    }
                }

                if (käik2[1] - käik2[0] == 10 && kasTühiRuut == 0){  //arvutab koordinaatide järgi kas käik on võimalik
                    return 1;
                }else if ((käik2[1] - käik2[0] == 9 && kasTühiRuut != 0)||(käik2[1] - käik2[0] == 11 && kasTühiRuut != 0)){
                    return 2;
                }else{
                    return 0;
                }

            }else{
                //ehk siis mustad
                if ((käik2[0] - käik2[0] % 10)/10 == 7){
                    if (käik2[0] - käik2[1] == 20){
                        return 1;
                    }
                }

                if (käik2[0]-käik2[1] == 10){
                    return 1;
                }else if ((käik2[0] - käik2[1] == 9 && kasTühiRuut != 0)||(käik2[0] - käik2[1] == 11 && kasTühiRuut != 0)){
                    return 2;
                }else{
                    return 0;
                }
            }

        }

        if (nupp == "ratsuKlass"){

            if ((Math.abs(käik2[1] - käik2[0]) == 8 || Math.abs(käik2[1] - käik2[0]) == 8 || Math.abs(käik2[1] - käik2[0]) == 19 || Math.abs(käik2[1] - käik2[0]) == 21) && ((värv == 0 && kasTühiRuut != 3 && kasTühiRuut != 8) || (värv == 1 && kasTühiRuut != 27 && kasTühiRuut != 32)) && värv != värv2){  //arvutab koordinaatide järgi kas käik on võimalik
				
                return 1;

            }else{
				
				
                return 0;
            }

        }
            /*- käib ainult horisontaalis ja vertikaalis
              - kedagi ei tohialguse ja lõpu vahel olla
              - samasse kohta ei tohi astuda
              - oma nuppe ei saa võtta (ja kuningat)
              */
        if (nupp == "vankerKlass"){
        	
            if (Math.abs(käik2[1] - käik2[0]) % 10 == 0){ 
            	
            	//vertikaalne liikumine
            	System.out.println(Math.abs(käik2[1] - käik2[0]) % 10);
            	if(akt1 > kuhu1){
            		
            		for (int i = akt1-1; i > kuhu1; i--){
            			System.out.println("Proovin: " + i);
            			if (lauaseis[i-1][kuhu2-1] != 0){
            				System.out.println("siin on nupp: " + lauaseis[i-1][kuhu2-1]);
            				return 0;
            			}
            		}
            		
            		if (värv != värv2){
            			return 1;
            		}
            		
            	}else if (akt1 < kuhu1){  // akt1<kuhu1
            		
            		for (int i = akt1; i < kuhu1; i++){   // see korda teha
            			System.out.println("Proovin: " + i);
            			if (lauaseis[i-1][kuhu2-1] != 0){
            				System.out.println("siin on nupp: " + lauaseis[i-1][kuhu2-1]);
            				return 0;
            			}
            		}
            	}
            	
            	
            }
                
        }
		System.out.println("VANKER JÕUDIS SIIA!!");
        return 0;

    }



}
