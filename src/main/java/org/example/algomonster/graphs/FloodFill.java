package org.example.algomonster.graphs;

/**
 * https://www.youtube.com/watch?v=g6HzWspalpU&list=PLpO3gASfJEIJ6cYs4kAY3SnH2kpohSTZI&index=13
 */
public class FloodFill {

    public static void floodFill(int[][] img, int sr, int sc, int newColor) {
        int oldColor = img[sr][sc];
        dfsFillColor(img, sr, sc, newColor, oldColor);
    }

    private static void dfsFillColor(int[][] img, int sr, int sc, int newColor, int oldColor) {
        if(sr>=0 && sc>=0 && sr<img.length && sc<img[0].length && img[sr][sc]==oldColor) {
            img[sr][sc] = newColor;
            dfsFillColor(img, sr+1, sc, newColor, oldColor);
            dfsFillColor(img, sr-1, sc, newColor, oldColor);
            dfsFillColor(img, sr, sc+1, newColor, oldColor);
            dfsFillColor(img, sr, sc-1, newColor, oldColor);
        }
    }


    public static void main(String[] args) {
        int[][] img = {
                {1, 1, 1, 2, 4},
                {3, 1, 1, 2, 2},
                {2, 1, 2, 2, 5},
                {3, 3, 3, 3, 4}
        };

        System.out.println(img.length + " " + img[0].length);

        floodFill(img, 1, 1, 4);

        System.out.println("Image after new color paint looks like\n");

        for(int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[i].length; j++) {
                System.out.print(img[i][j] + " ");
            }
            System.out.println();
        }
    }
}
