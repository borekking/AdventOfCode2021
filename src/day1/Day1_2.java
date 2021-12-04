package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day1_2 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scanner = new Scanner(file);

        int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt(), lastSum = a+b+c;
        int[] arr = new int[] {a, b, c};
        int count = 0;

        while (scanner.hasNext()) {
            int i = scanner.nextInt();
            swap(arr, i);
            int newSum = sum(arr);

            if (lastSum < newSum)
                count++;

            lastSum = newSum;
        }

        System.out.println(count);
    }

    private static int sum(int[] arr) {
        return Arrays.stream(arr).sum();
    }

    private static void swap(int[] arr, int i) {
        arr[0] = arr[1];
        arr[1] = arr[2];
        arr[2] = i;
    }
}
