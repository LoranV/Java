package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Оберіть завдання, натисніть цифру: \n1 - Формула з циклом; \n2 - Типи циклів; \n3 - Добуток суми ряду; \n4 - Значення у діапазоні;");
        int ask = scan.nextInt();
        switch (ask) {
            case 1:
                boolean error = true;
                int a, b;
                while (error) {
                    System.out.println("Введіть 2 додатніх числа, з умовою, що a>=b*b: ");
                    a = scan.nextInt();
                    b = scan.nextInt();
                    if (a >= b * b) {
                        error = false;
                        double x = Math.sqrt(a - b * b) + Math.sqrt(a * b);
                        System.out.println("x = " + x);
                    } else {
                        System.out.println("Помилка вводу. Повторіть спробу.");
                    }
                }
                break;
            case 2:
                System.out.println("Оберіть спосіб:\n1 - З використанням циклу з параметром;\n2 - З використанням циклу з передумовою;\n3 - З використанням циклу з післяумовою;");
                ask = scan.nextInt();
                int sum = 0;
                int i = 10;
                switch (ask) {
                    case 1 -> {
                        for (; i <= 100; i++) {
                            if (i % 3 == 0) {
                                sum += i;
                            }
                        }
                        System.out.println(sum);
                    }
                    case 2 -> {
                        while (i <= 100) {
                            if (i % 3 == 0) {
                                sum += i;
                            }
                            i++;
                        }
                        System.out.println(sum);
                    }
                    case 3 -> {
                        do {
                            if (i % 3 == 0) {
                                sum += i;
                            }
                            i++;
                        } while (i <= 100);
                        System.out.println(sum);
                    }
                    default -> System.out.println("Невірне число.");
                }
                break;
            case 3:
                int resx, resy = 0;
                System.out.println("Введіть 2 додатніх числа x та n: ");
                try{
                    int x = scan.nextInt();
                    int n = scan.nextInt();
                    if (x > 0 && n > 0) {
                        for (int ii = 1; ii <= n; ii++) {
                            resx = 1;
                            for (int jj = 1; jj <= ii; jj++) {
                                resx *= ii * x;
                            }
                            resy += resx;
                        }
                    }else{
                        throw new Exception();
                    }
                    System.out.println("Сума добутку формули: " + resy);
                }catch (Exception err){
                    System.out.println("Невірне число.");
                }
                break;
            case 4:
                a = 0;
                b = 6;
                float xx;
                Exception ERROR = new Exception();
                for (xx = a; xx <= b; xx += 0.5) {
                    try{
                        if ((float)(1 / (1 - Math.sqrt(xx))) != Double.POSITIVE_INFINITY)
                            System.out.println("x = " + xx + "\t\t\ty = " + (float)(1 / (1 - Math.sqrt(xx))));
                        else
                            throw ERROR;
                    }catch(Exception er)
                    {
                        System.out.println("x = " + xx + "\t\t\ty = Помилка значень.");
                    }
                }
                break;
            default:
                System.out.println("Невірне число.");
                break;
        }
    }
}
