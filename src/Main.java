import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Maps mapSet = new Maps();
        int[][] map = mapSet.getMap1();

        Locations locSet = new Locations();
        int[][] loc = locSet.getLoc1();

        mapSet.printMap(map);
        Part1 pt1 = new Part1(map);

        if (pt1.isPossible()) { // checks if there are connections to endPoint, will add comprehensive one if time
            LinkedList path = pt1.startDFS();
            System.out.print("DFS Path: ");
            path.printList();

            LinkedList path2 = pt1.startBFS();
            System.out.print("BFS Path: ");
            path2.printList();
        }
        else {
            System.out.println("Not possible, no nodes connecting to end node.");
        }


//        locSet.printWorld(loc);
//        Part2 pt2 = new Part2(map, loc);
//
//        if (pt2.isPossible()) { // checks if there are connections to endPoint, will add comprehensive one if time
//            LinkedList path = pt2.startBFS();
//            System.out.print("Best First Path: ");
//            path.printList();
//
//            LinkedList path2 = pt2.startASS();
//            System.out.print("A Star Path    : ");
//            path2.printList();
//        }
//        else {
//            System.out.println("Not possible, no nodes connecting to end node.");
//        }
    }
}
