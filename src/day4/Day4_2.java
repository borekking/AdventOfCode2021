package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day4_2 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner sc = new Scanner(file);

        int[] numbers = getNumbers(sc.nextLine());

        List<Field> fields = new ArrayList<>();
        while (sc.hasNext()) fields.add(getField(sc));
        boolean[] checkedFields = new boolean[fields.size()];

        Outer:
        for (int current : numbers) {
            for (int i = 0; i < fields.size(); i++) {
                if (checkedFields[i]) continue;

                fields.get(i).add(current);
            }

            for (int i = 0; i < fields.size(); i++) {
                if (checkedFields[i]) continue;

                Field field = fields.get(i);
                if (field.bingo()) checkedFields[i] = true;

                if (allTrue(checkedFields)) {
                    System.out.println(field.getUnmarkedSum() * current);
                    break Outer;
                }
            }
        }
    }

    private static boolean allTrue(boolean[] arr) {
        for (boolean b : arr)
            if (!b) return false;
        return true;
    }

    private static int[] getNumbers(String s) {
        return Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
    }

    private static Field getField(Scanner sc) {
        int[][] nums = new int[5][5];
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                nums[i][j] = sc.nextInt();
        return new Field(nums);
    }
}
