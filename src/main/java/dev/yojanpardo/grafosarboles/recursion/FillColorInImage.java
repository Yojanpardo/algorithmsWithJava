package dev.yojanpardo.grafosarboles.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static dev.yojanpardo.grafosarboles.recursion.NumberOfIslands.printMatrix;

public class FillColorInImage {
    public static void main(String[] args) {

        List<Double> list = new ArrayList<>();

        list.add(5.4);
        list .add(1.2);

        Optional<Double> opt = list.stream().sorted().findFirst();
        System.out.print(opt.get() + " " + list.get(0));

        int[][] image = buildImage();
        System.out.println("Here is the original image");
        printMatrix(image);

        paintImage(image, 1, 1, 2);

        System.out.println("here is the modified image");
        printMatrix(image);
    }

    private static void paintImage(int[][] image, int sr, int rc, int newColor) {
        int color = image[sr][rc];
        if(color != newColor){
            dfs(image, sr, rc, color, newColor);
        }
    }

    private static void dfs(int[][] image, int r, int c, int color, int newColor) {
        if(image[r][c] == color){
            printMatrix(image);
            image[r][c] = newColor;
            if(r >= 1) dfs(image, r - 1, c, color, newColor);
            if(c >= 1) dfs(image, r, c - 1, color, newColor);
            if(r + 1 < image.length) dfs(image, r + 1, c, color, newColor);
            if(c + 1 < image[0].length) dfs(image, r, c + 1, color, newColor);
        }

    }

    private static int[][] buildImage() {
        return new int[][] {
                {1,1,1,1},
                {1,1,0,1},
                {1,0,1,0}
        };
    }
}
