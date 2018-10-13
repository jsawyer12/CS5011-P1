import java.util.Arrays;

public class Part2 {

    private int[][] map;
    private int[][] loc;
    private int startInd;
    private int endInd;
    private int nodeCount;

    private LinkedList aSSPath; // A star search path

    private LinkedList bFSPath; // best first search path

    public Part2(int[][] map, int[][] loc) {
        this.map = map;
        this.loc = loc;

        nodeCount = map[0].length;
        findStartEndIndices();

        Node startPos = new Node(startInd);

        bFSPath = new LinkedList(nodeCount);
        bFSPath.addNode(startPos);

        aSSPath = new LinkedList(nodeCount);
        aSSPath.addNode(startPos);
    }

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

    private void findStartEndIndices() {
        for (int i = 0; i < nodeCount; i++) {
            if (map[i][i] == 2)
                startInd = i;
            if (map[i][i] == 8)
                endInd = i;
        }
    }

    public LinkedList startBFS() {
        return bestFirstSearch(bFSPath);
    }

    private LinkedList bestFirstSearch(LinkedList ll) {
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

    public int[] getBestestMoves(int current, LinkedList ll) { // OPTIMIZE

        double[] moveDists = new double[map[0].length]; //index = node, value = dist
        int moveCount = 0;
        for (int k = 0; k < map[current].length; k++) {
            if (map[current][k] == 5) {
                if (map[k][k] == 8) {
                    return new int[] {k};
                }
                if (!ll.hasOccured(k)) {
                    moveDists[k] = getDistance(loc[k], loc[endInd]);
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
        System.out.println("Bestest moves: " + Arrays.toString(nodeIndexPrioritizedOrder));
        return nodeIndexPrioritizedOrder;
    }

    public double getDistance(int[] start, int[] end) {
        return Math.sqrt((end[1] - start[1]) * (end[1] - start[1]) + (end[0] - start[0]) * (end[0] - start[0]));
    }
}
