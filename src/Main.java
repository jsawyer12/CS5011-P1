import java.util.ArrayList;
import java.util.Arrays;

public class Main {

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
        Part1 pt1 = new Part1(map1);
        LinkedList path = new LinkedList(map1[0].length); //nodeCount = 15 for a-o nodes, consider moving into Part1
        Node startPos = new Node(3);
        path.addNode(startPos);
//        path = pt1.depthFirstSearch(path);
//        path.printList();

        ArrayList<LinkedList> paths = new ArrayList<>();
        paths.add(path);
        path = pt1.breadthFirstSearch(paths);
        path.printList();
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
