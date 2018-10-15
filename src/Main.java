public class Main {

    public static void main(String[] args) {

        Maps mapSet = new Maps();
        int mapNumber = Integer.parseInt(args[0]) - 1;
        int[][] map = mapSet.getMap(mapNumber);

        Locations locSet = new Locations();
        int[][] loc = locSet.getLoc(mapNumber);

        mapSet.printMap(map);
        Part1 pt1 = new Part1(map);

        if (pt1.isPossible()) { // checks if there are connections to endPoint, will add comprehensive one if time
            LinkedList path = pt1.startDFS();
            System.out.print("DFS Cost: " +pt1.getdFSCost()  +", Path: ");
            path.printList();

            LinkedList path2 = pt1.startBFS();
            System.out.print("BFS Cost: " +pt1.getbFSCost() +", Path: ");
            path2.printList();
        }
        else {
            System.out.println("Not possible, no nodes connecting to end node.");
        }


        locSet.printWorld(loc);
        Part2 pt2 = new Part2(map, loc);

        if (pt2.isPossible()) { // checks if there are connections to endPoint, will add comprehensive one if time
            LinkedList path = pt2.startBFS();
            System.out.print("Best First Cost: " +pt2.getbFSCost() +", Path: ");
            path.printList();

            LinkedList path2 = pt2.startASS();
            System.out.print("A Star Cost    : " +pt2.getaSSCost() +", Path: ");
            path2.printList();
        }
        else {
            System.out.println("Not possible, no nodes connecting to end node.");
        }
    }
}
