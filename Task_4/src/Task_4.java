import javax.sound.sampled.Line;
import java.util.*;

public class Task_4 {
    public static String sevenBoom (int mas[]) {
        for (int i = 0; i < mas.length; i++) {
            int num = mas[i];
            while (num>0){
                if (num%10 == 7)
                   return "BOOM!";
                num = num/10;
            }

        }
        return "в массиве нет 7";
    }

    public static boolean cons (int mas[]){
        Arrays.sort(mas);
        for (int i = 1; i < mas.length; i++){
            if (mas[i] - mas[i-1] != 1){
                return false;
            }
        }
        return true;
    }

    public static String unmix(String str){
        String str1 = "";
        for (int i = 0; i < str.length()-1; i+=2){
            str1 += str.charAt(i+1) + "" + str.charAt(i);
        }
        if (str.length()%2 == 1)
            str1 += str.charAt(str.length()-1);
        return str1;
    }

    public static String noYelling(String str){
        String str1 = "";
        boolean flag = !(str.charAt(str.length()-1) > 32 && str.charAt(str.length()-1) < 64);
        for (int i = str.length()-1; i>-1; i--){
            if (i!=0 && str.charAt(i)>32 && str.charAt(i)<64 && str.charAt(i-1)>64){
                flag = true;
            }
            if (flag){
                str1 = str.charAt(i) +str1;
            }
        }
        return str1;
    }

    public static String xProunce (String str){
        String str1 = "";
        if (str.charAt(0) == 'x' || str.charAt(0) == 'X'){
            if (checkLetter(str.charAt(1))){
               str1 = "z";
            }
            else
                str1 = "Ecks
        } else
            str1 += str.charAt(0);

        for (int i = 1; i< str.length()-1; i++){
            if(str.charAt(i) == 'x'){
                if(str.charAt(i-1) == ' ' && checkLetter(str.charAt(i+1)) ){
                    str1 += "z";
                }
                else if (str.charAt(i-1) == ' ' && str.charAt(i+1) == ' ')
                    str1 += "ekcs";
                else
                    str1 += "cks";
            } else
                str1 += str.charAt(i);


        }

        int d = str.length()-1;
        if (str.charAt(d) == 'x' || str.charAt(d) == 'X'){
            if (checkLetter(str.charAt(d-1))){
                str1 += "cks";
            }
            else
                str1 += "ecks";
        }
        else
            str1 += str.charAt(d);

        return str1;
    }

    public static boolean checkLetter(char letter){
        return ((64 < letter && letter<91) || (96<letter && letter<123));
    }

   public static String largestGap (int mas[]){
       Arrays.sort(mas);
       int max = -1;
       int number1 = 0;
       int number2 =0;
       for (int i = 1; i<mas.length; i++){
            if (mas[i]-mas[i-1] > max){
                max = mas[i]-mas[i-1];
                number1 = mas[i];
                number2 = mas[i-1];
            }
       }

       return "Largest gap between " + number1 +  " and " + number2 + " is " + max;
   }

    public static int revers(int number){
        int mas[] =new int[(number+"").length()]; //прибавили пустую строку, чтобы int стал String
        int i = 0;
        int number0 = number;
        while (number > 0){
            mas[i] = number % 10;
            i++;
            number /= 10;
        }
        Arrays.sort(mas);
        int number2 = 0;
        for (i = 0; i< mas.length; i++){
            number2 = number2 * 10 + mas[i];
        }

        return number0 - number2;

    }

    public static String commonLastVowel (String str){
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('a', 0);
        map.put('e', 0);
        map.put('y', 0);
        map.put('u', 0);
        map.put('i', 0);
        map.put('o', 0);
        for (int i = 0; i < str.length()-1;i++ ){
            char letter = str.charAt(i);
            if (map.keySet().contains(letter) && str.charAt(i+1) == ' ')
                map.put(letter, map.get(letter) + 1);
        }
        char letter = str.charAt(str.length()-1);
        if (map.keySet().contains(letter))
            map.put(letter, map.get(letter) + 1);

        int maxVal = -1;
        char maxLetter =  ' ';
        for (char key : map.keySet()) { // проходимся по всем значения
            if (maxVal < map.get(key)) { //находим максимум
                maxVal = map.get(key);
                maxLetter = key;
            }
        }

        return maxLetter + "";
    }


    public static String memeSumm(int number1, int number2){
        String str = "";
        while (number1 > 0 || number2>0){
            int n = number1 % 10 + number2 % 10;
            str = n + str;
            number1 /= 10;
            number2 /= 10;
        }
        return str;
    }

    public static String unrepeated(String line){
        LinkedList<Character> list = new LinkedList<>();
        String res = "";
        for (int i = 0; i < line.length(); i++){
            char letter = line.charAt(i);
            if (!list.contains(letter)){
                list.add(letter);
                res += letter;
            }
        }

        return res;
    }



    public static void main(String[] args){
        System.out.println(sevenBoom(new int[] {8, 4, 97, 10}));
        System.out.println(cons(new int []{ 1, 3, 2}));
        System.out.println(unmix("hTsii  s aimex dpus rtni.g"));
        System.out.println(noYelling("I just!!! can!!! not!!! believe!!! it!!!Kek"));
        System.out.println(xProunce("OMG x box unboxing video x D"));
        System.out.println(largestGap(new int [] {9, 4, 26, 26, 0, 0, 5, 20, 6, 25, 5}));
        System.out.println(revers(1));
        System.out.println(commonLastVowel("Holle World!" ));
        System.out.println(memeSumm(26, 39));
        System.out.println(unrepeated("Hellllo"));

    }
}
