package org.example.algomonster.graphs;

import java.util.Arrays;

public class WordSearch {

    public static boolean wordFound = false;

    public static void wordFound(char[][] grid, String src) {
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                char[] srcArr = src.toCharArray();
                if(grid[i][j]==srcArr[0] && wordFound==false) {
                    dfsWord(grid, i, j, srcArr, 0);
                }
            }
        }
    }

    private static void dfsWord(char[][] grid, int i, int j, char[] srcArr, int charPtr) {
        if(i>=0 && j>=0 && i<grid.length && j< grid[0].length && charPtr<srcArr.length && grid[i][j]==srcArr[charPtr] && wordFound==false) {
            srcArr[charPtr] = '#';
            int nextCharPtr = iterateSrcArr(srcArr);
            dfsWord(grid, i+1, j, srcArr, nextCharPtr);
            dfsWord(grid, i-1, j, srcArr, nextCharPtr);
            dfsWord(grid, i, j+1, srcArr, nextCharPtr);
            dfsWord(grid, i, j-1, srcArr, nextCharPtr);
            if(iterateSrcArr(srcArr)==srcArr.length) {
                wordFound=true;
            }
        }
    }

    private static int iterateSrcArr(char[] srcArr) {
        for(char c=0; c<srcArr.length; c++) {
            if(srcArr[c]!='#') {
                return c;
            }
        }
        return srcArr.length;
    }

    public static void main(String[] args) {

        char[][] grid = {
                {'A', 'N', 'S', 'Q'},
                {'S', 'O', 'L', 'R'},
                {'K', 'T', 'O', 'G'}
        };
        wordFound(grid, "SOLO");
        System.out.println("Word found in given grid:: "+ wordFound);
    }
}
