/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksort;

public class QuicksortLomuto {

    private int[] data;
    private int len;

    public QuicksortLomuto(int max) {
        data = new int[max];
        len = 0;
    }

    public void quickSort() {
        recursiveQuicksortLomuto(0, len - 1);
    }

    public void recursiveQuicksortLomuto(int left, int right) {

        if (right - left <= 0) {
            return;
        } else {
            long pivot = data[right];
            int partition = lomutoPartition(left, right, pivot);
            recursiveQuicksortLomuto(left, partition - 1);
            recursiveQuicksortLomuto(partition + 1, right);
        }
    }

    int lomutoPartition(int left, int right, long pivot) {
        int i = left;

        for (int j = left; j <= right - 1; j++) {
            if (data[j] <= pivot) {
                swap(j, i);
                i++;
            }
        }
        swap(i, right);
        return i;
    }

    public void swap(int d1, int d2) {
        int temp = data[d1];
        data[d1] = data[d2];
        data[d2] = temp;
    }

    public void insert(int value) {
        data[len] = value;
        len++;
    }

    public static void main(String[] args) {

        int[] Array = {25, 65, 1, 5, 22, 158, 7589, 96, 85, 99, 8888, 35, 6, 98, 68, 88, 33, 333, 55};

        QuicksortLomuto arr = new QuicksortLomuto(Array.length);

        int n;
        for (int i = 0; i < Array.length; i++) {
            n = Array[i];
            arr.insert(n);
        }

        long startTime = System.nanoTime();
        arr.quickSort();
        long endTime = System.nanoTime();
        long estimatedTime = endTime - startTime;
        double seconds;
        seconds = (double) estimatedTime / 1000000;
        System.out.println("\n Lomuto's partitioning algorithmasına göre " + Array.length
                + " sırasız \nsayıların sıralanma süresi \n");
        System.out.println(seconds + " milisaniye");

    }
}



