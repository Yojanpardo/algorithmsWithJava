package dev.yojanpardo.grafosarboles.recursion;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

import static dev.yojanpardo.grafosarboles.recursion.NumberOfIslands.printMatrix;

public class RottingOranges {

    private static final Set<Point> VISITED_ROTTEN_ORANGES = new LinkedHashSet<>();

    private static final Set<Point> SPREAD_DIRECTIONS = Set.of(
            new Point(1,0),
            new Point(0,1),
            new Point(-1,0),
            new Point(0,-1)
    );

    private static int healthyOranges = 0;
    public static void main(String[] args) {
        final int[][] orangesBox = buildOrangesBox();
        System.out.println("here is the oranges box: ");
        printMatrix(orangesBox);

        int daysForAllOrangesGetRotten = calculateDaysUntilAllOrangesRot(orangesBox);

        if(healthyOranges == 0) {
            System.out.printf("Days required for oranges to be rotten: [%d]\n", daysForAllOrangesGetRotten);
        } else {
            System.out.printf("all oranges could not get rotten, there are [%d] oranges healthy.\n", healthyOranges);
        }
    }

    /**
     * returns the quantity of days required to the adjacent healthy oranges to rotten ones to be rotten
     * a healthy orange gets rotten when past a day besides to a rotten orange
     *
     * @param orangesBox with the oranges distribution
     * @return the quantity of days required for oranges to get rotten
     */
    private static int calculateDaysUntilAllOrangesRot(int[][] orangesBox) {
        if(Objects.isNull(orangesBox) || orangesBox.length == 0){
            return 0;
        }

        final Queue<Point> rottenOranges = new LinkedList<>();

        for(int x = 0; x < orangesBox.length; x++){
            for(int y = 0; y < orangesBox[x].length; y++){
                if(orangesBox[x][y] == 2){
                    final Point rottenOrange = new Point(x,y);
                    rottenOranges.addAll(getAdjacentHealthyOranges(rottenOrange, orangesBox));
                    VISITED_ROTTEN_ORANGES.add(rottenOrange);
                } else if(orangesBox[x][y] == 1) {
                    healthyOranges++;
                }
            }
        }

        return spreadRotThroughOranges(rottenOranges, orangesBox);
    }

    private static int spreadRotThroughOranges(final Queue<Point> adjacentOranges, int[][] orangesBox) {
        int days = 0;

        while (!adjacentOranges.isEmpty()){

            int size = adjacentOranges.size();

            for(int i = 0; i < size; i++){
                Point healthyOrange = adjacentOranges.poll();
                if(Objects.nonNull(healthyOrange)){
                    orangesBox[healthyOrange.getX()][healthyOrange.getY()] = 2;
                    healthyOranges--;
                    adjacentOranges.addAll(getAdjacentHealthyOranges(healthyOrange, orangesBox));
                }
            }

            printMatrix(orangesBox);

            days ++;
        }

        return days;
    }

    private static Queue<Point> getAdjacentHealthyOranges(Point point, int[][] orangesBox) {
        final Queue<Point> adjacentOranges = new LinkedList<>();

        for(Point direction : SPREAD_DIRECTIONS){
            Point newDirection = new Point(point.getX() + direction.getX(), point.getY() + direction.getY());

            if(newDirection.getX() >= 0
                    && newDirection.getY() >= 0
                    && newDirection.getX() < orangesBox.length
                    && newDirection.getY() < orangesBox[newDirection.getX()].length
                    && !VISITED_ROTTEN_ORANGES.contains(newDirection)
                    && orangesBox[newDirection.getX()][newDirection.getY()] == 1
            ) {
                VISITED_ROTTEN_ORANGES.add(newDirection);
                adjacentOranges.add(newDirection);
            }
        }

        return adjacentOranges;
    }

    /**
     * this method builds an oranges box
     * 0 is an empty space in the box
     * 1 is a healthy orange
     * 2 is a rotten orange
     * @return an n*m matrix with oranges
     */
    private static int[][] buildOrangesBox() {
        return new int[][] {
                {1,1,1,0},
                {1,0,1,1},
                {1,2,0,0},
                {1,1,1,1},
        };
    }
}
