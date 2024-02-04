package dev.yojanpardo.grafosarboles.recursion;

public class NumberOfIslands {

    public static void main(String[] args) {
        int[][] map = buildMap();

        System.out.printf("islands found: [%d]\n", findNumberOfIslands(map));
    }

    private static int findNumberOfIslands(int[][] map) {
        if(map == null || map.length == 0){
            return 0;
        }

        printMatrix(map);

        int numberOfIslands = 0;

        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                if(map[i][j] == 1){
                    numberOfIslands += dfs(map, i, j);
                    printMatrix(map);
                }
            }
        }

        return numberOfIslands;
    }

    private static int dfs(int[][] map, int i, int j) {
        if(i < 0 || j < 0 || i >= map.length || j >= map[i].length || map[i][j] == 0){
            return 0;
        }

        // mark point as visited
        map[i][j] = 0;
        // move right
        dfs(map, i + 1, j);
        // move left
        dfs(map, i+1, j);
        // move down
        dfs(map, i, j+1);
        // move up
        dfs(map, i, j-1);

        return 1;
    }

    public static void printMatrix(int[][] map){
        for (int[] ints : map) {
            for (int j = 0; j < ints.length; j++) {
                System.out.print(ints[j]);
                if (j == ints.length - 1) {
                    System.out.print("\n");
                } else {
                    System.out.print(", ");
                }
            }
        }
        System.out.println("----------------");
    }
    private static int[][] buildMap() {
        return new int[][] {
            {0,0,0,0,1,1,0,0},
            {0,1,1,1,0,0,0,1},
            {0,1,1,0,0,1,1,1},
            {0,0,0,0,0,1,1,0},
        };
    }
}
