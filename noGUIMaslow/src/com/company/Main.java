package com.company;

import java.util.Scanner;

public class Main {
    public static final int N = 3;
    public static final int M = 3;
    public static final double SS = 0.58;//Случайные соотношения, зависит от количества векторов

    public static double root( double n, double i ) {//Корень из числа n степени i
        return Math.pow( n, 1.0 / i );
    }

    public static double[] priorityVectors(double[][] arr) {//Векторы проритетов
        double[] w = new double[arr.length];
        double s = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                w[i] += arr[i][j];
            }
            w[i] = root(w[i],arr[i].length);
            s+=w[i];
        }
        for(int i = 0; i < arr.length; i++) {
            w[i] = w[i] / s;
        }
        return w;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double arr[][] = new double[N][M];

        //Ввести данные из матрицы 3 на 3 (дроби обязательно через плавающую точку, например: 1.0/2.0; 1d/2)
        arr[0][0] = 1;      arr[0][1] = 8;      arr[0][2] = 6;
        arr[1][0] = 1d/8;   arr[1][1] = 1;      arr[1][2] = 1d/4;
        arr[2][0] = 1d/6;   arr[2][1] = 4;      arr[2][2] = 1;

        //(Можете модифицировать чтобы высчитывал для матриц больше или добавить ввод через консоль или не забивайте мозги)
//	    for(int i = 0; i < N; i++) {
//	        for(int j = 0; j < M; j++) {
//	            System.out.println("Input arr["+ i + "," + j +"];");
//	            arr[i][j] = scanner.nextDouble();
//            }
//        }
	    double[] w = priorityVectors(arr);
        double[] s = new double[M];
        for (int j = 0; j < M; j++) {
            for(int i = 0; i < N; i++) {
                s[j] += arr[i][j];
            }
            System.out.println("S["+ j + "] = " + s[j]);
        }

        double lambda = 0;
        for(int i = 0; i < N; i++) {
            lambda += s[i] * w[i];
        }

        double IS = (lambda - N)/(N - 1);
        double OS = IS/SS;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.print(":" + w[i] + "\n");
        }
        System.out.println("Lambda = "+ lambda);
        System.out.println("IS = "+ IS);
        System.out.println("OS = "+ OS);
    }
}
