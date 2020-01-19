package OnlineCoding;

import java.util.ArrayList;
import java.util.List;

public class WordSearch
{
    static int[][] directions = new int[][]
            {
                    {-1,1,0,0},
                    {0,0,-1,1}
            };
    public static void main(String[] args)
    {
        char [][] input = new char[][] {
                {'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'}
        };

        boolean result = false;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                result = result || findWord("ABCESEEE", 0, new ArrayList<>(), input, i, j);
            }
        }
        System.out.println(result);

    }

    private static boolean findWord(String word, int index, List<Coordinate> taken, char[][] input, int x, int y)
    {
        if (word.charAt(index) != input[x][y]) return false;
        index++;
        if (index == word.length()) return true;
        boolean result = false;
        taken.add(new Coordinate(x,y));
        for (int i = 0; i < directions[0].length; i++) {
            int nextx = (x + directions[0][i]);
            int nexty = (y + directions[1][i]);
            if (nextx >= 0 && nextx < input.length && nexty >= 0 && nexty < input[0].length) {
                Coordinate next = new Coordinate(nextx, nexty);
                if (!taken.contains(next)) {
                    result = result || findWord(word, index, taken, input, nextx, nexty);
                }
            }
        }
        taken.remove(new Coordinate(x,y));
        return result;
    }


    static class Coordinate
    {
        int x;
        int y;

        public Coordinate (int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o) { return true; }
            if (!(o instanceof Coordinate)) { return false; }

            Coordinate that = (Coordinate) o;

            if (x != that.x) { return false; }
            return y == that.y;
        }

        @Override
        public int hashCode()
        {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

}
