import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {

        List<String> letter = new ArrayList<String>();
        Map<Character, Integer> alphaMap = new HashMap<>();
        alphaMap = populateAlphaMap(alphaMap);

        Scanner in = new Scanner(System.in);
        int width = in.nextInt();
        int Height = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        String T = in.nextLine();
        T = T.toUpperCase();

        for (int i = 0; i < Height; i++) {
            String ROW = in.nextLine();
            letter.add(ROW);
        }
        painting(T, letter, alphaMap, Height, width);
    }


    public static Map<Character, Integer> populateAlphaMap(Map<Character, Integer> alphaMap) {
        char c = 'A';

        for (int i = 0; c <= 'Z'; i++, c++) {
            alphaMap.put(c, i);
        }
        alphaMap.put('?', 26);
        return alphaMap;
    }

        public static void painting(String text,  List<String> letter, Map<Character, Integer> alphaMap, int Height, int width) {
          /*
            *   tmp display each line create woth function creatArt()
            *   start is the index where the letter begins
            *   end is the index where the letter ends
            *   start & end are calculate with the value of alphaMap(letter, indexInAlphabet) and the width of the letter (here it's L)
           */ 
           
            String tmp = "";
            int start, end;

            for (int height = 0; height < Height; height++) {
                for (int i = 0; i < text.length(); i++) {
            if (alphaMap.get(text.charAt(i)) == null) {
               start = alphaMap.get('?') * width;
            }
            else {
             start = alphaMap.get(text.charAt(i)) * width;
            }
            end = start + width;
            tmp += createArt(letter, start, end, height);
                    
                }
                System.out.println(tmp);
                tmp = "";
            }
        }


        /*
          *   createArt parses the List<String>.
          *   height = line we want to print
         */
         
        public static String createArt( List<String> letter, int start, int end, int height) {
            String tmp = "";

            for (int i = start; i < end; i++) {
                tmp += letter.get(height).charAt(i);
            }
            return tmp;
        }
}

