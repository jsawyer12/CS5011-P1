public class Part2 {

    private int[][] map;
    private int startInd;
    private int nodeCount;

    private LinkedList aSSPath; // A star search path

    private LinkedList bFSPath; // best first search path

    public Part2(int[][] map) {
        this.map = map;

        nodeCount = map[0].length;
        startInd = findStartInd();

        Node startPos = new Node(startInd);


        aSSPath = new LinkedList(nodeCount);
        aSSPath.addNode(startPos);

        bFSPath = new LinkedList(nodeCount);
        bFSPath.addNode(startPos);
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

    private int findStartInd() {
        for (int i = 0; i < nodeCount; i++) {
            if (map[i][i] == 2)
                return i;
        }
        return 0;
    }

//    public LinkedList startBFS() {
//
//    }

//    private LinkedList bestFirstSearch() {
//
//    }

    public double getDistance(int[] start, int[] end) {
        return Math.sqrt((end[1] - start[1]) * (end[1] - start[1]) + (end[0] - start[0]) * (end[0] - start[0]));
    }
}
