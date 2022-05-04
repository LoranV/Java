package com.company;

import java.util.*;
import java.io.*;

public class Main {
    static Scanner scan = new Scanner(System.in);

    static boolean checkString(String sntnc) {
        if (sntnc.length() == 0) {
            return false;
        } else {
            return true;
        }
    }

    static boolean checkWord(String sntnc){
        String[] massWord;
        massWord = sntnc.split(" ");
        try{
            if (massWord[0]==""){
                throw new Exception();
            }else if(massWord.length>1){
                throw new Exception();
            }else{
                return true;
            }
        }catch (Exception e){
            if (massWord[0]==""){
                System.out.println("Ви не ввели слово.");
                return false;
            }else if(massWord.length>1){
                System.out.println("Ви ввели більше одного слова.");
                return false;
            }
        }
        return false;
    }


    static char[] reverseString(String str) {
        char[] mass = str.toCharArray();
        char[] reversMass = new char[mass.length];
        int j = 0;
        for (int i = mass.length - 1; i >= 0; i--) {
            reversMass[j] = mass[i];
            j++;
        }
        System.out.println(reversMass);
        return reversMass;
    }

    static void containNum(char[] mass) {
        int count = 0;
        for (int i = 0; i < mass.length; i++) {
            if (Character.isDigit(mass[i])) {
                while (i != mass.length - 1 && Character.isDigit(mass[i]) && Character.isDigit(mass[i + 1])) {
                    i++;
                }
                count++;
            }
        }
        System.out.println("Цей рядок містить " + count + " цифр.");
    }

    static String[][] createMassString() throws FileNotFoundException {
        FileReader read = new FileReader("file.txt");
        Scanner fileRead = new Scanner(read);
        int i = 1;
        String[][] mass = new String[i][];
        String string = fileRead.nextLine();
        mass[i-1] = string.split(" ");
        while (fileRead.hasNextLine()) {
            mass = Arrays.copyOf(mass,mass.length+1);
            string = fileRead.nextLine();
            mass[i] = string.split(" ");
            i++;
        }
        return mass;
    }

    static void findWordString(String word) throws FileNotFoundException {
        String[][] mass = createMassString();
        String temp;
        boolean isTrue = false;
        for (int i = 0; i<mass.length; i++){
            for (int j = 0; j<mass[i].length; j++){
                if (mass[i][j].equals(word)){
                    temp="";
                    isTrue = true;
                    for (int k = 0; k<mass[i].length; k++){
                        temp+=mass[i][k]+" ";
                    }
                    System.out.println(temp);
                }
            }
        }
        if (!isTrue){
            System.out.println("Рядків з даним словом нема.");
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        while(true){
            System.out.println("\nОберіть завдання, натисніть цифру: \n1 - а) Інвертує рядок, подаючи його у зворотному вигляді; б) Підраховує кількість чисел у тексті;" +
                    " \n2 - Читає речення з файла і виводить на екран список речень, що містять задане слово;");
            int ask = scan.nextInt();
            switch (ask) {
                case 1:
                    scan.nextLine(); // Twenty seven, 27, 727 2727 72727 272727272
                    System.out.println("Введіть речення:");
                    String sntnc = scan.nextLine();
                    if (checkString(sntnc)) {
                        char[] reverseSntnc = reverseString(sntnc);
                        containNum(reverseSntnc);
                    } else {
                        System.out.println("Не введенний рядок!");
                    }
                    break;
                case 2:
                    scan.nextLine();
                    System.out.println("Введіть слово:");
                    String word = scan.nextLine();
                    if (checkWord(word)){
                        findWordString(word);
                    }
                    break;
                default:
                    System.out.println("Невірне число.");
                    break;
            }
        }
    }
}
