import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Maps mapSet = new Maps();

        printMap(mapSet.getMap9());
//        Part1 pt1 = new Part1(mapSet.getMap9());
//
//        if (pt1.isPossible()) { // checks if there are connections to endPoint, will add comprehensive one if time
//            LinkedList path = pt1.startDFS();
//            System.out.print("DFS Path: ");
//            path.printList();
//
//            LinkedList path2 = pt1.startBFS();
//            System.out.print("BFS Path: ");
//            path2.printList();
//        }
//        else {
//            System.out.println("Not possible, no nodes connecting to end node.");
//        }

        int[] start = new int[] {1, 2};
        int[] end = new int[] {-1, 2};
        Part2 pt2 = new Part2(mapSet.getMap1());
        System.out.println(pt2.getDistance(start, end));
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

    public static char[] charSeq = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p'};
}
