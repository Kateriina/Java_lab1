package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean stop = false;

        while (!stop) {

            System.out.println("Введите номер задания от 1 до 6.");
            System.out.print("Если хотите закончить, нажмите иное: ");
            int taskNumber = sc.nextInt();

            switch (taskNumber) {
                case 1:
                    task1(sc);
                    break;
                case 2:
                    task2(sc);
                    break;
                case 3: task3(sc);
                    break;
                case 4: task4(sc);
                    break;

                case 5: task5(sc);
                    break;

                case 6: task6(sc);
                    break;

                default: stop = true;
            }
        }
    }


    public static void task1(Scanner sc){

        double x = inputDouble("x", sc, true, false, false);
        double y = inputDouble("y", sc, false, false, false);

        double S = 9.756 * Math.pow(y, 7) + 2 * Math.tan(x);

        System.out.printf("Результат: S = %.2f\n\n", S);
    }

    private static void task2(Scanner sc) {
        double y = inputDouble("y", sc, false, true, false);
        double n = inputDouble("n", sc, false, false, false);

        double D = Math.pow(y,2) + ((0.5 * n + 4.8) / (Math.sin(y)));

        System.out.printf("Результат: D = %.2f\n\n", D);
    }

    private static void task3(Scanner sc) {

        double x = inputDouble("x", sc, false, false, false);
        double y = inputDouble("y", sc, false, false, false);


        double I = (2.33 * Math.log(Math.sqrt((1+Math.pow(Math.cos(y),2))))) / (Math.pow(Math.E, y) + Math.pow(Math.sin(x),2));
        System.out.printf("Результат: I = %.2f\n\n", I);
    }


    private static void task4(Scanner sc) {

        double R = inputDouble("R", sc, false, false, true);

        double C = 2 * Math.PI * R;
        double S = Math.PI * Math.pow(R, 2);

        System.out.println("Результаты: ");
        System.out.printf("Длина окружности C = %.2f\n", C);
        System.out.printf("Площадь круга S = %.2f\n\n", S);
    }


    private static void task5(Scanner sc) {

        double b = 7;

        double x = inputDouble("x", sc, false, false, true);

        double a = Math.pow(b + x, 3);
        double c = Math.log10(Math.abs(b));
        double y = Math.pow(c, 2) + Math.sqrt(Math.abs(a));

        System.out.println("Результаты: ");
        System.out.printf("y = %.2f\n", y);
        System.out.printf("c = %.2f\n", c);
        System.out.printf("a = %.2f\n\n", a);

    }

    private static void task6(Scanner sc) {
        double t = inputInt("T", sc, true);

        double S = Math.pow(t,3) - Math.sqrt(t);
        double V = 3 * Math.pow(t, 2) - 1 / (2 * Math.sqrt(t));

        System.out.println("Результаты: ");
        System.out.printf("S = %.2f\n", S);
        System.out.printf("V = %.2f\n\n", V);

    }

    private static double inputDouble(String label, Scanner sc, boolean needTangentCheck, boolean needSin0, boolean needPos) {
        double x;

        while (true) {

            System.out.printf("Введите %s = ", label);

            if (!checkDouble(sc)) continue;

            x = sc.nextDouble();

            if (!checkRange(x)) continue;

            if (needTangentCheck && !checkTangent(x)) continue;

            if (needSin0 && !checkSin0(x)) continue;

            if (needPos && !сheckPositiveDouble(x)) continue;

            break;
        }

        return x;
    }

    private static double inputInt(String label, Scanner sc, boolean needPosInt) {
        int x;
        while (true) {

            System.out.printf("Введите %s = ", label);
            if (!checkInt(sc)) continue;
            x = sc.nextInt();
            if (needPosInt && !сheckPositiveInt(x)) continue;
            break;
        }

        return x;
    }


    private static boolean сheckPositiveDouble(double x) {
        return validate( x >= 0, "Введите положительное число!");
    }

    private static boolean сheckPositiveInt(int x) {
        return validate( x >= 0, "Введите положительное число!");
    }

    public static boolean checkDouble(Scanner sc) {
        if (!sc.hasNextDouble()) {
            sc.next();
            validate(false, "Введите число!");
            return false;
        }

        return true;
    }

    private static boolean checkInt(Scanner sc) {

        if (!sc.hasNextInt()){

            sc.next();

            validate(false, "Введите число!");
            return false;
        }

        return true;
    }

    private static boolean checkRange(double x) {
        return validate(x > -1.7e308 && x < 1.7e308, "Вне диапазона double!");
    }

    private static boolean checkTangent(double x) {
        double k = (x - Math.PI / 2) / Math.PI;

        return validate(Math.abs(k - Math.round(k)) > 10.0e-10,
                "Введите число, отличное от pi/2 + pi*k!");
    }

    private static boolean checkSin0(double x) {
        double k = x / Math.PI;

        return validate(Math.abs(k - Math.round(k)) > 10.0e-10,
                "Введите число, отличное от pi*k!");
    }

    private static boolean validate(boolean b, String message) {
        if (!b) System.out.println(message);

        return b;
    }
}
