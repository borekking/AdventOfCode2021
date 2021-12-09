package de.borekking.aoc2021.day5;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final Coordinate startPoint, endPoint;
    private final List<Coordinate> coveringPoints;

    public Line(Coordinate startPoint, Coordinate endPoint, boolean getDiagonals) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;

        if (startPoint.getX() == endPoint.getX())
            this.coveringPoints = this.getCoveringPointsHorizontal();
        else if (startPoint.getY() == endPoint.getY())
            this.coveringPoints = this.getCoveringPointsVertical();
        else if (getDiagonals)
            this.coveringPoints = this.getCoveringPointsDiagonal();
        else
            coveringPoints = new ArrayList<>();
    }

    private List<Coordinate> getCoveringPointsHorizontal() {
        int x = this.startPoint.getX();
        List<Coordinate> list = new ArrayList<>();

        if (this.startPoint.getY() < this.endPoint.getY())
            for (int i = this.startPoint.getY(); i <= this.endPoint.getY(); i++)
                list.add(new Coordinate(x, i));
        else
            for (int i = this.startPoint.getY(); i >= this.endPoint.getY(); i--)
                list.add(new Coordinate(x, i));

        return list;
    }

    private List<Coordinate> getCoveringPointsVertical() {
        int y = this.startPoint.getY();
        List<Coordinate> list = new ArrayList<>();

        if (this.startPoint.getX() < this.endPoint.getX())
            for (int i = this.startPoint.getX(); i <= this.endPoint.getX(); i++)
                list.add(new Coordinate(i, y));
        else
            for (int i = this.startPoint.getX(); i >= this.endPoint.getX(); i--)
                list.add(new Coordinate(i, y));

        return list;
    }

    private List<Coordinate> getCoveringPointsDiagonal() {
        List<Coordinate> list = new ArrayList<>();

        // x1 < x2 and y1 < y2
        if (this.startPoint.getX() <= this.endPoint.getX() && this.startPoint.getY() <= this.endPoint.getY()) {
            for (int x = this.startPoint.getX(), y = this.startPoint.getY(); x <= this.endPoint.getX() && y <= this.endPoint.getY(); x++, y++)
                list.add(new Coordinate(x, y));

        // x1 > x2 and y1 < y2
        } else if (this.startPoint.getX() >= this.endPoint.getX() && this.startPoint.getY() <= this.endPoint.getY()) {
            for (int x = this.startPoint.getX(), y = this.startPoint.getY(); x >= this.endPoint.getX() && y <= this.endPoint.getY(); x--, y++)
                list.add(new Coordinate(x, y));

        // x1 < x2 and y1 > y2
        } else if (this.startPoint.getX() <= this.endPoint.getX() && this.startPoint.getY() >= this.endPoint.getY()) {
            for (int x = this.startPoint.getX(), y = this.startPoint.getY(); x <= this.endPoint.getX() && y >= this.endPoint.getY(); x++, y--)
                list.add(new Coordinate(x, y));

        // x1 > x2 and y1 > y2
        } else if (this.startPoint.getX() >= this.endPoint.getX() && this.startPoint.getY() >= this.endPoint.getY()) {
            for (int x = this.startPoint.getX(), y = this.startPoint.getY(); x >= this.endPoint.getX() && y >= this.endPoint.getY(); x--, y--)
                list.add(new Coordinate(x, y));
        }

        return list;
    }

    public String getStartPoint() {
        return this.startPoint.getX() + "," + this.startPoint.getY();
    }

    public String getEndPoint() {
        return this.endPoint.getX() + "," + this.endPoint.getY();
    }

    public List<Coordinate> getCoveringPoints() {
        return coveringPoints;
    }
}
