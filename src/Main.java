import java.util.ArrayList;

public class Main {

    /**
     * returns array of indexes of next node[s] to go to from current
     * @param map
     * @return
     */
    public static Integer[] getNextStepz(int[][] map, int current) {
        ArrayList<Integer> nextStepz = new ArrayList<>();
        for (int i = 0; i < map[current].length; i++) {
            if (map[current][i] == 8) {
                Integer[] ans = new Integer[] {i};
                return ans;
            }
            if (map[current][i] == 5) {
                nextStepz.add(i);
            }
        }
        Integer[] ans = nextStepz.toArray(new Integer[nextStepz.size()]);
        return ans;
    }

    public static LinkedList depthFirstSearch(LinkedList ll) {

        return null;
    }

    public static void printMap(int[][] map) {
        System.out.print(" ");
        for (int i = 0; i < charSeq.length; i++) {
            System.out.print("  " +charSeq[i]);
        }
        System.out.println();
        for (int i = 0; i < map[0].length; i++) {
            System.out.print(charSeq[i] +" ");
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(" " +map[i][j]);
                if (map[i][j] < 10)
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        printMap(map1);
        getNextStepz(map1, 3);
    }

    public static char[] charSeq = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o'};


    public static int[][] map1 = new int [][] {
            {0, 5, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
            {5, 0, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
            {5, 5, 0, 5, 5, 10, 10, 10, 10, 5, 10, 5, 10, 10, 10 },
            {10, 10, 5, 2, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
            {10, 10, 5, 10, 0, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
            {10, 10, 10, 10, 5, 0, 5, 5, 10, 10, 10, 10, 10, 10, 10 },
            {10, 10, 10, 10, 10, 5, 0, 10, 10, 10, 5, 10, 10, 10, 10 },
            {10, 10, 10, 10, 10, 5, 10, 0, 5, 5, 5, 10, 10, 10, 10 },
            {10, 10, 10, 10, 10, 10, 10, 5, 0, 5, 10, 10, 10, 10, 10 },
            {10, 10, 5, 10, 10, 10, 10, 5, 5, 0, 10, 5, 5, 10, 10 },
            {10, 10, 10, 10, 10, 10, 5, 5, 10, 10, 0, 10, 10, 5, 10 },
            {10, 10, 5, 10, 10, 10, 10, 10, 10, 5, 10, 0, 10, 10, 5 },
            {10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 0, 5, 10 },
            {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 5, 8, 10 },
            {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 0 }
    };

    public static int[][] map2 = new int [][] {
            {0, 5, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
            {5, 0, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
            {5, 5, 0, 5, 5, 10, 10, 10, 10, 5, 10, 5, 10, 10, 10},
            {10, 10, 5, 2, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
            {10, 10, 5, 10, 0, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
            {10, 10, 10, 10, 10, 8, 5, 5, 10, 10, 10, 10, 10, 10, 10},
            {10, 10, 10, 10, 10, 5, 0, 10, 10, 10, 5, 10, 10, 10, 10},
            {10, 10, 10, 10, 10, 5, 10, 0, 5, 5, 5, 10, 10, 10, 10},
            {10, 10, 10, 10, 10, 10, 10, 5, 0, 5, 10, 10, 10, 10, 10},
            {10, 10, 5, 10, 10, 10, 10, 5, 5, 0, 10, 5, 5, 10, 10},
            {10, 10, 10, 10, 10, 10, 5, 5, 10, 10, 0, 10, 10, 5, 10},
            {10, 10, 5, 10, 10, 10, 10, 10, 10, 5, 10, 0, 10, 10, 5},
            {10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 0, 5, 10},
            {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 5, 0, 10},
            {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 0}
    };

    public static int[][] map3 = new int [][] {
            {0, 5, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
            {5, 0, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
            {5, 5, 0, 5, 5, 10, 10, 10, 10, 5, 10, 5, 10, 10, 10},
            {10, 10, 5, 2, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
            {10, 10, 5, 10, 0, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10},
            {10, 10, 10, 10, 5, 0, 5, 5, 10, 10, 10, 10, 10, 10, 10},
            {10, 10, 10, 10, 10, 5, 0, 10, 10, 10, 5, 10, 10, 10, 10},
            {10, 10, 10, 10, 10, 5, 10, 0, 5, 5, 5, 10, 10, 10, 10},
            {10, 10, 10, 10, 10, 10, 10, 5, 0, 5, 10, 10, 10, 10, 10},
            {10, 10, 5, 10, 10, 10, 10, 5, 5, 0, 10, 5, 5, 10, 10},
            {10, 10, 10, 10, 10, 10, 5, 5, 10, 10, 0, 10, 10, 5, 10},
            {10, 10, 5, 10, 10, 10, 10, 10, 10, 5, 10, 0, 10, 10, 10},
            {10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 0, 5, 10},
            {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 5, 0, 10},
            {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 8}
    };

    public static int[][] map4 = new int [][] {
            {2, 5, 5, 10, 10, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10},
            {5, 0, 5, 10, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
            {5, 5, 0, 5, 5, 10, 10, 10, 5, 5, 10, 5, 10, 10, 10},
            {10, 10, 5, 0, 10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 5},
            {10, 5, 5, 10, 0, 5, 10, 5, 10, 10, 10, 10, 10, 10, 10},
            {5, 10, 10, 10, 5, 0, 5, 5, 10, 10, 10, 10, 10, 10, 10},
            {10, 10, 10, 10, 10, 5, 0, 10, 10, 10, 5, 10, 10, 10, 10},
            {10, 10, 10, 10, 5, 5, 10, 0, 5, 5, 5, 10, 10, 10, 10},
            {10, 10, 5, 10, 10, 10, 10, 5, 0, 5, 10, 5, 10, 5, 10},
            {10, 10, 5, 10, 10, 10, 10, 5, 5, 0, 10, 5, 5, 10, 10},
            {10, 10, 10, 10, 10, 10, 5, 5, 10, 10, 0, 10, 10, 5, 10},
            {10, 10, 5, 5, 10, 10, 10, 10, 5, 5, 10, 0, 10, 10, 10},
            {10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 8, 5, 5},
            {10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 5, 10, 5, 0, 5},
            {10, 10, 10, 5, 10, 10, 10, 10, 10, 10, 10, 10, 5, 5, 0}
    };

    public static int[][] map5 = new int [][] {
            {0, 5, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
            {5, 0, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
            {5, 5, 0, 5, 5, 10, 10, 10, 10, 10, 10, 5, 10, 10, 10},
            {10, 10, 5, 2, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
            {10, 10, 5, 10, 0, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10},
            {10, 10, 10, 10, 5, 0, 5, 5, 10, 10, 10, 10, 10, 10, 10},
            {10, 10, 10, 10, 10, 5, 0, 10, 10, 10, 10, 10, 10, 10, 10},
            {10, 10, 10, 10, 10, 5, 10, 0, 5, 10, 5, 10, 10, 10, 10},
            {10, 10, 10, 10, 10, 10, 10, 5, 0, 5, 10, 10, 10, 10, 10},
            {10, 10, 10, 10, 10, 10, 10, 10, 5, 0, 10, 10, 5, 10, 10},
            {10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 0, 10, 10, 5, 10},
            {10, 10, 5, 10, 10, 10, 10, 10, 10, 10, 10, 0, 10, 10, 5},
            {10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 0, 5, 10},
            {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 5, 8, 10},
            {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 0}
    };

    public static int[][] map6 = new int [][] {
            {2, 5, 10, 10, 5, 10, 10},
            {5, 0, 5, 10, 10, 10, 10},
            {10, 5, 0, 5, 10, 10, 10},
            {10, 10, 5, 8, 10, 10, 5},
            {5, 10, 10, 10, 0, 5, 10},
            {10, 10, 10, 10, 5, 0, 5},
            {10, 10, 10, 5, 10, 5, 0}
    };

    public static int[][] map7 = new int [][] {
            {0, 5, 10, 10, 10, 10, 10},
            {5, 0, 5, 10, 10, 10, 10},
            {10, 5, 2, 5, 10, 10, 10},
            {10, 10, 5, 0, 10, 10, 5},
            {10, 10, 10, 10, 8, 10, 10},
            {10, 10, 10, 10, 10, 0, 5},
            {10, 10, 10, 5, 10, 5, 0}
    };

    public static int[][] map8 = new int [][] {
            {0, 5, 10, 10, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
            {5, 8, 5, 10, 10, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
            {10, 5, 0, 5, 10, 10, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10},
            {10, 10, 5, 0, 10, 10, 10, 5, 10, 10, 10, 10, 10, 10, 10, 10},
            {5, 10, 10, 10, 0, 5, 10, 10, 5, 10, 10, 10, 10, 10, 10, 10},
            {10, 5, 10, 10, 5, 0, 5, 10, 10, 5, 10, 10, 10, 10, 10, 10},
            {10, 10, 5, 10, 10, 5, 0, 5, 10, 10, 5, 10, 10, 10, 10, 10},
            {10, 10, 10, 5, 10, 10, 5, 0, 10, 10, 10, 5, 10, 10, 10, 10},
            {10, 10, 10, 10, 5, 10, 10, 10, 0, 5, 10, 10, 5, 10, 10, 10},
            {10, 10, 10, 10, 10, 5, 10, 10, 5, 0, 5, 10, 10, 5, 10, 10},
            {10, 10, 10, 10, 10, 10, 5, 10, 10, 5, 0, 5, 10, 10, 5, 10},
            {10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 5, 0, 10, 10, 10, 5},
            {10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 10, 0, 5, 10, 10},
            {10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 5, 0, 5, 10},
            {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 5, 2, 5},
            {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 5, 0}
    };

    public static int[][] map9 = new int [][] {
            {0, 5, 10, 10, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
            {5, 0, 5, 10, 10, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
            {10, 5, 0, 5, 10, 10, 5, 10, 10, 10, 10, 10, 10, 10, 10, 10},
            {10, 10, 5, 0, 10, 10, 10, 5, 10, 10, 10, 10, 10, 10, 10, 10},
            {5, 10, 10, 10, 0, 5, 10, 10, 5, 10, 10, 10, 10, 10, 10, 10},
            {10, 5, 10, 10, 5, 0, 10, 10, 10, 5, 10, 10, 10, 10, 10, 10},
            {10, 10, 5, 10, 10, 10, 0, 5, 10, 10, 5, 10, 10, 10, 10, 10},
            {10, 10, 10, 5, 10, 10, 5, 2, 10, 10, 10, 5, 10, 10, 10, 10},
            {10, 10, 10, 10, 5, 10, 10, 10, 0, 5, 10, 10, 5, 10, 10, 10},
            {10, 10, 10, 10, 10, 5, 10, 10, 5, 8, 10, 10, 10, 10, 10, 10},
            {10, 10, 10, 10, 10, 10, 5, 10, 10, 10, 0, 5, 10, 10, 5, 10},
            {10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 5, 0, 10, 10, 10, 5},
            {10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 10, 0, 5, 10, 10},
            {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 0, 5, 10},
            {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 5, 0, 5},
            {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 5, 10, 10, 5, 0}
    };
}