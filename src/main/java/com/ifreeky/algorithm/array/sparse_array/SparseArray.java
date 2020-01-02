package com.ifreeky.algorithm.array.sparse_array;

/**
 * 稀疏数组
 *
 * @author ifreeky
 * @since 15 July 2019
 */
public class SparseArray {

    public static void main(String[] args) {
        SparseArray obj = new SparseArray();
        int[][] twoArray = {
                {1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 2, 0},
                {0, 0, 6, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };
        System.out.println("二维数组");
        obj.printArray(twoArray);
        int[][] sparseArray = obj.toSparseArray(twoArray);
        System.out.println("稀疏数组");
        obj.printArray(sparseArray);
        System.out.println("二维数组");
        obj.printArray( obj.toTwoArray(sparseArray));
    }


    /**
     * 二维数组转稀疏数组
     *
     * @param twoArray 二维数组
     * @return 稀疏数组
     */
    private int[][] toSparseArray(int[][] twoArray) {

        //@1 validate twoArray
        if (twoArray.length <= 0 || twoArray[0].length <= 0) {
            return new int[0][0];
        }

        //@1 统计二维数组有效数据个数，确定需要构建稀疏数组大小
        int total = 0;
        for (int[] ints : twoArray) {
            for (int i : ints) {
                if (i != 0) {
                    total++;
                }
            }
        }

        //@2 构造二维数组
        int[][] sparseArray = new int[total + 1][3];

        //@3 填充二维数组
        sparseArray[0][0] = twoArray.length;
        sparseArray[0][1] = twoArray[0].length;

        for (int i = 0; i < twoArray.length; i++) {
            for (int j = 0; j < twoArray[i].length; j++) {
                if (twoArray[i][j] != 0) {
                    sparseArray[i + 1][0] = i;
                    sparseArray[i + 1][1] = j;
                    sparseArray[i + 1][2] = twoArray[i][j];
                }
            }
        }
        return sparseArray;
    }

    private int[][] toTwoArray(int[][] sparseArray) {

        //@1 读取稀疏数组第一行，构建二维数组
        int[][] towArray = new int[sparseArray[0][0]][sparseArray[0][1]];

        //@2 读取稀疏数组，填充二维数组
        for (int i = 1; i < sparseArray.length ; i++) {
                towArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        return towArray;
    }

    /**
     * 打印数组
     *
     * @param array 需要打印的数组
     */
    private void printArray(int[][] array) {
        for (int[] ints : array) {
            for (int i : ints) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }

}
