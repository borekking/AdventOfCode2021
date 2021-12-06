package day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day5_1 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner sc = new Scanner(file);

        List<Line> lines = new ArrayList<>();

        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] s = line.split(" -> ");

            Coordinate a = getCoord(s[0]), b = getCoord(s[1]);
            lines.add(new Line(a, b, false));
        }
        Map<Coordinate, Integer> counter = new HashMap<>();
        for (Line l : lines)
            for (Coordinate arr : l.getCoveringPoints())
                counter.put(arr, counter.getOrDefault(arr, 0) + 1);

        int count = 0;
        for (Coordinate key : counter.keySet())
            if (counter.get(key) >= 2)
                count++;

        System.out.println(count);
    }

    private static Coordinate getCoord(String s) {
        String[] args = s.split(",");
        return new Coordinate(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
    }
}
