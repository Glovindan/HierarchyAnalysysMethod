package com.company;

import java.util.Scanner;

public class Main {
    public static final int N = 7;

    //Вставить свои векторы приотритетов из таблицы второго уровня
    public static final double wLvl2[] = {0.177, 0.109, 0.057, 0.036, 0.038, 0.194, 0.47};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double wLvl3[] = new double[N];
        for (int i = 0; i < N; i++) {
            System.out.println("Input wLvl3[" + i + "] :");
            wLvl3[i] = scanner.nextDouble();
        }
        double globalPriority = 0.0;
        for (int i = 0; i < N; i++) {
            globalPriority += wLvl2[i] * wLvl3[i];
        }
        System.out.println("Global priority = " + globalPriority);
    }
}
