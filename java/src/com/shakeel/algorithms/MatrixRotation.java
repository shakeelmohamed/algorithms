package com.shakeel.algorithms;

import java.util.Arrays;

public class MatrixRotation {
    public static void CCWrotate(int[][] m) {
        int n = m.length;
        for(int i = 0; i < n/2; i++) {
            int start = i;
            int end = n - i - 1;
            for(int j = i; j < end; j++) {
                int offset = j - i;
                // 4 way swap, counter-clockwise
                int temp = m[j][start];
                m[j][start] = m[start][end - offset];
                m[start][end - offset] = m[end - offset][end];
                m[end - offset][end] = m[end][j];
                m[end][j] = temp;
            }
        }
    }

    public static void CWrotate(int[][] m) {
        int n = m.length;
        for(int i = 0; i < n/2; i++) {
            int start = i;
            int end = n - i - 1;
            for(int j = i; j < end; j++) {
                int offset = j - i;
                // 4 way swap, clockwise
                int temp = m[start][j];
                m[start][j] = m[end - offset][start];
                m[end - offset][start] = m[end][end - offset];
                m[end][end - offset] = m[j][end];
                m[j][end] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[1][0] = 4;
        matrix[1][1] = 5;
        matrix[1][2] = 6;
        matrix[2][0] = 7;
        matrix[2][1] = 8;
        matrix[2][2] = 9;
        System.out.println(Arrays.toString(matrix[0]));
        System.out.println(Arrays.toString(matrix[1]));
        System.out.println(Arrays.toString(matrix[2]));
        System.out.println();
        CCWrotate(matrix);
        System.out.println(Arrays.toString(matrix[0]));
        System.out.println(Arrays.toString(matrix[1]));
        System.out.println(Arrays.toString(matrix[2]));
        System.out.println();
        CWrotate(matrix);
        System.out.println(Arrays.toString(matrix[0]));
        System.out.println(Arrays.toString(matrix[1]));
        System.out.println(Arrays.toString(matrix[2]));
    }
}
