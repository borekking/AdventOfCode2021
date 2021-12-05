package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day4_1 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner sc = new Scanner(file);

        int[] numbers = getNumbers(sc.nextLine());

        List<Field> fields = new ArrayList<>();
        while (sc.hasNext()) fields.add(getField(sc));

        Outer:
        for (int current : numbers) {
            for (Field field : fields)
                field.add(current);

            for (Field field : fields) {
                if (field.bingo()) {
                    System.out.println(field.getUnmarkedSum() * current);
                    break Outer;
                }
            }
        }
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
