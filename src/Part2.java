public class Part2 {

    private int[][] map;
    private int[][] loc;
    private int startInd;
    private int endInd;
    private int nodeCount;

    private LinkedList aSSPath; // A star search path
    private int aSSCost; // number of states for A* Search

    private LinkedList bFSPath; // best first search path
    private int bFSCost; // number of states for Best First Search

    public Part2(int[][] map, int[][] loc) {
        this.map = map;
        this.loc = loc;

        nodeCount = map[0].length;
        findStartEndIndices();

        Node startPos = new Node(startInd);

        bFSPath = new LinkedList(nodeCount);
        bFSPath.addNode(startPos);
        bFSCost = 0;

        aSSPath = new LinkedList(nodeCount);
        aSSPath.addNode(startPos);
        aSSCost = 0;
    }

    public int getbFSCost() {
        return bFSCost;
    }

    public int getaSSCost() {
        return aSSCost;
    }

    /**
     * will check to see if the end goal can be reached by any nodes and
     * won’t run the algorithms if it isn’t possible
     * @return
     */
    public boolean isPossible() {
        for (int i = 0; i < map[0].length; i++) {
            if (map[i][i] == 8) {
                for (int k = 0; k < map[i].length; k++) {
                    if (map[i][k] == 5)
                        return true;
                }
            }
        }
        return false;
    }

    /**
     * a quick algorithm to find the start and end indices by looking for
     * a 2 and 8 on the diagonal of the map array.
     */
    private void findStartEndIndices() {
        for (int i = 0; i < nodeCount; i++) {
            if (map[i][i] == 2)
                startInd = i;
            if (map[i][i] == 8)
                endInd = i;
        }
    }

    /**
     * Calls A*, sets the aSSPath and returns it to the main
     * @return
     */
    public LinkedList startASS() {
        return aStarSearch(aSSPath);
    }

    /**
     * chooses the next node based on how far away it is from the current node
     * and the goal, then recurses until it finds the full path to the goal
     * @param ll
     * @return
     */
    private LinkedList aStarSearch(LinkedList ll) {
        aSSCost++;
        System.out.print("Step " +aSSCost +": ");
        ll.printList();
        int current = ll.getTail().data();
        int[] nextMoves = getAStarMoves(current, ll);
        for (int i = 0; i < nextMoves.length; i++) {
            current = ll.getTail().data();
            if (map[current][current] == 8)
                return ll;
            Node newNode = new Node(nextMoves[i]);
            ll.addNode(newNode);
            ll = aStarSearch(ll);
            current = ll.getTail().data();
        }
        if (map[current][current] != 8) {
            ll.dropNode();
        }
        return ll;
    }

    /**
     * The first part of this method assigns a distance for each index / node
     * that is a valid next move. The second part of this method organizes the
     * moves in order of least distance to greatest distance from the current
     * node to the next node plus the distance from the next node to the goal and
     * returns an int array of the indexes of the nodes in that order.
     * @param current
     * @param ll
     * @return
     */
    private int[] getAStarMoves(int current, LinkedList ll) {
        double[] moveDists = new double[map[0].length]; //index = node, value = dist
        int moveCount = 0;
        double pathDist = getPathDist(ll);
        // get cost of path thusfar, add to dist to whatever node is being checked,
        // and add dist from that node to end goal
        for (int k = 0; k < map[current].length; k++) {
            if (map[current][k] == 5) {
                if (map[k][k] == 8) { // if goal is an option, return only that option
                    return new int[] {k};
                }
                if (!ll.hasOccurred(k)) {
                    moveDists[k] = getDistance(loc[current], loc[k]) + getDistance(loc[k], loc[endInd]) + pathDist;
                    moveCount++;
                }
            }
        }
        int[] nodeIndexPrioritizedOrder = new int[moveCount];
        while (moveCount > 0) {
            double max = 0;
            int indexToAdd = 0;
            for (int k = 0; k < moveDists.length; k++) {
                if (moveDists[k] > max) {
                    indexToAdd = k;
                    max = moveDists[k];
                }
            }
            nodeIndexPrioritizedOrder[moveCount-1] = indexToAdd;
            moveDists[indexToAdd] = 0;
            moveCount--;
        }
        return nodeIndexPrioritizedOrder;
    }

    /**
     * calculates the distance the robot has travelled thus far
     * @param ll
     * @return
     */
    private double getPathDist(LinkedList ll) {
        double distance = 0;
        Node temp = ll.getHead();
        while (temp.next() != null) {
            distance += getDistance(loc[temp.data()], loc[temp.next().data()]);
            temp = temp.next();
        }
        return distance;
    }

    public LinkedList startBFS() {
        return bestFirstSearch(bFSPath);
    }

    /**
     * chooses the next node based on if it's the closest to the end goal,
     * then recurses until it reaches the goal
     * @param ll
     * @return
     */
    private LinkedList bestFirstSearch(LinkedList ll) {
        bFSCost++;
        System.out.print("Step " +bFSCost +": ");
        ll.printList();
        int current = ll.getTail().data();
        int[] nextMoves = getBestestMoves(current, ll);
        for (int i = 0; i < nextMoves.length; i++) {
            current = ll.getTail().data();
            if (map[current][current] == 8)
                return ll;
            Node newNode = new Node(nextMoves[i]);
            ll.addNode(newNode);
            ll = bestFirstSearch(ll);
            current = ll.getTail().data();
        }
        if (map[current][current] != 8) {
            ll.dropNode();
        }
        return ll;
    }

    /**
     * The first part of this method assigns a distance for each index / node
     * that is a valid next move. The second part of this method organizes the
     * moves in order of least distance to greatest distance from the goal and
     * returns an int array of the indexes of the nodes in that order.
     * @param current
     * @param ll
     * @return
     */
    private int[] getBestestMoves(int current, LinkedList ll) {
        double[] moveDists = new double[map[0].length]; //index = node, value = dist
        int moveCount = 0;
        for (int k = 0; k < map[current].length; k++) {
            if (map[current][k] == 5) {
                if (map[k][k] == 8) {
                    return new int[] {k}; // if this node is goal, return only it
                }
                if (!ll.hasOccurred(k)) { // if its connected and hasn't been visited, add it
                    moveDists[k] = getDistance(loc[k], loc[endInd]);
                    moveCount++;
                }
            }
        }
        int[] nodeIndexPrioritizedOrder = new int[moveCount];
        while (moveCount > 0) { // while moves still need to be ordered
            double max = 0;
            int indexToAdd = 0;
            for (int k = 0; k < moveDists.length; k++) { // for available moves
                if (moveDists[k] > max) { // if it's the greatest distance
                    indexToAdd = k; // set the index to the greatest distance
                    max = moveDists[k]; // set it to 0 so it's not picked again
                }
            }
            nodeIndexPrioritizedOrder[moveCount-1] = indexToAdd;
            moveDists[indexToAdd] = 0;
            moveCount--;
        }
        return nodeIndexPrioritizedOrder;
    }

    /**
     * Simple algorithm that returns the euclidean distance between two points
     * on the grid
     * @param start
     * @param end
     * @return
     */
    public double getDistance(int[] start, int[] end) {
        return Math.sqrt((end[1] - start[1]) * (end[1] - start[1]) + (end[0] - start[0]) * (end[0] - start[0]));
    }
}
