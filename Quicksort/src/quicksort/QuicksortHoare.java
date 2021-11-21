/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksort;

public class QuicksortHoare {

    private int[] data;
    private int len;

    public QuicksortHoare(int max) {
        data = new int[max];
        len = 0;
    }

    public void quickSort() {
        recursiveQuicksortHoare(0, len - 1);
    }

    public void recursiveQuicksortHoare(int left, int right) {

        if (right - left <= 0) {
            return;
        } else {
            int partition = hoarePartition(left, right);
            recursiveQuicksortHoare(left, partition - 1);
            recursiveQuicksortHoare(partition + 1, right);
        }
    }

    int hoarePartition(int left, int right) {
        int p = data[left];
        int i = left - 1;
        int j = right + 1;

        while (true) {
            do {
                j--;
            } while (data[j] > p);
            do {
                i++;
            } while (data[i] < p);
            if (i < j) {
                swap(i, j);
            } else {
                return j;
            }
        }
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

        QuicksortHoare arr = new QuicksortHoare(Array.length);

        int n;
        for (int i = 0; i < Array.length; i++) {
            n = Array[i];
            arr.insert(n);
        }

        long startTime = System.nanoTime();
        arr.quickSort();
        long endTime = System.nanoTime();
        long estimatedTime = endTime - startTime; // Geçen süreyi milisaniye cinsinden elde ediyoruz
        double seconds;
        seconds = (double) estimatedTime / 1000000;
        System.out.println("\n Hoare's partitioning algorithmasına göre " + Array.length
                + " sırasız \nsayıların sıralanma süresi \n");
        System.out.println(seconds + " milisaniye");

    }
}

