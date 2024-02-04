package dev.yojanpardo;

public class ReordenarColores {
    public static void main(String[] args) {
        int[] colores = {2,0,1,2,1,0};
        ordenarColores(colores);
        for (int color : colores) {
            System.out.println(color);
        }
    }

    private static void ordenarColores(int[] colores) {
        int low = 0;
        int mid = 0;
        int high = colores.length - 1;
        int temp;

        while(mid<= high) {
            switch (colores[mid]) {
                case 0 -> {
                    temp = colores[low];
                    colores[low] = colores[mid];
                    colores[mid] = temp;
                    low++;
                    mid++;
                }
                case 1 -> mid++;
                case 2 -> {
                    temp = colores[mid];
                    colores[mid] = colores[high];
                    colores[high] = temp;
                    high--;
                }
            }
        }
    }
}
