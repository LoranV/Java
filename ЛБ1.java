package com.company;
import java.util.Scanner;

public class Main {
    public static double Distance(int x, int y, int x2, int y2){
        return Math.sqrt(Math.pow(x2-x,2)+Math.pow(y2-y,2));
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Оберіть завдання, натисніть цифру: \n1 - Форми; \n2 - Точки; \n3 - Веселка; \n4 - Рівняння;");
        int ask = scan.nextInt();
        switch (ask) {
            case 1:
                System.out.println("Оберіть спосіб:\n1 - З використанням скороченої форми;\n2 - З використанням повної форми");
                ask = scan.nextInt();
                try {
                    System.out.println("Введіть два числа s та t: ");
                    float s = scan.nextFloat(), t = scan.nextFloat();
                    switch(ask){
                        case 1:
                            if (s == -7)
                                System.out.println("f(x) = " + (s/t+2*s*t));
                            if (s == 7)
                                System.out.println("f(x) = " + (Math.sqrt(s/t+2*s*t)));
                            if (s == 14)
                                System.out.println("f(x) = " + (Math.pow(s,2)+2*t));
                            break;
                        case 2:
                            if (s == -7)
                                System.out.println("f(x) = " + (s/t+2*s*t));
                            else if(s == 7)
                                System.out.println("f(x) = " + (Math.sqrt(s/t+2*s*t)));
                            else if(s == 14)
                                System.out.println("f(x) = " + (Math.pow(s,2)+2*t));
                            else
                                System.out.println("No solution");
                            break;
                    }
                }catch(Exception ex){
                    System.out.println("Помилка");
                }
                break;
            case 2:
                System.out.println("Введіть точку A(x,y)");
                int x1=scan.nextInt(),y1=scan.nextInt();
                System.out.println("Введіть точку B(x,y)");
                int x2=scan.nextInt(),y2=scan.nextInt();
                System.out.println("Введіть точку C(x,y)");
                int x3=scan.nextInt(),y3=scan.nextInt();

                if (Distance(x1,y1,x2,y2)<Distance(x1,y1,x3,y3))
                    System.out.println("Найблища точка - В("+x2+","+y2+")\tДистанція: "+Distance(x1,y1,x2,y2));
                else
                    System.out.println("Найблища точка - С(\"+x2+\",\"+y2+\")\\tДистанція: "+Distance(x1,y1,x3,y3));
                break;
            case 3:
                System.out.println("Введіть цифру(1-7), щоб дізнатись колір радуги");
                int color = scan.nextInt();
                switch (color){
                    case 1:
                        System.out.println("Червоний");
                        break;
                    case 2:
                        System.out.println("помаранчевий");
                        break;
                    case 3:
                        System.out.println("Жовтий");
                        break;
                    case 4:
                        System.out.println("Зелений");
                        break;
                    case 5:
                        System.out.println("Блакитний");
                        break;
                    case 6:
                        System.out.println("Синій");
                        break;
                    case 7:
                        System.out.println("Фіолетовий");
                        break;
                    default:
                        System.out.println("Невірне число.");
                        break;
                }
                break;
            case 4:
                try {
                    System.out.println("Введіть 3 додатніх числа x, y та z:");
                    float x = scan.nextFloat(), y = scan.nextFloat(), z = scan.nextFloat();
                    if(x<=0||y<=0||z<=0){
                        Exception error = new Exception();
                        throw error;
                    }
                    float res = (float) ((1 + z) * ((x + (y / z)) / (x - (1 / (1 + Math.pow(x, 2))))));
                    System.out.println("t = " + res);
                    break;
                }
                catch(Exception ex){
                    System.out.println("Помилка. Введено невірні числа");
                }
                break;
            default:
                System.out.println("Невірне число.");
                break;
        }
    }
}
