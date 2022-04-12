package com.company;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static Random rand = new Random();
    static int n;

    static int[][] niceCreate(boolean repeat) {
        System.out.println("Введіть розмір квадратної матриці: ");
        n = scan.nextInt();
        String output;
        int value = 0;
        int[][] mtrx = new int[n][n];
        String[][] niceMtrx = new String[n][n];
        boolean enterCheck;
        for (int i = 0; i < n; i++) {
            Arrays.fill(niceMtrx[i], "*");
        }
        System.out.println("Заповніть матрицю:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (repeat) {
                    enterCheck = true;
                    while (enterCheck) {
                        value = scan.nextInt();
                        if (!isEntered(mtrx, value))
                            enterCheck = false;
                    }
                } else {
                    value = scan.nextInt();
                }
                mtrx[i][j] = value;
                niceMtrx[i][j] = Integer.toString(value);
                for (int k = 0; k < n; k++) {
                    output = "";
                    for (int l = 0; l < n; l++) {
                        output += niceMtrx[k][l] + " ";
                    }
                    System.out.println(output);
                }
            }
        }
        return mtrx;
    }

    static int[][] createRandMass() {
        System.out.println("Введіть розмір квадратної матриці: ");
        n = scan.nextInt();
        int[][] mtrx = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j<n;j++){
                mtrx[i][j] = rand.nextInt(100 + 100) - 100;
            }
        }
        printMtrx(mtrx);
        return mtrx;
    }

    static void printMtrx(int[][] mtrx) {
        String output;
        for (int i = 0; i < n; i++) {
            output = "";
            for (int j = 0; j < n; j++) {
                output += mtrx[i][j] + " ";
            }
            System.out.println(output);
        }
    }

    static boolean isEntered(int[][] mtrx, int value) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mtrx[i][j] == value) {
                    System.out.println("Значення не можуть повторюватись. Введіть нове число: ");
                    return true;
                }
            }
        }
        return false;
    }

    static int findChangeNum(int[][] mtrx) {
        int sum = 0;
        int j = n - 1;
        for (int i = 0; i < n; i++) {
            sum += mtrx[i][j];
            j--;
        }
        return sum;
    }

    static void findNChange(int[][] mtrx) {
        int max = mtrx[0][0];
        int changeNum = findChangeNum(mtrx);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (max < mtrx[i][j]) {
                    max = mtrx[i][j];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mtrx[i][j] == max) {
                    for (int k = 0; k < n; k++) {
                        mtrx[i][k] = changeNum;
                    }
                }
            }
        }
    }

    static int findMaxR(int[][] mtrx) {
        int max = mtrx[0][0];
        int maxInR = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (max < mtrx[i][j]) {
                    max = mtrx[i][j];
                    maxInR = i;
                }
            }
        }
        return maxInR;
    }

    static int findMinS(int[][] mtrx) {
        int min = mtrx[0][0];
        int minInS = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (min > mtrx[i][j]) {
                    min = mtrx[i][j];
                    minInS = j;
                }
            }
        }
        return minInS;
    }

    static void findSсalarDob(int[][] mtrx) {
        int maxInR = findMaxR(mtrx);
        int minInS = findMinS(mtrx);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += mtrx[maxInR][i] * mtrx[i][minInS];
        }
        System.out.println("Скалярний добуток максимального рядка(" + (maxInR+1) + ") на мінімальний стовпчик(" + (minInS+1) + ") = " + sum);
    }

    public static void main(String[] args) {
        System.out.println("Оберіть завдання, натисніть цифру: \n1 - Редагувати квадратну матрицю; \n2 - Знайти скалярний добуток;");
        int ask = scan.nextInt();
        switch (ask) {
            case 1 -> {
                int[][] mtrx = niceCreate(false);
                findNChange(mtrx);
                System.out.println("\n");
                System.out.println("Змінений масив: ");
                printMtrx(mtrx);
            }
            case 2 -> {
                System.out.println("Який спосіб вводу оберете? \n1 - Ввід з клавіатури; \n2 - Рандомний ввід на проміжку [-100;100];");
                ask = scan.nextInt();
                int[][] secondMtrx;
                switch (ask) {
                    case 1 -> {
                        secondMtrx = niceCreate(true);
                        System.out.println("\n");
                        printMtrx(secondMtrx);
                        findSсalarDob(secondMtrx);
                    }
                    case 2 -> {
                        secondMtrx = createRandMass();
                        findSсalarDob(secondMtrx);
                    }
                    default -> System.out.println("Невірне число.");
                }
            }
            default -> System.out.println("Невірне число.");
        }
    }
}
