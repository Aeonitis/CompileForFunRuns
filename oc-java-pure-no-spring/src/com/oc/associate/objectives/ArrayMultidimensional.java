package com.oc.associate.objectives;

import java.util.Arrays;

/**
 * Notes:
 * - Explicitly specify/initialise the members w/o declaring the size is valid.
 * - Array size is never given during declaration of an array reference and should always be associated with the array instance, not the array reference.
 */
public class ArrayMultidimensional {

//    int arrayInvalid1DA[ ] = new int[2]{1,0};         // If elements are initialised explicitly you can't also set the size. So it should be just 'int[]{1,0}' or just '{1,0}'
//    int arrayInvalid1DB[4] = { 1,2,3,4 };             // You cannot specify the size on array reference (left-hand side). It should be set within array instance initialisation

    static int[] array1DA = new int[]{0, 1};
    static int[] array1DB = new int[4];
    static int[] array1DZ = {100, 101};

    static int[][] array2DA = {array1DA, array1DB, array1DZ};               // All above 1D arrays
    static int[][] array2DB = new int[][]{{6, 8, 2, 4}, {}, {10, 12}, new int[10], array1DA};
    static int[][] array2DC = new int[][]{{22}, {32}};
    static int[][] array2DZ = new int[][]{array1DB, {32, 45}};

    static int[][][] array3DA = {array2DA, array2DB, array2DC, array2DZ};   // All above 2D arrays
    static int[][][] array3DB = {array2DZ};
    static int[][][] array3DC = {{{3, 33}, {9, 21}, {15, 27}}, new int[3][3]};
    static int[][][] array3DZ = {
            {
                    {1, -2, 3},
                    {2, 3, 4}
            },
            {
                    {-4, -5, 6, 9},
                    {1},
                    {2, 3}
            }
    };

    public static void print2DArrays() {

        System.out.println("2D Arrays");
        System.out.println(Arrays.deepToString(array2DA));
        System.out.println(Arrays.deepToString(array2DB));
        System.out.println(Arrays.deepToString(array2DC));
        System.out.println(Arrays.deepToString(array2DZ));
    }

    public static void print3DArrays() {

        System.out.println("3D Arrays");
        System.out.println(Arrays.deepToString(array3DA));
        System.out.println(Arrays.deepToString(array3DB));
        System.out.println(Arrays.deepToString(array3DZ));
        System.out.println(Arrays.deepToString(array3DC));
    }

    public static void main(String[] args) {
        print2DArrays();
        print3DArrays();
    }
}

/**
 * Result:
 2D Arrays
 [[0, 1], [0, 0, 0, 0], [100, 101]]
 [[6, 8, 2, 4], [], [10, 12], [0, 0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 1]]
 [[22], [32]]
 [[0, 0, 0, 0], [32, 45]]
 3D Arrays
 [[[0, 1], [0, 0, 0, 0], [100, 101]], [[6, 8, 2, 4], [], [10, 12], [0, 0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 1]], [[22], [32]], [[0, 0, 0, 0], [32, 45]]]
 [[[0, 0, 0, 0], [32, 45]]]
 [[[1, -2, 3], [2, 3, 4]], [[-4, -5, 6, 9], [1], [2, 3]]]
 [[[3, 33], [9, 21], [15, 27]], [[0, 0, 0], [0, 0, 0], [0, 0, 0]]]
 */
