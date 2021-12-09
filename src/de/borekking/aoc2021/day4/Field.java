package de.borekking.aoc2021.day4;

public class Field {

    private final int[][] numbers;
    private final boolean[][] boos;

    public Field(int[][] numbers) {
        this.numbers = numbers;
        this.boos = new boolean[5][5];
    }

    public boolean bingo() {
        // Horizontal
        for (boolean[] arr : this.boos)
            if (this.allTrue(arr))
                return true;


        // Vertical
        Outer:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (!this.boos[j][i]) {
                    continue Outer;
                }
            }
            return true;
        }

        return false;
    }

    public void add(int n) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (this.numbers[i][j] == n) {
                    this.boos[i][j] = true;
                    return;
                }
            }
        }
    }

    public int getUnmarkedSum() {
        int sum = 0;
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                if (!this.boos[i][j])
                    sum+=this.numbers[i][j];
        return sum;
    }

    private boolean allTrue(boolean[] arr) {
        for (boolean b : arr)
            if (!b)
                return false;
        return true;
    }
}
