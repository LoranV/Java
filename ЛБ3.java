package com.company;

import java.util.Scanner;
import java.util.Random;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static Random rand = new Random();
    static int size;

    static int[] createMass() {
        System.out.println("Введіть розмір масиву: ");
        size = scan.nextInt();
        int[] mass = new int[size];
        System.out.println("Введіть елементи масиву: ");
        for (int i = 0; i < size; i++) {
            mass[i] = scan.nextInt();
        }
        return mass;
    }

    static int[] createRandMass(int min, int max) {
        System.out.println("Введіть розмір масиву: ");
        size = scan.nextInt();
        int[] mass = new int[size];
        for (int i = 0; i < size; i++) {
            mass[i] = rand.nextInt(max - min) + min;
        }
        return mass;
    }

    static void printMass(int[] mass) {
        for (int i = 0; i < mass.length; i++) {
            System.out.println(mass[i]);
        }
    }

    static boolean isMinus(int[] mass) {
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] < 0) {
                return true;
            }
        }
        return false;
    }

    static void minusDob(int[] mass) {
        double dob = 1;
        if (isMinus(mass)) {
            for (int i = 0; i < mass.length; i++) {
                if (mass[i] < 0) {
                    dob *= mass[i];
                }
            }
            System.out.println("Добуток від'ємних чисел: " + dob + ";");
        } else {
            System.out.println("Добуток від'ємних чисел: 0;");
        }
    }

    static int findMin(int[] mass) {
        int ind = 0, min = mass[0];
        for (int i = 0; i < mass.length; i++) {
            if (min > mass[i]) {
                min = mass[i];
                ind = i;
            }
        }
        return ind;
    }

    static void minSum(int[] mass) {
        int sum = 0;
        for (int i = findMin(mass) + 1; i < mass.length; i++) {
            sum += mass[i];
        }
        System.out.println("Сума чисел після мінімального числа: " + sum + ";");
    }

    public static void main(String[] args) {
        System.out.println("Оберіть завдання, натисніть цифру: \n1 - Сума непарних елементів; \n2 - Добуток та Сума елементів в масиві;");
        int ask = scan.nextInt();
        switch (ask) {
            case 1:
                int[] mass = createMass();
                System.out.println("Введіть m: ");
                int m = scan.nextInt(), count = 0, sum = 0;
                for (int i = 0; i < size; i++) {
                    if (mass[i] > m && mass[i] % 2 != 0) {
                        count++;
                        sum += mass[i];
                    }
                }
                System.out.println("Сума непарних елементів більше " + m + " = " + sum + "; Кількість елементів: " + count + ";");
                break;
            case 2:
                System.out.println("Який спосіб вводу оберете? \n1 - Ввід з клавіатури; \n2 - Рандомний ввід на проміжку [-100;100];");
                ask = scan.nextInt();
                switch (ask) {
                    case 1:
                        mass = createMass();
                        minusDob(mass);
                        minSum(mass);
                        break;
                    case 2:
                        mass = createRandMass(-100, 100);
                        minusDob(mass);
                        minSum(mass);
                        printMass(mass);
                        break;
                    default:
                        System.out.println("Невірне число.");
                        break;
                }
                break;
            default:
                System.out.println("Невірне число.");
                break;
        }
    }
}
