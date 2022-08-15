package com.company;
import java.util.Scanner;

enum RomanNumeral {
    I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8), IX(9),
    X(10), XX(20), XXX(30), XL(40), L(50), LX(60), LXX(70), LXXX(80), XC(90),
    C(100);

    int ae;

    RomanNumeral(int i) {
        ae = i;
    }

    int getAe() {
        return ae;
    }

}


class Representation {
    int c=0, d=0;
    String[] Roma = {"I" , "II" , "III" , "IV", "V", "VI" , "VII" , "VIII" , "IX" , "X" };

    Representation(String value1, String value2){
        String val1=value1;
        String val2=value2;


        for (int i = 0; i < Roma.length; i++) {
            if (Roma[i].equals(val1)) c = i + 1;
        }


        for (int i = 0; i < Roma.length; i++) {
            if (Roma[i].equals(val2)) d = i + 1;
        }

    }

    int get_c(){
        return c;
    }

    int get_d(){
        return d;
    }


}


public class Main {


    public static void main(String[] args) throws Exception {

        int a = 0, b = 0, result = 0, smb = 0;
        String prom_res = new String();

        System.out.println("Please enter expression");
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();


        if(str.length()<3)
            throw new Exception();

        for (int i = 1; i <= str.length() - 1; i++) {
            if ((str.charAt(i) == '+') ||
                    (str.charAt(i) == '-') ||
                    (str.charAt(i) == '*') ||
                    (str.charAt(i) == '/')) {
                smb = i;
            }

        }
        if (smb==0)
            throw new Exception();


        String value1 = str.substring(0, smb);
        String value2 = str.substring(smb + 1, str.length());

        try{
            a = Integer.parseInt(value1);
            b = Integer.parseInt(value2);
            if(a>10 | a< 0 | b>10 | b<0){
                throw new Exception();}

            switch (str.charAt(smb)) {
                case '+':
                    result = a + b;
                    break;
                case '-':
                    result = a - b;
                    break;
                case '*':
                    result = a * b;
                    break;
                case '/':
                    result = a / b;
                    break;
            }

            prom_res= Integer.toString(result);
            System.out.println(calc(prom_res));



        } catch (NumberFormatException exc) {
            Representation representation = new Representation(value1, value2);
            a = representation.get_c();
            b = representation.get_d();
            if (a == 0 || b == 0) {
                throw new Exception();
            }


            switch (str.charAt(smb)) {
                case '+':
                    result = a + b;
                    break;
                case '-':
                    result = a - b;
                    if (result<1) {
                        throw new Exception();
                    }
                    break;
                case '*':
                    result = a * b;
                    break;
                case '/':
                    result = a / b;
                    break;
            }

            String res_s = Integer.toString(result);
            String str2 = new String();
            int x =  Character.getNumericValue(res_s.charAt(res_s.length()-1));

            for (RomanNumeral rn : RomanNumeral.values()) {

                if (result == rn.getAe())
                    System.out.println(rn);

                else{
                    if(result-x == rn.getAe()){
                        str2=rn.name()+str2;
                    }
                    else if(x== rn.getAe())
                        str2+=rn.name();
                }


            }
            System.out.println(calc(str2));


        }


    }

    public static String calc(String input){

        return input;
    }
}




